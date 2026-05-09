package app.repository;

import app.entity.Review;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ReviewRepository {

    private final List<Review> list = new ArrayList<>();

    public void save(Review review) {
        list.add(review);
    }

    public List<Review> findAll() {
        return list;
    }

    public Optional<Review> findById(Long id) {

        return list.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
    }

    public void update(Review updatedReview) {

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getId().equals(updatedReview.getId())) {

                list.set(i, updatedReview);
                return;
            }
        }
    }

    public void deleteById(Long id) {

        list.removeIf(r -> r.getId().equals(id));
    }
}
