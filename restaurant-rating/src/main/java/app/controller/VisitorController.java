package app.controller;

import app.dto.visitor.*;
import app.entity.Visitor;
import app.mapper.VisitorMapper;
import app.service.VisitorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
@RequiredArgsConstructor
public class VisitorController {

    private final VisitorService service;
    private final VisitorMapper mapper;

    @GetMapping
    public List<VisitorResponseDTO> findAll() {

        return service.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public VisitorResponseDTO findById(@PathVariable Long id) {

        return mapper.toDTO(service.findById(id));
    }

    @PostMapping
    public void save(@RequestBody @Valid VisitorRequestDTO dto) {

        Visitor visitor = mapper.toEntity(dto);

        visitor.setId(System.currentTimeMillis());

        service.save(visitor);
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable Long id,
            @RequestBody @Valid VisitorRequestDTO dto
    ) {

        Visitor visitor = mapper.toEntity(dto);

        visitor.setId(id);

        service.update(visitor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        service.deleteById(id);
    }
}
