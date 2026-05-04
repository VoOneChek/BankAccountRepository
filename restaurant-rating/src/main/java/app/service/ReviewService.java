package app.service;

import app.entity.*;
import app.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    public void save(Review review) {

        reviewRepository.save(review);

        Restaurant restaurant = restaurantRepository.findAll().stream()
                .filter(r -> r.getId().equals(review.getRestaurantId()))
                .findFirst()
                .orElseThrow();

        double avg = reviewRepository.findAll().stream()
                .filter(r -> r.getRestaurantId().equals(restaurant.getId()))
                .mapToInt(Review::getRating)
                .average()
                .orElse(0);

        restaurant.setRating(BigDecimal.valueOf(avg));
    }
}
