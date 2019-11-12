package hh.swd.kyselyHomma.web;

import org.springframework.web.bind.annotation.PostMapping;

import hh.swd.kyselyHomma.domain.Vastaus;
import hh.swd.kyselyHomma.domain.VastausRepository;

public class VastausController {

	private final VastausRepository repository;
	
	VastausController ( VastausRepository repository ) {
		this.repository = repository;
	}
	
	@PostMapping("/vastaus")
	public String saveVastaus(Vastaus vastaus) {
		repository.save(vastaus);
		return "redirect:vastaus";
	}
}
