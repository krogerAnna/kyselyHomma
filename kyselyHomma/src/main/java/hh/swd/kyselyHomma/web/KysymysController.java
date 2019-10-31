package hh.swd.kyselyHomma.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd.kyselyHomma.domain.Kysymys;
import hh.swd.kyselyHomma.domain.KysymysRepository;
 
@Controller
public class KysymysController {

	private final KysymysRepository repository;
	
	
	KysymysController (KysymysRepository repository) {
		this.repository = repository;
	}
	
	//Palauttaa etusivu
	@GetMapping("/")
	public String index() {
		return "welcome";
	}
	
	//Etsii ja palauttaa kaikki kysymykset
	@GetMapping("/kysymykset")
	@ResponseBody List<Kysymys> kysymykset() {
		return repository.findAll();
	}
	
	//Annetaan model attributet Thymeleaf-templatelle
	@GetMapping("/lisaakysymys")
	public String lisaaKysymys(Model model) {
		model.addAttribute("kysymys", new Kysymys());
		model.addAttribute("kysymykset", kysymykset());
		return "lisaakysymys";
	}
	
	//Tallentaa uuden kysymyksen
	@PostMapping("/save")
	public String save(Kysymys kysymys) {
		repository.save(kysymys);
		return "redirect:lisaakysymys";
	}
}
