package app.mapper;

import app.dto.restaurant.*;
import app.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rating", ignore = true)
    Restaurant toEntity(RestaurantRequestDTO dto);

    RestaurantResponseDTO toDTO(Restaurant restaurant);
}
