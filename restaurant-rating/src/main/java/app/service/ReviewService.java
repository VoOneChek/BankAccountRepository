package app.service;

import app.entity.Restaurant;
import app.entity.Review;
import app.repository.RestaurantRepository;
import app.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    public void save(Review review) {

        reviewRepository.save(review);

        recalculateRestaurantRating(review.getRestaurantId());
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Review findById(Long id) {

        return reviewRepository.findById(id)
                .orElseThrow();
    }

    public void update(Review review) {

        reviewRepository.update(review);

        recalculateRestaurantRating(review.getRestaurantId());
    }

    public void deleteById(Long id) {

        Review review = findById(id);

        reviewRepository.deleteById(id);

        recalculateRestaurantRating(review.getRestaurantId());
    }

    private void recalculateRestaurantRating(Long restaurantId) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow();

        double avg = reviewRepository.findAll()
                .stream()
                .filter(r -> r.getRestaurantId().equals(restaurantId))
                .mapToInt(Review::getRating)
                .average()
                .orElse(0);

        restaurant.setRating(BigDecimal.valueOf(avg));
    }
}
