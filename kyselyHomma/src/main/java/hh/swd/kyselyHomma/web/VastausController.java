package hh.swd.kyselyHomma.web;

import java.util.List;
<<<<<<< HEAD

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd.kyselyHomma.domain.Kysymys;
import hh.swd.kyselyHomma.domain.Vastaus;
import hh.swd.kyselyHomma.domain.VastausRepository;



public class VastausController {

	private final VastausRepository vrepository;
	
	VastausController ( VastausRepository vrepository ) {
		this.vrepository = vrepository;
	}
	
	@GetMapping("/vastaukset")
	@ResponseBody List<Vastaus> vastaukset() {
		return vrepository.findAll();
	}
	
	@PostMapping("/save")
	public String saveVastaus(Vastaus vastaus) {
		vrepository.save(vastaus);
		return "vastaukset";
	}
}
=======
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
>>>>>>> cf4affdcf483353aaf8839e12c83c5e3f53df56d
