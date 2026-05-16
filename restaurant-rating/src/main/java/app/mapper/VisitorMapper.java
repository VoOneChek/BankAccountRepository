package app.mapper;

import app.dto.visitor.*;
import app.entity.Visitor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VisitorMapper {

    @Mapping(target = "id", ignore = true)
    Visitor toEntity(VisitorRequestDTO dto);

    VisitorResponseDTO toDto(Visitor visitor);
}
