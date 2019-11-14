package hh.swd.kyselyHomma.web;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import hh.swd.kyselyHomma.domain.Kysymys;
import hh.swd.kyselyHomma.domain.Vastaus;
import hh.swd.kyselyHomma.domain.VastausRepository;


@Controller
public class VastausController {

	private final VastausRepository vrepository;
	
	VastausController ( VastausRepository vrepository ) {
		this.vrepository = vrepository;
	}
	
	@PostMapping("/savevastaus")
	public void saveVastaus(Vastaus vastaus) {
		vrepository.save(vastaus);
	}

}
