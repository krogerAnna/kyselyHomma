package hh.swd.kyselyHomma.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd.kyselyHomma.domain.Kysymys;
import hh.swd.kyselyHomma.domain.Vastaus;
import hh.swd.kyselyHomma.domain.VastausRepository;



public class VastausController {

	private final VastausRepository vrepository;
	
	VastausController ( VastausRepository vrepository ) {
		this.vrepository = vrepository;
	}
	
	@GetMapping("/vastaukset")
	@ResponseBody List<Vastaus> vastaukset() {
		return vrepository.findAll();
	}
	
	@PostMapping("/save")
	public String saveVastaus(Vastaus vastaus) {
		vrepository.save(vastaus);
		return "vastaukset";
	}
}
