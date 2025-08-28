package hiq.leapproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualityFormRepository extends JpaRepository<QualityForm, Long> {
}
