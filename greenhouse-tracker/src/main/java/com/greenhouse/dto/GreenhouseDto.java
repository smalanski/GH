package com.greenhouse.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GreenhouseDto {
    
    private Long id;
    
    @NotBlank(message = "Greenhouse name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;
    
    @Size(max = 100, message = "Location cannot exceed 100 characters")
    private String location;
    
    @Min(value = 0, message = "Size must be a positive number")
    private Double sizeSqm;
}
