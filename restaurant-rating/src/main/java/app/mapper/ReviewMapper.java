package app.mapper;

import app.dto.review.*;
import app.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mapping(
        target = "visitorId",
        source = "visitor.id"
    )
    @Mapping(
        target = "restaurantId",
        source = "restaurant.id"
    )
    ReviewResponseDTO toDto(Review review);
}
