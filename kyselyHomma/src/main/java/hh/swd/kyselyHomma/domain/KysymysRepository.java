package hh.swd.kyselyHomma.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface KysymysRepository extends JpaRepository<Kysymys, Long> {
	//public Kysymys saveUpdateKysymys(Kysymys kysymys);
	//List<Kysymys> findByContent(String content);
}
