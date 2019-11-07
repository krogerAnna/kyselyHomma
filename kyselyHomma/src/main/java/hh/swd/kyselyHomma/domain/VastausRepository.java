package hh.swd.kyselyHomma.domain;
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

public interface VastausRepository extends JpaRepository<Vastaus, Long> {

	//List<Kysymys> findByContent(String content);
}