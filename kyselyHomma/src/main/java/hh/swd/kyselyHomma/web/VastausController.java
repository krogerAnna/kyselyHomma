package hh.swd.kyselyHomma.web;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd.kyselyHomma.domain.Vastaus;
import hh.swd.kyselyHomma.domain.VastausRepository;

public class VastausController {

	private final VastausRepository repository;
	
	VastausController ( VastausRepository repository ) {
		this.repository = repository;
	}
	
	@PostMapping("/savevastaus")
	public void saveVastaus(Vastaus vastaus) {
		repository.save(vastaus);
	}
	
	//REST Etsii ja palauttaa kaikki vastaukset
	@GetMapping("/vastaukset")
	@ResponseBody List<Vastaus> vastaukset() {
		return repository.findAll();
	}
	
	//REST getById
	@GetMapping("/vastaukset/{id}")
	public @ResponseBody Optional<Vastaus> findVastausRest(@PathVariable("id")Long id) {
		return repository.findById(id);
	}
}