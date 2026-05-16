package app.controller;

import app.dto.review.*;
import app.entity.*;
import app.mapper.ReviewMapper;
import app.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;
    private final ReviewMapper mapper;

    @GetMapping
    public Page<ReviewResponseDTO> findAll(

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "5")
            int size
    ) {

        return service.findAll(page, size)
                .map(mapper::toDto);
    }

    @GetMapping("/{visitorId}/{restaurantId}")
    public ReviewResponseDTO findById(

            @PathVariable Long visitorId,

            @PathVariable Long restaurantId
    ) {

        ReviewId id = new ReviewId(
                visitorId,
                restaurantId
        );

        return mapper.toDto(
                service.findById(id)
        );
    }

    @PostMapping
    public Review save(
            @RequestBody Review review
    ) {
        return service.save(review);
    }

    @DeleteMapping("/{visitorId}/{restaurantId}")
    public void delete(

            @PathVariable Long visitorId,

            @PathVariable Long restaurantId
    ) {

        ReviewId id = new ReviewId(
                visitorId,
                restaurantId
        );

        service.delete(id);
    }
}
