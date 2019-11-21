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

@Controller
public class KyselyController {

	
	// **** Kysely RESTit **** //
	  
	  @Autowired
		private KyselyRepository kyselyRepo;
	  @Autowired
	  private KysymysRepository kysymysRepo;
		
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
		
		
		// kaikki x-kyselyn kysymykset
		
			// Etsii ja palauttaa kaikki kysymykset
							//@GetMapping("/kysymykset")
							//@ResponseBody List<Kysymys> kysymykset() {
							//	return kysymysRepo.findAll();
							//}
							
		@GetMapping("/kyselyt/{id}/kysymykset")
		public @ResponseBody List<Kysymys> findByKysely(@PathVariable("id") Long kyselyId) {
			Optional<Kysely> kysely = kyselyRepo.findById(kyselyId);
			return kysymysRepo.findAllByKysely(kysely);
		}//ei toimi vielä
	
	
}
