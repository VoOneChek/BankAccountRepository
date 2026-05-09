package app.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private Long id;
    private Long visitorId;
    private Long restaurantId;
    private int rating;
    private String comment;
}