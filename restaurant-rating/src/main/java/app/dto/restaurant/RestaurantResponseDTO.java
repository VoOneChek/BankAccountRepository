package app.dto.restaurant;

import app.entity.CuisineType;

import java.math.BigDecimal;

public record RestaurantResponseDTO(
        Long id,
        String name,
        String description,
        CuisineType cuisineType,
        BigDecimal avgCheck,
        BigDecimal rating
) {
}
