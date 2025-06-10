package com.greenhouse.controller.web;

import com.greenhouse.dto.GreenhouseDto;
import com.greenhouse.model.Greenhouse;
import com.greenhouse.service.GreenhouseService;
import com.greenhouse.service.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/greenhouses")
public class GreenhouseWebController {

    private final GreenhouseService greenhouseService;
    private final VegetableService vegetableService;

    @Autowired
    public GreenhouseWebController(GreenhouseService greenhouseService, VegetableService vegetableService) {
        this.greenhouseService = greenhouseService;
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public String listGreenhouses(Model model) {
        model.addAttribute("greenhouses", greenhouseService.findAllGreenhouses());
        return "greenhouse/list";
    }

    @GetMapping("/{id}")
    public String viewGreenhouse(@PathVariable Long id, Model model) {
        Greenhouse greenhouse = greenhouseService.findGreenhouseById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid greenhouse Id:" + id));
        
        model.addAttribute("greenhouse", greenhouse);
        model.addAttribute("vegetables", vegetableService.getVegetablesByGreenhouseId(id));
        return "greenhouse/view";
    }    @GetMapping("/new")
    public String showCreationForm(Model model) {
        model.addAttribute("greenhouse", new GreenhouseDto());
        return "greenhouse/form";
    }

    @PostMapping("/save")
    public String saveGreenhouse(@Valid @ModelAttribute("greenhouse") GreenhouseDto greenhouseDto, 
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "greenhouse/form";
        }
        
        // Convert DTO to entity
        Greenhouse greenhouse = new Greenhouse();
        if (greenhouseDto.getId() != null) {
            greenhouse = greenhouseService.findGreenhouseById(greenhouseDto.getId())
                .orElse(new Greenhouse());
        }
        
        greenhouse.setName(greenhouseDto.getName());
        greenhouse.setLocation(greenhouseDto.getLocation());
        greenhouse.setSizeSqm(greenhouseDto.getSizeSqm());
        
        Greenhouse savedGreenhouse = greenhouseService.saveGreenhouse(greenhouse);
        redirectAttributes.addFlashAttribute("message", "Greenhouse saved successfully");
        return "redirect:/greenhouses/" + savedGreenhouse.getId();
    }    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Greenhouse greenhouse = greenhouseService.findGreenhouseById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid greenhouse Id:" + id));
        
        // Convert entity to DTO
        GreenhouseDto greenhouseDto = new GreenhouseDto();
        greenhouseDto.setId(greenhouse.getId());
        greenhouseDto.setName(greenhouse.getName());
        greenhouseDto.setLocation(greenhouse.getLocation());
        greenhouseDto.setSizeSqm(greenhouse.getSizeSqm());
        
        model.addAttribute("greenhouse", greenhouseDto);
        return "greenhouse/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteGreenhouse(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        greenhouseService.deleteGreenhouseById(id);
        redirectAttributes.addFlashAttribute("message", "Greenhouse deleted successfully");
        return "redirect:/greenhouses";
    }

    @GetMapping("/search")
    public String searchGreenhouses(@RequestParam String name, Model model) {
        model.addAttribute("greenhouses", greenhouseService.findGreenhousesByName(name));
        model.addAttribute("searchTerm", name);
        return "greenhouse/list";
    }
}
