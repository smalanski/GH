package main.java.com.greenhouse.service;

import com.greenhouse.model.Greenhouse;
import com.greenhouse.repository.GreenhouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreenhouseService {

    private final GreenhouseRepository greenhouseRepository;

    @Autowired
    public GreenhouseService(GreenhouseRepository greenhouseRepository) {
        this.greenhouseRepository = greenhouseRepository;
    }

    public List<Greenhouse> findAllGreenhouses() {
        return greenhouseRepository.findAll();
    }

    public Optional<Greenhouse> findGreenhouseById(Long id) {
        return greenhouseRepository.findById(id);
    }

    public List<Greenhouse> findGreenhousesByName(String name) {
        return greenhouseRepository.findByNameContainingIgnoreCase(name);
    }

    public Greenhouse saveGreenhouse(Greenhouse greenhouse) {
        return greenhouseRepository.save(greenhouse);
    }

    public void deleteGreenhouseById(Long id) {
        greenhouseRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return greenhouseRepository.existsById(id);
    }
}
