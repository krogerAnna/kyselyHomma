package hh.swd.kyselyHomma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd.kyselyHomma.domain.Kysymys;
import hh.swd.kyselyHomma.domain.KysymysRepository;
import hh.swd.kyselyHomma.domain.Vastaus;
import hh.swd.kyselyHomma.domain.VastausRepository;

@SpringBootApplication
public class KyselyHommaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyselyHommaApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(KysymysRepository kysymysRepo, VastausRepository vastausRepo) {
		return (args)  -> {	
			
			Kysymys q = new Kysymys("Status?");
			Kysymys w = new Kysymys("Kuinka usein asioit kouluruokalassa?");
			Kysymys e = new Kysymys("Jos et asioi ollenkaan tai todella harvoin niin miksi?");
			Kysymys r = new Kysymys("Mikä lisäisi/parantaisi ruokalassa asioimistasi?");
			Kysymys t = new Kysymys("Jos vastasit äskeiseen kysymykseen 'Muu' kirjoita alle mitä se olisi:");
			Kysymys y = new Kysymys("Halutessasi voit kirjoittaa tähän lisätietoja koskien vastauksiasi tai, jos mielessäsi on jotain, mitä emme tulleet kysyneeksi:");
			
			kysymysRepo.save(q);
			kysymysRepo.save(w);
			kysymysRepo.save(e);
			kysymysRepo.save(r);
			kysymysRepo.save(t);
			kysymysRepo.save(y);
			
			vastausRepo.save(new Vastaus("Opiskelija", q));
			vastausRepo.save(new Vastaus("En ikinä", w));
			vastausRepo.save(new Vastaus("Olen nirso", e));
			vastausRepo.save(new Vastaus("Parempi ruoka", r));
			vastausRepo.save(new Vastaus("-", t));
			vastausRepo.save(new Vastaus("Ei tule mitään mieleen.", y));
			
			
		
		};
	}
}
