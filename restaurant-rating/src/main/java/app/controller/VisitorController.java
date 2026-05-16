package app.controller;

import app.dto.visitor.*;
import app.entity.Visitor;
import app.mapper.VisitorMapper;
import app.service.VisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class VisitorController {

    private final VisitorService service;
    private final VisitorMapper mapper;

    @GetMapping
    public List<VisitorResponseDTO> findAll() {

        return service.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public VisitorResponseDTO findById(
            @PathVariable Long id
    ) {

        return mapper.toDto(
                service.findById(id)
        );
    }

    @PostMapping
    public VisitorResponseDTO save(
            @RequestBody VisitorRequestDTO dto
    ) {

        Visitor visitor =
                mapper.toEntity(dto);

        return mapper.toDto(
                service.save(visitor)
        );
    }

    @PutMapping("/{id}")
    public VisitorResponseDTO update(
            @PathVariable Long id,
            @RequestBody VisitorRequestDTO dto
    ) {

        Visitor visitor =
                mapper.toEntity(dto);

        return mapper.toDto(
                service.update(id, visitor)
        );
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {
        service.delete(id);
    }
}
