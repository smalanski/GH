package main.java.com.greenhouse.controller.api;

import com.greenhouse.model.Greenhouse;
import com.greenhouse.service.GreenhouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/greenhouses")
public class GreenhouseRestController {

    private final GreenhouseService greenhouseService;

    @Autowired
    public GreenhouseRestController(GreenhouseService greenhouseService) {
        this.greenhouseService = greenhouseService;
    }

    @GetMapping
    public ResponseEntity<List<Greenhouse>> getAllGreenhouses() {
        return ResponseEntity.ok(greenhouseService.findAllGreenhouses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Greenhouse> getGreenhouseById(@PathVariable Long id) {
        return greenhouseService.findGreenhouseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Greenhouse>> searchGreenhouses(@RequestParam String name) {
        return ResponseEntity.ok(greenhouseService.findGreenhousesByName(name));
    }

    @PostMapping
    public ResponseEntity<Greenhouse> createGreenhouse(@RequestBody Greenhouse greenhouse) {
        return new ResponseEntity<>(greenhouseService.saveGreenhouse(greenhouse), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Greenhouse> updateGreenhouse(@PathVariable Long id, @RequestBody Greenhouse greenhouse) {
        if (!greenhouseService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        greenhouse.setId(id);
        return ResponseEntity.ok(greenhouseService.saveGreenhouse(greenhouse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGreenhouse(@PathVariable Long id) {
        if (!greenhouseService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        greenhouseService.deleteGreenhouseById(id);
        return ResponseEntity.noContent().build();
    }
}
