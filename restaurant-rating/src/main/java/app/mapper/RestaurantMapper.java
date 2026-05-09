package app.mapper;

import app.dto.restaurant.*;
import app.entity.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    Restaurant toEntity(RestaurantRequestDTO dto);

    RestaurantResponseDTO toDTO(Restaurant restaurant);
}
