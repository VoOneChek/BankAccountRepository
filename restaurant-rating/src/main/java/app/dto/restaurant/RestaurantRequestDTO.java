package app.dto.restaurant;

import app.entity.CuisineType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record RestaurantRequestDTO(

        @NotBlank
        String name,

        String description,

        @NotNull
        CuisineType cuisineType,

        @NotNull
        BigDecimal avgCheck
) {
}
