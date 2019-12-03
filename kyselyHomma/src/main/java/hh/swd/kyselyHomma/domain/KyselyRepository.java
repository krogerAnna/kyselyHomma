package hh.swd.kyselyHomma.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KyselyRepository extends JpaRepository<Kysely, Long>{

	List<Kysely> findByName(String name);
	//Kysely findByKysymys(Kysymys kysymys);

//	List<Kysymys> save(Optional<Kysely> kysely);
}
