package app.entity;

import lombok.*;

@Data
@AllArgsConstructor
public class Review {

    private Long visitorId;
    private Long restaurantId;
    private int rating;
    private String comment;
}
