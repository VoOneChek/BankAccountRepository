package app.dto.review;

public record ReviewResponseDTO(
        Long id,
        Long visitorId,
        Long restaurantId,
        int rating,
        String comment
) {
}
