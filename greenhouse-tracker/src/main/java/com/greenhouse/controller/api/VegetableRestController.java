package main.java.com.greenhouse.controller.api;

import com.greenhouse.model.Vegetable;
import com.greenhouse.service.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/vegetables")
public class VegetableRestController {

    private final VegetableService vegetableService;

    @Autowired
    public VegetableRestController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public ResponseEntity<List<Vegetable>> getAllVegetables() {
        return ResponseEntity.ok(vegetableService.getAllVegetables());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vegetable> getVegetableById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(vegetableService.getVegetableById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/greenhouse/{greenhouseId}")
    public ResponseEntity<List<Vegetable>> getVegetablesByGreenhouseId(@PathVariable Long greenhouseId) {
        return ResponseEntity.ok(vegetableService.getVegetablesByGreenhouseId(greenhouseId));
    }

    @PostMapping("/greenhouse/{greenhouseId}")
    public ResponseEntity<Vegetable> createVegetable(@PathVariable Long greenhouseId, @RequestBody Vegetable vegetable) {
        try {
            return new ResponseEntity<>(vegetableService.saveVegetable(vegetable, greenhouseId), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vegetable> updateVegetable(@PathVariable Long id, @RequestBody Vegetable vegetableDetails) {
        try {
            return ResponseEntity.ok(vegetableService.updateVegetable(id, vegetableDetails));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVegetable(@PathVariable Long id) {
        try {
            vegetableService.deleteVegetable(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Vegetable>> searchVegetablesByName(@RequestParam String name) {
        return ResponseEntity.ok(vegetableService.getVegetablesByName(name));
    }
    
    @GetMapping("/planted-between")
    public ResponseEntity<List<Vegetable>> getVegetablesPlantedBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return ResponseEntity.ok(vegetableService.getVegetablesPlantedBetween(start, end));
    }
    
    @GetMapping("/ready-to-harvest")
    public ResponseEntity<List<Vegetable>> getVegetablesReadyToHarvest(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate before) {
        LocalDate harvestDate = before != null ? before : LocalDate.now();
        return ResponseEntity.ok(vegetableService.getVegetablesReadyToHarvest(harvestDate));
    }
}
