package app.mapper;

import app.dto.visitor.*;
import app.entity.Visitor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitorMapper {

    Visitor toEntity(VisitorRequestDTO dto);

    VisitorResponseDTO toDTO(Visitor visitor);
}
