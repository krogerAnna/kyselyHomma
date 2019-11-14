package hh.swd.kyselyHomma.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import hh.swd.kyselyHomma.domain.Vastaus;
import hh.swd.kyselyHomma.domain.VastausRepository;

@Controller
public class VastausController {

	private final VastausRepository repository;
	
	VastausController ( VastausRepository repository ) {
		this.repository = repository;
	}
	
	@PostMapping("/savevastaus")
	public void saveVastaus(Vastaus vastaus) {
		repository.save(vastaus);
	}

}
