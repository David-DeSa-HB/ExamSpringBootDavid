package POEJava2024.ExamJanvier.EXAM.repository;

import POEJava2024.ExamJanvier.EXAM.entity.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {
}
