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

import hh.swd.kyselyHomma.domain.KyselyRepository;
import hh.swd.kyselyHomma.domain.Kysymys;
import hh.swd.kyselyHomma.domain.KysymysRepository;
import hh.swd.kyselyHomma.domain.TypeRepository;
import hh.swd.kyselyHomma.domain.Vaihtoehto;
import hh.swd.kyselyHomma.domain.VaihtoehtoRepository;
 
@Controller
public class KysymysController {


	@Autowired
	private KysymysRepository kysymysRepo;
	@Autowired
	private KyselyRepository kyselyRepo;
	@Autowired
	private VaihtoehtoRepository vaihtoehtoRepo;
	@Autowired
	private TypeRepository typeRepo;
	
	
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
		model.addAttribute("typet", typeRepo.findAll());
		return "lisaakysymys";
	}
	
	//Tallentaa uuden kysymyksen
	@PostMapping("/kysymykset")
	public @ResponseBody Kysymys lisaaKysymysRest(@RequestBody Kysymys kysymys) {
		return kysymysRepo.save(kysymys);
		
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
	
	//Hae kaikki vaihtoehdot
	@GetMapping("/vaihtoehdot")
	@ResponseBody List<Vaihtoehto> vaihtoehdot() {
		return vaihtoehtoRepo.findAll();
	}
	
	//Hae vaihtoehdot kysymyksittäin
 	@GetMapping("/kysymykset/{id}/vaihtoehdot")
	public @ResponseBody List<Vaihtoehto> findAllByKysymys(@PathVariable("id") Long kysymysId) {
		Optional<Kysymys> kysymys = kysymysRepo.findById(kysymysId);
		return vaihtoehtoRepo.findAllByKysymys(kysymys);
	}
}
 	
