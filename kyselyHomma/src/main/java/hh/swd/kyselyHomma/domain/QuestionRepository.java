package hh.swd.kyselyHomma.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	List<Question> findByContent(String content);
}
