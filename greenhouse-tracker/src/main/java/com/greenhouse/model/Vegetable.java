package com.greenhouse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private Greenhouse greenhouse;
    
    @Column(name = "planting_date")
    private LocalDate plantingDate;
    
    @Column(name = "expected_harvest_date")
    private LocalDate expectedHarvestDate;
    
    private String notes;
}
