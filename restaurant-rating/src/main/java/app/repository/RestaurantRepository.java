package app.repository;

import app.entity.Restaurant;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findByRatingGreaterThanEqual(BigDecimal rating);

    @Query("""
            select r
            from Restaurant r
            where r.rating >= :rating
            """)
            
    List<Restaurant> findWithRating(@Param("rating") BigDecimal rating);
}
