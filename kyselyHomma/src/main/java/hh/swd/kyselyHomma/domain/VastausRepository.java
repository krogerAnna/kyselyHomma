package hh.swd.kyselyHomma.domain;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

public interface VastausRepository extends JpaRepository<Vastaus, Long> {

	List<Kysymys> findByContent(String content);
	List<Vastaus> findAllByKysymys(Kysymys kysymys);
	List<Vastaus> findAllByKysymys(Optional<Kysymys> kysymys);

}