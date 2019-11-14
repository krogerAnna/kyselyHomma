package hh.swd.kyselyHomma.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.swd.kyselyHomma.domain.Kysely;
import hh.swd.kyselyHomma.domain.KyselyRepository;
import hh.swd.kyselyHomma.domain.Kysymys;
import hh.swd.kyselyHomma.domain.KysymysRepository;
import hh.swd.kyselyHomma.domain.Vastaus;
import hh.swd.kyselyHomma.domain.VastausRepository;

@Controller
public class RESTController {

	@Autowired
	private KysymysRepository kysymysRepo;

	@Autowired
	private KyselyRepository kyselyRepo;

	@Autowired
	private VastausRepository repository;

	// KysymysRESTit

	// REST Etsii ja palauttaa kaikki kysymykset
	@GetMapping("/kysymykset")
	@ResponseBody
	List<Kysymys> kysymykset() {
		return kysymysRepo.findAll();
	}

	// REST homepage
	@GetMapping("/resthome")
	public String restHomePage() {
		return "resthome";
	}

	// REST getById
	@GetMapping("/kysymykset/{id}")
	public @ResponseBody Optional<Kysymys> findKysymysRest(@PathVariable("id") Long kysymysId) {
		return kysymysRepo.findById(kysymysId);
	}

	// Vastaus RESTit

	@Autowired
	VastausRepository vastausRepo;

	// REST Etsii kaikki vastaukset
	@GetMapping("/vastaukset")
	@ResponseBody
	List<Vastaus> vastaukset() {
		return vastausRepo.findAll();
	}

	// getById
	@GetMapping("vastaukset/{id}")
	public @ResponseBody Optional<Vastaus> findVastausRest(@PathVariable("id") Long vastausId) {
		return vastausRepo.findById(vastausId);
	}

	@GetMapping("/kysely/{id}")
	public @ResponseBody Optional<Kysely> findKyselyRest(@PathVariable("id") Long kyselyId) {
		return kyselyRepo.findById(kyselyId);
	}

	@GetMapping("/kysymys/vastaukset")
	public @ResponseBody Optional<Vastaus> findVastauksetByKysymys(@PathVariable("id") Long kysymysId) {

		return repository.findAllById(kysymysId);
	}
}
