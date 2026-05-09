package app.controller;

import app.dto.restaurant.*;
import app.entity.Restaurant;
import app.mapper.RestaurantMapper;
import app.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public RestaurantResponseDTO findById(@PathVariable Long id) {

        return mapper.toDTO(service.findById(id));
    }

    @PostMapping
    public void save(@RequestBody @Valid RestaurantRequestDTO dto) {

        Restaurant restaurant = mapper.toEntity(dto);

        restaurant.setId(System.currentTimeMillis());

        service.save(restaurant);
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable Long id,
            @RequestBody @Valid RestaurantRequestDTO dto
    ) {

        Restaurant restaurant = mapper.toEntity(dto);

        restaurant.setId(id);

        service.update(restaurant);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        service.deleteById(id);
    }
}
