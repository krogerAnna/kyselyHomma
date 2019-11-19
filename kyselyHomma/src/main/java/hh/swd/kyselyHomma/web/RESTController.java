package hh.swd.kyselyHomma.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import hh.swd.kyselyHomma.domain.Kysely;
import hh.swd.kyselyHomma.domain.KyselyRepository;
import hh.swd.kyselyHomma.domain.Kysymys;
import hh.swd.kyselyHomma.domain.KysymysRepository;
import hh.swd.kyselyHomma.domain.Vastaus;
import hh.swd.kyselyHomma.domain.VastausRepository;

@Controller
public class RESTController {
	
	//REST homepage
	@GetMapping("/resthome")
	public String restHomePage() {
		return "resthome";
	}

	// **** Kysymys RESTit **** //
	
	@Autowired
	private KysymysRepository kysymysRepo;

	// Etsii ja palauttaa kaikki kysymykset
	@GetMapping("/kysymykset")
	@ResponseBody List<Kysymys> kysymykset() {
		return kysymysRepo.findAll();
	}
	
	// getById
	@GetMapping("/kysymykset/{id}")
	public @ResponseBody Optional<Kysymys> findKysymys(@PathVariable("id") Long kysymysId) {
		return kysymysRepo.findById(kysymysId);
	}
	
	
	// **** Vastaus RESTit **** //
	
	@Autowired 
	private VastausRepository vastausRepo;
	
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
	
	// **** Kysely RESTit **** //
  
  @Autowired
	private KyselyRepository kyselyRepo;
	
	// Etsii ja palauttaa kaikki kyselyt
	@GetMapping("/kyselyt")
	@ResponseBody List<Kysely> kyselyt() {
		return kyselyRepo.findAll();
	}
	
	// getById
	@GetMapping("/kyselyt/{id}")
	public @ResponseBody Optional<Kysely> findKysely(@PathVariable("id") Long kyselyId) {
		return kyselyRepo.findById(kyselyId);
	}
	
}
