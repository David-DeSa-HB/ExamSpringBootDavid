package POEJava2024.ExamJanvier.EXAM.repository;

import java.util.Optional;

public interface EntityNameRepository<T> {

    Optional<T> findByName(String name);
}
