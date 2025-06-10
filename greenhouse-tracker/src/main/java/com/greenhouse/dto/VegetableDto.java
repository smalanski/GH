package com.greenhouse.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VegetableDto {
    
    private Long id;
    
    @NotBlank(message = "Vegetable name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;
    
    @NotBlank(message = "Variety is required")
    @Size(min = 2, max = 50, message = "Variety must be between 2 and 50 characters")
    private String variety;
    
    @NotNull(message = "Greenhouse is required")
    private Long greenhouseId;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @PastOrPresent(message = "Planting date cannot be in the future")
    private LocalDate plantingDate;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate expectedHarvestDate;
    
    @Size(max = 500, message = "Notes cannot exceed 500 characters")
    private String notes;
}
