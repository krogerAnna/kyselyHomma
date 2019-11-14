package hh.swd.kyselyHomma.web;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.swd.kyselyHomma.domain.Kysymys;
import hh.swd.kyselyHomma.domain.KysymysRepository;
 
@RestController
public class KysymysController {


	@Autowired
	private KysymysRepository repository;

	
	//Palauttaa etusivun
	@GetMapping("/")
	public String index() {
		return "welcome";
	}
	
	//REST Etsii ja palauttaa kaikki kysymykset
	@GetMapping("/kysymykset")
	@ResponseBody List<Kysymys> kysymykset() {
		return repository.findAll();
	}
	
	//REST homepage
	@GetMapping("/resthome")
	public String restHomePage() {
		return "resthome";
	}
	
	//REST Kysymys getById
	@GetMapping("/kysymykset/{id}")
	public @ResponseBody Optional<Kysymys> findKysymysRest(@PathVariable("id") Long id) {
		return repository.findById(id);
	}
	

	//Annetaan model attributet Thymeleaf-templatelle
	@GetMapping("/lisaakysymys")
	public String lisaaKysymys(Model model) {
		model.addAttribute("kysymys", new Kysymys());
		model.addAttribute("kysymykset", repository.findAll());
		return "lisaakysymys";
	}
	
	@PostMapping("/kysymykset")
	Kysymys newKysymys(@RequestBody Kysymys newKysymys) {
	    return repository.save(newKysymys);
	  }
	
	//Tallentaa uuden kysymyksen
	@PostMapping("/save")
	public String save(Kysymys kysymys) {
		repository.save(kysymys);
		return "redirect:lisaakysymys";
	}
	
	//Poista kysymys
	@GetMapping("/poistakysymys/{id}")

	public String delete(@PathVariable("id") Long kysymysId) {
		repository.deleteById(kysymysId);

		return "redirect:../lisaakysymys";
	}
	
	
}
