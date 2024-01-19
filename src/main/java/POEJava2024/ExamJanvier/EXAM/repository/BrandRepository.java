package POEJava2024.ExamJanvier.EXAM.repository;

import POEJava2024.ExamJanvier.EXAM.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
