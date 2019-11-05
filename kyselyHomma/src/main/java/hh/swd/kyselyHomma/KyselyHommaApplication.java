package hh.swd.kyselyHomma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd.kyselyHomma.domain.Kysymys;
import hh.swd.kyselyHomma.domain.KysymysRepository;

@SpringBootApplication
public class KyselyHommaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyselyHommaApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(KysymysRepository repository) {
		return (args)  -> {	
			repository.save(new Kysymys("Status?"));
			repository.save(new Kysymys("Kuinka usein asioit kouluruokalassa?"));
			repository.save(new Kysymys("Jos et asioi ollenkaan tai todella harvoin niin miksi?"));
			repository.save(new Kysymys("Mikä lisäisi/parantaisi ruokalassa asioimistasi?"));
			repository.save(new Kysymys("Jos vastasit äskeiseen kysymykseen 'Muu' kirjoita alle mitä se olisi:"));
			repository.save(new Kysymys("Halutessasi voit kirjoittaa tähän lisätietoja koskien vastauksiasi tai, jos mielessäsi on jotain, mitä emme tulleet kysyneeksi:"));

		
		};
	}
}
