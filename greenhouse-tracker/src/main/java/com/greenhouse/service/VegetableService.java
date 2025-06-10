package com.greenhouse.service;

import com.greenhouse.model.Greenhouse;
import com.greenhouse.model.Vegetable;
import com.greenhouse.repository.GreenhouseRepository;
import com.greenhouse.repository.VegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VegetableService {

    private final VegetableRepository vegetableRepository;
    private final GreenhouseRepository greenhouseRepository;

    @Autowired
    public VegetableService(VegetableRepository vegetableRepository, GreenhouseRepository greenhouseRepository) {
        this.vegetableRepository = vegetableRepository;
        this.greenhouseRepository = greenhouseRepository;
    }

    // Greenhouse methods
    public List<Greenhouse> getAllGreenhouses() {
        return greenhouseRepository.findAll();
    }

    public Greenhouse getGreenhouseById(Long id) {
        return greenhouseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greenhouse not found with id: " + id));
    }

    public Greenhouse saveGreenhouse(Greenhouse greenhouse) {
        return greenhouseRepository.save(greenhouse);
    }

    public void deleteGreenhouse(Long id) {
        greenhouseRepository.deleteById(id);
    }

    // Vegetable methods
    public List<Vegetable> getAllVegetables() {
        return vegetableRepository.findAll();
    }

    public Vegetable getVegetableById(Long id) {
        return vegetableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vegetable not found with id: " + id));
    }

    public List<Vegetable> getVegetablesByGreenhouseId(Long greenhouseId) {
        return vegetableRepository.findByGreenhouseId(greenhouseId);
    }

    public Vegetable saveVegetable(Vegetable vegetable, Long greenhouseId) {
        Greenhouse greenhouse = greenhouseRepository.findById(greenhouseId)
                .orElseThrow(() -> new RuntimeException("Greenhouse not found with id: " + greenhouseId));
        vegetable.setGreenhouse(greenhouse);
        return vegetableRepository.save(vegetable);
    }

    public Vegetable updateVegetable(Long id, Vegetable vegetableDetails) {
        Vegetable vegetable = getVegetableById(id);
        
        vegetable.setName(vegetableDetails.getName());
        vegetable.setVariety(vegetableDetails.getVariety());
        vegetable.setPlantingDate(vegetableDetails.getPlantingDate());
        vegetable.setExpectedHarvestDate(vegetableDetails.getExpectedHarvestDate());
        vegetable.setNotes(vegetableDetails.getNotes());
        
        return vegetableRepository.save(vegetable);
    }

    public void deleteVegetable(Long id) {
        vegetableRepository.deleteById(id);
    }
    
    public List<Vegetable> getVegetablesByName(String name) {
        return vegetableRepository.findByNameContainingIgnoreCase(name);
    }
    
    public List<Vegetable> getVegetablesPlantedBetween(LocalDate start, LocalDate end) {
        return vegetableRepository.findByPlantingDateBetween(start, end);
    }
    
    public List<Vegetable> getVegetablesReadyToHarvest(LocalDate before) {
        return vegetableRepository.findByExpectedHarvestDateBefore(before);
    }
}
