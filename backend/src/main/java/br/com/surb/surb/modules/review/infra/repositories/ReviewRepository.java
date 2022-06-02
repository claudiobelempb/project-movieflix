package br.com.surb.surb.modules.review.infra.repositories;

import br.com.surb.surb.modules.review.infra.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
