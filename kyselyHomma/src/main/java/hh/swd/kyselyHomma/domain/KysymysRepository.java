package hh.swd.kyselyHomma.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface KysymysRepository extends JpaRepository<Kysymys, Long> {
	
	List<Kysymys> findByContent(String content);
	//List<Kysymys> findByVaihtoehto(Optional<Vaihtoehto> vaihtoehto);
	List<Kysymys> findAllByKysely(Optional<Kysely> kysely);

	Kysymys findByKysymysId(Long id);
}
