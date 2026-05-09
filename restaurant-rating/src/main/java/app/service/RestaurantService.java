package app.service;

import app.entity.Restaurant;
import app.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository repository;

    public void save(Restaurant restaurant) {
        repository.save(restaurant);
    }

    public List<Restaurant> findAll() {
        return repository.findAll();
    }

    public Restaurant findById(Long id) {

        return repository.findById(id)
                .orElseThrow();
    }

    public void update(Restaurant restaurant) {
        repository.update(restaurant);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
