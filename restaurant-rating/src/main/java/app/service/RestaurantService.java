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

    public void save(Restaurant r) {
        repository.save(r);
    }

    public void remove(Restaurant r) {
        repository.remove(r);
    }

    public List<Restaurant> findAll() {
        return repository.findAll();
    }
}
