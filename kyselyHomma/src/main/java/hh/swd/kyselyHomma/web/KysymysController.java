package hh.swd.kyselyHomma.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hh.swd.kyselyHomma.domain.Kysymys;
import hh.swd.kyselyHomma.domain.KysymysRepository;

@RestController
public class KysymysController {

	private final KysymysRepository repository;
	
	KysymysController(KysymysRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/kysymykset")
	List<Kysymys> all() {
		return repository.findAll();
	}
	
}
