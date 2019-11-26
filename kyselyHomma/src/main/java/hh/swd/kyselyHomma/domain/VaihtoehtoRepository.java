package hh.swd.kyselyHomma.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VaihtoehtoRepository extends JpaRepository<Vaihtoehto, Long> {
	
	List<Vaihtoehto> findAllByKysymys(Optional<Kysymys> kysymys);

}
