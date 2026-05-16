package app.repository;

import app.entity.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository
        extends JpaRepository<Review, ReviewId> {

    Page<Review> findAll(Pageable pageable);
}
