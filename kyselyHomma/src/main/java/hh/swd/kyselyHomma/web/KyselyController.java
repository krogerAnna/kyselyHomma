package hh.swd.kyselyHomma.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd.kyselyHomma.domain.Kysely;
import hh.swd.kyselyHomma.domain.KyselyRepository;
import hh.swd.kyselyHomma.domain.Kysymys;
import hh.swd.kyselyHomma.domain.KysymysRepository;
import hh.swd.kyselyHomma.domain.Vastaus;

@Controller
public class KyselyController {

	// **** Kysely RESTit **** //

	@Autowired
	private KyselyRepository kyselyRepo;
	@Autowired
	private KysymysRepository kysymysRepo;

	// Etsii ja palauttaa kaikki kyselyt
	@GetMapping("/kyselyt")
	@ResponseBody
	List<Kysely> kyselyt() {
		return kyselyRepo.findAll();
	}

	// getById
	@GetMapping("/kyselyt/{id}")
	public @ResponseBody Optional<Kysely> findKysely(@PathVariable("id") Long kyselyId) {
		return kyselyRepo.findById(kyselyId);
	}
	
//	@PostMapping("kyselyt/{id}/kysymykset")
//	public @ResponseBody Kysymys addKysymysToKysely(@PathVariable("id") Long kyselyId, @RequestBody Kysymys kysymys) {
//		Optional<Kysely> kysely = kyselyRepo.findById(kyselyId);
//		kysely.get().setKysymys(kysymys);
//		return kyselyRepo.save(kysely);
//	}

	// kaikki x-kyselyn kysymykset

	// Etsii ja palauttaa kaikki kysymykset
	// @GetMapping("/kysymykset")
	// @ResponseBody List<Kysymys> kysymykset() {
	// return kysymysRepo.findAll();
	// }
	
//	@PostMapping("/kyselyt/{id}/kysymykset")
//	public @ResponseBody List<Kysymys> addKysymykset(@PathVariable("id") Long kyselyId, @RequestBody List<Kysymys> lisattavatKysymykset) {
//		Optional<Kysely> kysely = kyselyRepo.findById(kyselyId);
//		kysely.get().setKysymykset(lisattavatKysymykset);
//		return kyselyRepo.save(kysely);
//		
//	}

	@GetMapping("/kyselyt/{id}/kysymykset")
	public @ResponseBody List<Kysymys> findByKysely(@PathVariable("id") Long kyselyId) {
		Optional<Kysely> kysely = kyselyRepo.findById(kyselyId);
		return kysymysRepo.findAllByKysely(kysely);
	}// ei toimi vielä

	
	@GetMapping("kyselyt/{id}/vastaukset")
	public @ResponseBody List<Vastaus> findVastauksetByKysely(@PathVariable("id") Long kyselyId) {
		
		// haetaan kysymykset kyselyn perusteella
		
		Optional<Kysely> kysely = kyselyRepo.findById(kyselyId);
		List<Kysymys> kysymykset = kysymysRepo.findAllByKysely(kysely);
		List<Vastaus> vastaukset = new ArrayList<Vastaus>();
		List<Vastaus> kysymyksenVastaukset = new ArrayList<Vastaus>();

		// käydään taulukko läpi 
		// jokaisen kysymys-olion kohdalla haetaan sen sisältämät vastaukset ja talletetaan ne muuttujaan
		// sitten iteroidaan muuttujan "kysymyksenVastaukset", joka on taulukko, läpi ja lisätään jokainen sen sisältämä
		// vastaus muuttujaan "vastaukset"
		// lopulta tämä palautetaan
		
//		ArrayList<Vastaus> vastaukset = kysymykset.stream()
//		.map(kysymys -> kysymys.getVastaukset())
//		.collect(Collectors.toCollection(ArrayList::new));
		
		for (Kysymys kysymys : kysymykset) {
			kysymyksenVastaukset = kysymys.getVastaukset();
			for (Vastaus vastaus : kysymyksenVastaukset) {
				vastaukset.add(vastaus);
			}
			
		}
		
		return vastaukset;
	}
	
	// Uuden kyselyn luominen
	
	@PostMapping("/kyselyt")
	public @ResponseBody Kysely createNewKysely(@RequestBody Kysely kysely) {
		return kyselyRepo.save(kysely);
	}

}