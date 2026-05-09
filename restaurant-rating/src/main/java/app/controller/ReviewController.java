package app.controller;

import app.dto.review.*;
import app.entity.Review;
import app.mapper.ReviewMapper;
import app.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;
    private final ReviewMapper mapper;

    @GetMapping
    public List<ReviewResponseDTO> findAll() {

        return service.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ReviewResponseDTO findById(@PathVariable Long id) {

        return mapper.toDTO(service.findById(id));
    }

    @PostMapping
    public void save(@RequestBody @Valid ReviewRequestDTO dto) {

        Review review = mapper.toEntity(dto);

        review.setId(System.currentTimeMillis());

        service.save(review);
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable Long id,
            @RequestBody @Valid ReviewRequestDTO dto
    ) {

        Review review = mapper.toEntity(dto);

        review.setId(id);

        service.update(review);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        service.deleteById(id);
    }
}
