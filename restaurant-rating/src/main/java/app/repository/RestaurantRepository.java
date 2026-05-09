package app.repository;

import app.entity.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RestaurantRepository {

    private final List<Restaurant> list = new ArrayList<>();

    public void save(Restaurant restaurant) {
        list.add(restaurant);
    }

    public List<Restaurant> findAll() {
        return list;
    }

    public Optional<Restaurant> findById(Long id) {

        return list.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
    }

    public void update(Restaurant updatedRestaurant) {

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getId().equals(updatedRestaurant.getId())) {

                list.set(i, updatedRestaurant);
                return;
            }
        }
    }

    public void deleteById(Long id) {

        list.removeIf(r -> r.getId().equals(id));
    }
}
