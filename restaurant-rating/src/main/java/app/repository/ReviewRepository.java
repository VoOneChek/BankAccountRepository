package app.repository;

import app.entity.Review;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ReviewRepository {

    private final List<Review> list = new ArrayList<>();

    public void save(Review r) {
        list.add(r);
    }

    public void remove(Review r) {
        list.remove(r);
    }

    public List<Review> findAll() {
        return list;
    }

    public Optional<Review> findById(Long visitorId, Long restaurantId) {
        return list.stream()
                .filter(r -> r.getVisitorId().equals(visitorId)
                        && r.getRestaurantId().equals(restaurantId))
                .findFirst();
    }
}
