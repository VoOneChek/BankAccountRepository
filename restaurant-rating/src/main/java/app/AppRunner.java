package app;

import app.entity.*;
import app.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class AppRunner implements CommandLineRunner {

    private final VisitorService visitorService;
    private final RestaurantService restaurantService;
    private final ReviewService reviewService;

    @Override
    public void run(String... args) {

        Visitor v1 = new Visitor(1L, "Danil", 22, "M");
        visitorService.save(v1);

        Restaurant r1 = new Restaurant(
                1L,
                "PizzaPlace",
                "",
                CuisineType.ITALIAN,
                BigDecimal.valueOf(20),
                BigDecimal.ZERO
        );

        restaurantService.save(r1);

        reviewService.save(new Review(1L, 1L, 5, "Top"));
        reviewService.save(new Review(1L, 1L, 4, "Good"));

        System.out.println(restaurantService.findAll());
    }
}
