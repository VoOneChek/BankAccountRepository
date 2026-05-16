package app.controller;

import app.dto.restaurant.*;
import app.entity.Restaurant;
import app.mapper.RestaurantMapper;
import app.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService service;
    private final RestaurantMapper mapper;

    @GetMapping
    public List<RestaurantResponseDTO> findAll() {

        return service.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public RestaurantResponseDTO findById(
            @PathVariable Long id
    ) {

        return mapper.toDTO(
                service.findById(id)
        );
    }

    @PostMapping
    public RestaurantResponseDTO save(
            @RequestBody RestaurantRequestDTO dto
    ) {

        Restaurant restaurant =
                mapper.toEntity(dto);

        return mapper.toDTO(
                service.save(restaurant)
        );
    }

    @PutMapping("/{id}")
    public RestaurantResponseDTO update(
            @PathVariable Long id,
            @RequestBody RestaurantRequestDTO dto
    ) {

        Restaurant restaurant =
                mapper.toEntity(dto);

        return mapper.toDTO(
                service.update(id, restaurant)
        );
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {
        service.delete(id);
    }

    @GetMapping("/rating")
    public List<RestaurantResponseDTO> findByRating(
            @RequestParam BigDecimal rating
    ) {

        return service.findWithRating(rating)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @GetMapping("/rating-query")
    public List<RestaurantResponseDTO> findByRatingQuery(
            @RequestParam BigDecimal rating
    ) {

        return service.findWithRatingQuery(rating)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }
}
