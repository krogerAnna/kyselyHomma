package hh.swd.kyselyHomma.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.swd.kyselyHomma.domain.KyselyRepository;
import hh.swd.kyselyHomma.domain.Kysymys;
import hh.swd.kyselyHomma.domain.KysymysRepository;
import hh.swd.kyselyHomma.domain.Vastaus;
import hh.swd.kyselyHomma.domain.VastausRepository;

@Controller
public class RESTController {

	@Autowired
	private KysymysRepository kysymysRepo;
	
	//REST homepage
	@GetMapping("/resthome")
	public String restHomePage() {
		return "resthome";
	}
	
	//KysymysRESTit
	
	//REST Etsii ja palauttaa kaikki kysymykset
	@GetMapping("/kysymykset")
	@ResponseBody List<Kysymys> kysymykset() {
		return kysymysRepo.findAll();
	}
	
	//REST getById
	@GetMapping("/kysymykset/{id}")
	public @ResponseBody Optional<Kysymys> findKysymysRest(@PathVariable("id") Long kysymysId) {
		return kysymysRepo.findById(kysymysId);
	}
	
	
	//Vastaus RESTit
	
	@Autowired VastausRepository vastausRepo;
	
	//REST Etsii kaikki vastaukset
	@GetMapping("/vastaukset")
	@ResponseBody List<Vastaus> vastaukset() {
		return vastausRepo.findAll();
	}
	
	// getById
	@GetMapping("vastaukset/{id}")
	public @ResponseBody Optional<Vastaus> findVastausRest(@PathVariable("id") Long vastausId) {
		return vastausRepo.findById(vastausId);
	}
	
	//REST etsii kaikki vastaukset tietystä kysymyksestä
	@GetMapping("/kyselyt/{id}/kysymykset") //id = kyselyId
	public @ResponseBody List<Kysymys> findKyselynKysymykset(@PathVariable("id") Long kyselyId) {
		return kysymysRepo.findByKysely(kyselyId);
	}
	
	//Kysely RESTit
	
	@Autowired KyselyRepository kyselyRepo;
	

}
