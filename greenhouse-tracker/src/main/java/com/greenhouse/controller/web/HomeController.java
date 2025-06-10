package main.java.com.greenhouse.controller.web;

import com.greenhouse.service.GreenhouseService;
import com.greenhouse.service.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class HomeController {

    private final GreenhouseService greenhouseService;
    private final VegetableService vegetableService;

    @Autowired
    public HomeController(GreenhouseService greenhouseService, VegetableService vegetableService) {
        this.greenhouseService = greenhouseService;
        this.vegetableService = vegetableService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("greenhouseCount", greenhouseService.findAllGreenhouses().size());
        model.addAttribute("vegetableCount", vegetableService.getAllVegetables().size());
        model.addAttribute("upcomingHarvest", vegetableService.getVegetablesReadyToHarvest(LocalDate.now().plusDays(7)));
        return "home";
    }
    
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "redirect:/";
    }
}
