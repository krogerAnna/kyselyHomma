package hh.swd.kyselyHomma.web;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import hh.swd.kyselyHomma.domain.Question;
import hh.swd.kyselyHomma.domain.Answer;
import hh.swd.kyselyHomma.domain.AnswerRepository;


@Controller
public class VastausController {

	private final AnswerRepository vrepository;
	
	VastausController ( AnswerRepository vrepository ) {
		this.vrepository = vrepository;
	}
	
	@PostMapping("/savevastaus")
	public void saveVastaus(Answer vastaus) {
		vrepository.save(vastaus);
	}

}
