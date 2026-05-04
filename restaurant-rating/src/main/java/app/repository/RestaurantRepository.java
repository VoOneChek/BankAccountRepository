package app.repository;

import app.entity.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RestaurantRepository {

    private final List<Restaurant> list = new ArrayList<>();

    public void save(Restaurant r) {
        list.add(r);
    }

    public void remove(Restaurant r) {
        list.remove(r);
    }

    public List<Restaurant> findAll() {
        return list;
    }
}
