package hh.swd.kyselyHomma.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd.kyselyHomma.domain.KyselyRepository;
import hh.swd.kyselyHomma.domain.Kysymys;
import hh.swd.kyselyHomma.domain.KysymysRepository;
 
@Controller
public class KysymysController {


	@Autowired
	private KysymysRepository kysymysRepo;
	@Autowired
	private KyselyRepository kyselyRepo;

	
	//Palauttaa etusivun
	@GetMapping("/")
	public String index() {
		return "welcome";
	}
	
	//REST homepage
	@GetMapping("/resthome")
	public String restHomePage() {
		return "resthome";
	}
	
	//Annetaan model attributet Thymeleaf-templatelle
	@GetMapping("/lisaakysymys")
	public String lisaaKysymys(Model model) {
		model.addAttribute("kysymys", new Kysymys());
		model.addAttribute("kyselyt", kyselyRepo.findAll());
		return "lisaakysymys";
	}
	
	//Tallentaa uuden kysymyksen
	@PostMapping("/savekysymys")
	public String saveKysymys(Kysymys kysymys) {
		kysymysRepo.save(kysymys);
		return "redirect:lisaakysymys";
	}
	
	//Poista kysymys
	@GetMapping("/poistakysymys/{id}")
	public String deleteKysymys(@PathVariable("id") Long kysymysId) {
		kysymysRepo.deleteById(kysymysId);
		return "redirect:../lisaakysymys";
	}
	
	//kysymys droppivalikko
	
	
	
	
	// **** Kysymys RESTit **** //

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
	
}
