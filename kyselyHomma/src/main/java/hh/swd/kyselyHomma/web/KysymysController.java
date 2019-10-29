package hh.swd.kyselyHomma.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hh.swd.kyselyHomma.domain.Kysymys;
import hh.swd.kyselyHomma.domain.KysymysRepository;

//@RestController
@Controller
public class KysymysController {

	private final KysymysRepository repository;
	
	KysymysController(KysymysRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/kysymykset")
	List<Kysymys> all() {
		return repository.findAll();
	}
	@GetMapping("/lisaakysymys")
	public String lisaaKysymys(Model model) {
		model.addAttribute("kysymys", new Kysymys());
		model.addAttribute("kysymykset", all());
		return "lisaakysymys";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Kysymys kysymys) {
		repository.save(kysymys);
		return "redirect:lisaakysymys";
	}
}
