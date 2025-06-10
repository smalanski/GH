package com.greenhouse.controller.web;

import com.greenhouse.dto.VegetableDto;
import com.greenhouse.model.Greenhouse;
import com.greenhouse.model.Vegetable;
import com.greenhouse.service.GreenhouseService;
import com.greenhouse.service.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

import java.time.LocalDate;
//import java.util.List;

@Controller
@RequestMapping("/vegetables")
public class VegetableWebController {

    private final VegetableService vegetableService;
    private final GreenhouseService greenhouseService;

    @Autowired
    public VegetableWebController(VegetableService vegetableService, GreenhouseService greenhouseService) {
        this.vegetableService = vegetableService;
        this.greenhouseService = greenhouseService;
    }

    @GetMapping
    public String listVegetables(Model model) {
        model.addAttribute("vegetables", vegetableService.getAllVegetables());
        return "vegetable/list";
    }

    @GetMapping("/{id}")
    public String viewVegetable(@PathVariable Long id, Model model) {
        try {
            model.addAttribute("vegetable", vegetableService.getVegetableById(id));
            return "vegetable/view";
        } catch (RuntimeException e) {
            return "redirect:/vegetables";
        }
    }    @GetMapping("/new")
    public String showCreationForm(Model model) {
        VegetableDto vegetableDto = new VegetableDto();
        vegetableDto.setPlantingDate(LocalDate.now());
        
        model.addAttribute("vegetable", vegetableDto);
        model.addAttribute("greenhouses", greenhouseService.findAllGreenhouses());
        return "vegetable/form";
    }

    @GetMapping("/new/greenhouse/{greenhouseId}")
    public String showCreationFormForGreenhouse(@PathVariable Long greenhouseId, Model model) {
        Greenhouse greenhouse = greenhouseService.findGreenhouseById(greenhouseId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid greenhouse Id:" + greenhouseId));
        
        VegetableDto vegetableDto = new VegetableDto();
        vegetableDto.setGreenhouseId(greenhouseId);
        vegetableDto.setPlantingDate(LocalDate.now());
        
        model.addAttribute("vegetable", vegetableDto);
        model.addAttribute("greenhouse", greenhouse);
        model.addAttribute("greenhouses", greenhouseService.findAllGreenhouses());
        return "vegetable/form";
    }

    @PostMapping("/save")
    public String saveVegetable(@Valid @ModelAttribute("vegetable") VegetableDto vegetableDto,
                              BindingResult bindingResult,
                              Model model,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("greenhouses", greenhouseService.findAllGreenhouses());
            return "vegetable/form";
        }
        
        try {
            // Convert DTO to entity
            Vegetable vegetable;
            if (vegetableDto.getId() != null) {
                vegetable = vegetableService.getVegetableById(vegetableDto.getId());
            } else {
                vegetable = new Vegetable();
            }
            
            vegetable.setName(vegetableDto.getName());
            vegetable.setVariety(vegetableDto.getVariety());
            vegetable.setPlantingDate(vegetableDto.getPlantingDate());
            vegetable.setExpectedHarvestDate(vegetableDto.getExpectedHarvestDate());
            vegetable.setNotes(vegetableDto.getNotes());
            
            Vegetable savedVegetable = vegetableService.saveVegetable(vegetable, vegetableDto.getGreenhouseId());
            redirectAttributes.addFlashAttribute("message", "Vegetable saved successfully");
            return "redirect:/vegetables/" + savedVegetable.getId();
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/vegetables/new";
        }
    }    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        try {
            Vegetable vegetable = vegetableService.getVegetableById(id);
            
            // Convert entity to DTO
            VegetableDto vegetableDto = new VegetableDto();
            vegetableDto.setId(vegetable.getId());
            vegetableDto.setName(vegetable.getName());
            vegetableDto.setVariety(vegetable.getVariety());
            vegetableDto.setGreenhouseId(vegetable.getGreenhouse().getId());
            vegetableDto.setPlantingDate(vegetable.getPlantingDate());
            vegetableDto.setExpectedHarvestDate(vegetable.getExpectedHarvestDate());
            vegetableDto.setNotes(vegetable.getNotes());
            
            model.addAttribute("vegetable", vegetableDto);
            model.addAttribute("greenhouses", greenhouseService.findAllGreenhouses());
            return "vegetable/form";
        } catch (RuntimeException e) {
            return "redirect:/vegetables";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteVegetable(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            vegetableService.deleteVegetable(id);
            redirectAttributes.addFlashAttribute("message", "Vegetable deleted successfully");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/vegetables";
    }

    @GetMapping("/search")
    public String searchVegetables(@RequestParam String name, Model model) {
        model.addAttribute("vegetables", vegetableService.getVegetablesByName(name));
        model.addAttribute("searchTerm", name);
        return "vegetable/list";
    }
    
    @GetMapping("/planted-between")
    public String getVegetablesPlantedBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end,
            Model model) {
        model.addAttribute("vegetables", vegetableService.getVegetablesPlantedBetween(start, end));
        model.addAttribute("startDate", start);
        model.addAttribute("endDate", end);
        return "vegetable/list";
    }
    
    @GetMapping("/ready-to-harvest")
    public String getVegetablesReadyToHarvest(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate before,
            Model model) {
        LocalDate harvestDate = before != null ? before : LocalDate.now();
        model.addAttribute("vegetables", vegetableService.getVegetablesReadyToHarvest(harvestDate));
        model.addAttribute("harvestDate", harvestDate);
        return "vegetable/harvest";
    }
}
