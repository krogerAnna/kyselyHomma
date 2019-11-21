package hh.swd.kyselyHomma.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import hh.swd.kyselyHomma.domain.KyselyRepository;

public interface KysymysRepository extends JpaRepository<Kysymys, Long> {
	
	List<Kysymys> findByContent(String content);

	List<Kysymys> findAllById(Optional<Kysely> kysely);

	List<Kysymys> findAllBy(Optional<Kysely> kysely);
}
