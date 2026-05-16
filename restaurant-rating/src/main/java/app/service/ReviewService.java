package app.service;

import app.entity.*;
import app.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    public Page<Review> findAll(
            int page,
            int size
    ) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by("rating").descending()
        );

        return reviewRepository.findAll(pageable);
    }

    public Review findById(
            ReviewId id
    ) {
        return reviewRepository.findById(id)
                .orElseThrow();
    }

    public Review save(Review review) {

        Review saved = reviewRepository.save(review);

        updateRestaurantRating(
                review.getRestaurant().getId()
        );

        return saved;
    }

    public void delete(ReviewId id) {

        Review review = findById(id);

        Long restaurantId =
                review.getRestaurant().getId();

        reviewRepository.deleteById(id);

        updateRestaurantRating(restaurantId);
    }

    private void updateRestaurantRating(
            Long restaurantId
    ) {

        double avg = reviewRepository.findAll()
                .stream()
                .filter(r ->
                        r.getRestaurant()
                                .getId()
                                .equals(restaurantId))
                .mapToInt(Review::getRating)
                .average()
                .orElse(0);

        Restaurant restaurant =
                restaurantRepository.findById(
                        restaurantId
                ).orElseThrow();

        restaurant.setRating(
                BigDecimal.valueOf(avg)
        );

        restaurantRepository.save(restaurant);
    }
}
