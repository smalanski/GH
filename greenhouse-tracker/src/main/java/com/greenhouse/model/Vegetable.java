package com.greenhouse.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "vegetables")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String variety;
    
    @ManyToOne
    @JoinColumn(name = "greenhouse_id", nullable = false)
    @JsonBackReference
    private Greenhouse greenhouse;
    
    @Column(name = "planting_date")
    private LocalDate plantingDate;
      @Column(name = "expected_harvest_date")
    private LocalDate expectedHarvestDate;
    
    @Column(name = "last_watering")
    private LocalDateTime lastWatering;
    
    private String notes;
}
