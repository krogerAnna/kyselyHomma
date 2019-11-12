package hh.swd.kyselyHomma.web;

import org.springframework.web.bind.annotation.PostMapping;

import hh.swd.kyselyHomma.domain.Vastaus;
import hh.swd.kyselyHomma.domain.VastausRepository;



public class VastausController {

	private final VastausRepository vrepository;
	
	VastausController ( VastausRepository vrepository ) {
		this.vrepository = vrepository;
	}
	
	@PostMapping("/save")
	public String saveVastaus(Vastaus vastaus) {
		vrepository.save(vastaus);
		return "kysymykset";
	}
}