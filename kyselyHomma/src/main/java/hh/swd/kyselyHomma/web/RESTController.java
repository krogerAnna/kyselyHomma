package hh.swd.kyselyHomma.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.swd.kyselyHomma.domain.Question;
import hh.swd.kyselyHomma.domain.QuestionRepository;
import hh.swd.kyselyHomma.domain.Answer;
import hh.swd.kyselyHomma.domain.AnswerRepository;

@Controller
public class RESTController {

	@Autowired
	private QuestionRepository kysymysRepo;
	
	//KysymysRESTit
	
	//REST Etsii ja palauttaa kaikki kysymykset
	@GetMapping("/kysymykset")
	@ResponseBody List<Question> kysymykset() {
		return kysymysRepo.findAll();
	}
	
	
	
	//REST getById
	@GetMapping("/kysymykset/{id}")
	public @ResponseBody Optional<Question> findKysymysRest(@PathVariable("id") Long kysymysId) {
		return kysymysRepo.findById(kysymysId);
	}
	
	
	//Vastaus RESTit
	
	@Autowired AnswerRepository vastausRepo;
	
	//REST Etsii kaikki vastaukset
	@GetMapping("/vastaukset")
	@ResponseBody List<Answer> vastaukset() {
		return vastausRepo.findAll();
	}
	
	// getById
	@GetMapping("vastaukset/{id}")
	public @ResponseBody Optional<Answer> findVastausRest(@PathVariable("id") Long vastausId) {
		return vastausRepo.findById(vastausId);
	}
}
