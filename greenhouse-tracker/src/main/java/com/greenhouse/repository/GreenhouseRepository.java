package main.java.com.greenhouse.repository;

import com.greenhouse.model.Greenhouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GreenhouseRepository extends JpaRepository<Greenhouse, Long> {
    List<Greenhouse> findByNameContainingIgnoreCase(String name);
}
