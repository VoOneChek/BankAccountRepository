package app.dto.visitor;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record VisitorRequestDTO(

        String name,

        @Min(1)
        int age,

        @NotBlank
        String gender
) {
}