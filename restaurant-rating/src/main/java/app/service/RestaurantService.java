package app.service;

import app.entity.Restaurant;
import app.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository repository;

    public List<Restaurant> findAll() {
        return repository.findAll();
    }

    public Restaurant findById(Long id) {
        return repository.findById(id)
                .orElseThrow();
    }

    public Restaurant save(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    public Restaurant update(Long id, Restaurant updated) {

        Restaurant restaurant = findById(id);

        restaurant.setName(updated.getName());
        restaurant.setDescription(updated.getDescription());
        restaurant.setCuisineType(updated.getCuisineType());
        restaurant.setAvgCheck(updated.getAvgCheck());
        restaurant.setRating(updated.getRating());

        return repository.save(restaurant);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Restaurant> findWithRating(
            BigDecimal rating
    ) {
        return repository.findByRatingGreaterThanEqual(rating);
    }

    public List<Restaurant> findWithRatingQuery(
            BigDecimal rating
    ) {
        return repository.findWithRating(rating);
    }
}
