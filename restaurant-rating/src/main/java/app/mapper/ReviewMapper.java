package app.mapper;

import app.dto.review.*;
import app.entity.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    Review toEntity(ReviewRequestDTO dto);

    ReviewResponseDTO toDTO(Review review);
}
