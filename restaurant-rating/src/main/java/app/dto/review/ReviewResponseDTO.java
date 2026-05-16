package app.dto.review;

public record ReviewResponseDTO(
        Long visitorId,
        Long restaurantId,
        int rating,
        String comment
) {
}
