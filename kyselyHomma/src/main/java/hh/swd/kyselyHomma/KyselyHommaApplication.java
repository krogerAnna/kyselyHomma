package hh.swd.kyselyHomma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd.kyselyHomma.domain.Kysymys;
import hh.swd.kyselyHomma.domain.KysymysRepository;

@SpringBootApplication
public class KyselyHommaApplication {

	////////:))))
	//HEi tää on mun kommentti hei kattokaa
	public static void main(String[] args) {
		SpringApplication.run(KyselyHommaApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(KysymysRepository repository) {
		return (args)  -> {	
			repository.save(new Kysymys("Keitä minä olen?"));
			repository.save(new Kysymys("Miksi?"));
			repository.save(new Kysymys("Kuka?"));
		};
	}
}
