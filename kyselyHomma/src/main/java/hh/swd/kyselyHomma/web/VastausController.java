package hh.swd.kyselyHomma.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd.kyselyHomma.domain.Kysymys;
import hh.swd.kyselyHomma.domain.KysymysRepository;
import hh.swd.kyselyHomma.domain.Vastaus;
import hh.swd.kyselyHomma.domain.VastausRepository;

//@CrossOrigin
@Controller
public class VastausController {

	
//	private final VastausRepository repository;
//	
//	VastausController (VastausRepository repository) {
//		this.repository = repository;
//	}
//	
//	//Tallentaa uuden vastauksens
//	@PostMapping("/savevastaus")
//	public void saveVastaus(Vastaus vastaus) {
//		repository.save(vastaus);
//	}
	
	// **** Vastaus RESTit **** //
	
	// Etsii ja palauttaa kaikki vastaukset
	@GetMapping("/vastaukset")
	@ResponseBody List<Vastaus> vastaukset() {
		return vastausRepo.findAll();
	}
	
	// getById
	@GetMapping("/vastaukset/{id}")
	public @ResponseBody Optional<Vastaus> findVastaus(@PathVariable("id") Long vastausId) {
		return vastausRepo.findById(vastausId);
	}
	
	// lisää uusi vastaus
	@PostMapping("/vastaukset")
	public @ResponseBody Vastaus lisaaUusiVastaus(@RequestBody Vastaus vastaus) {
		return vastausRepo.save(vastaus);
	}
	


}

