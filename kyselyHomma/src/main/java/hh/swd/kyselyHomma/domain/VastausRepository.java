package hh.swd.kyselyHomma.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VastausRepository extends JpaRepository<Vastaus, Long> {

	List<Vastaus> findByContent(String content);
}
