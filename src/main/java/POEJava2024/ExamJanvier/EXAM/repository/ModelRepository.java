package POEJava2024.ExamJanvier.EXAM.repository;

import POEJava2024.ExamJanvier.EXAM.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
}
