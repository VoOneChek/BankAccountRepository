package app.dto.visitor;

public record VisitorResponseDTO(
        Long id,
        String name,
        int age,
        String gender
) {
}