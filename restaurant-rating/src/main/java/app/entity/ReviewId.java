package app.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ReviewId implements Serializable {

    private Long visitorId;
    private Long restaurantId;
}
