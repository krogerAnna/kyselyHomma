package hh.swd.kyselyHomma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd.kyselyHomma.domain.Kysely;
import hh.swd.kyselyHomma.domain.KyselyRepository;
import hh.swd.kyselyHomma.domain.Question;
import hh.swd.kyselyHomma.domain.QuestionRepository;
import hh.swd.kyselyHomma.domain.Answer;
import hh.swd.kyselyHomma.domain.AnswerRepository;

@SpringBootApplication
public class KyselyHommaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyselyHommaApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(QuestionRepository kysymysRepo, AnswerRepository vastausRepo, KyselyRepository kyselyRepo) {
		return (args)  -> {	
			
			Kysely kouluRuoka = new Kysely("Kouluruokala");
			kyselyRepo.save(kouluRuoka);
			
			 
			Question q = new Question("Status?");
			Question w = new Question("Kuinka usein asioit kouluruokalassa?");
			Question e = new Question("Jos et asioi ollenkaan tai todella harvoin niin miksi?");
			Question r = new Question("Mikä lisäisi/parantaisi ruokalassa asioimistasi?");
			Question t = new Question("Jos vastasit äskeiseen kysymykseen 'Muu' kirjoita alle mitä se olisi:");
			Question y = new Question("Halutessasi voit kirjoittaa tähän lisätietoja koskien vastauksiasi tai, jos mielessäsi on jotain, mitä emme tulleet kysyneeksi:");
			
			kysymysRepo.save(q);
			kysymysRepo.save(w);
			kysymysRepo.save(e);
			kysymysRepo.save(r);
			kysymysRepo.save(t);
			kysymysRepo.save(y);
			
			vastausRepo.save(new Answer("Opiskelija", q));
			vastausRepo.save(new Answer("En ikinä", w));
			vastausRepo.save(new Answer("Olen nirso", e));
			vastausRepo.save(new Answer("Parempi ruoka", r));
			vastausRepo.save(new Answer("-", t));
			vastausRepo.save(new Answer("Ei tule mitään mieleen.", y));
			
			
		
		};
	}
}
