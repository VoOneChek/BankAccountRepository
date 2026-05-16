package app.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    @EmbeddedId
    private ReviewId id;

    @ManyToOne
    @MapsId("visitorId")
    private Visitor visitor;

    @ManyToOne
    @MapsId("restaurantId")
    private Restaurant restaurant;

    private int rating;

    private String comment;
}