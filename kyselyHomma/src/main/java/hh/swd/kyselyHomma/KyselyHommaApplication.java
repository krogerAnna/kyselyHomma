package hh.swd.kyselyHomma;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd.kyselyHomma.domain.Kysely;
import hh.swd.kyselyHomma.domain.KyselyRepository;
import hh.swd.kyselyHomma.domain.Kysymys;
import hh.swd.kyselyHomma.domain.KysymysRepository;
import hh.swd.kyselyHomma.domain.Type;
import hh.swd.kyselyHomma.domain.TypeRepository;
import hh.swd.kyselyHomma.domain.Vaihtoehto;
import hh.swd.kyselyHomma.domain.VaihtoehtoRepository;
import hh.swd.kyselyHomma.domain.Vastaus;
import hh.swd.kyselyHomma.domain.VastausRepository;

@SpringBootApplication
public class KyselyHommaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyselyHommaApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(KysymysRepository kysymysRepo, VastausRepository vastausRepo, KyselyRepository kyselyRepo, TypeRepository typeRepo, VaihtoehtoRepository vaihtoRepo) {
		return (args)  -> {	
			
			//kaikki vaihtoehdot kysymyksen tyypille
			Type tyyppi1 = new Type("open");
			Type tyyppi2 = new Type("dropdown");
			Type tyyppi3 = new Type("multiplechoice");
			typeRepo.save(tyyppi1);
			typeRepo.save(tyyppi2);
			typeRepo.save(tyyppi3);
			
			//eka kysely
			Kysely kouluRuoka = new Kysely("Kouluruokala");
			kyselyRepo.save(kouluRuoka);
			
			Kysymys q = new Kysymys("Status?", kouluRuoka, tyyppi2);
			Kysymys w = new Kysymys("Kuinka usein asioit kouluruokalassa?", kouluRuoka, tyyppi1);
			Kysymys e = new Kysymys("Jos et asioi ollenkaan tai todella harvoin niin miksi?", kouluRuoka, tyyppi1);
			Kysymys r = new Kysymys("Mikä lisäisi/parantaisi ruokalassa asioimistasi?", kouluRuoka, tyyppi3);
			Kysymys t = new Kysymys("Jos vastasit äskeiseen kysymykseen 'Muu' kirjoita alle mitä se olisi:", kouluRuoka, tyyppi1);
			Kysymys y = new Kysymys("Halutessasi voit kirjoittaa tähän lisätietoja koskien vastauksiasi tai, jos mielessäsi on jotain, mitä emme tulleet kysyneeksi:", kouluRuoka, tyyppi1);
			
			kysymysRepo.save(q);
			kysymysRepo.save(w);
			kysymysRepo.save(e);
			kysymysRepo.save(r);
			kysymysRepo.save(t);
			kysymysRepo.save(y);
			
			//kysymyksen q vaihtoehdot
			Vaihtoehto opiskelija = new Vaihtoehto("Opiskelija", q);
			Vaihtoehto opettaja = new Vaihtoehto("Opettaja", q);
			Vaihtoehto muu = new Vaihtoehto("Muu", q);
			vaihtoRepo.save(opiskelija);
			vaihtoRepo.save(opettaja);
			vaihtoRepo.save(muu);

			//kysymyksen r vaihtoehdot
			Vaihtoehto ruoka = new Vaihtoehto("Ruoan laadun parannus", r);
			Vaihtoehto palvelu = new Vaihtoehto("Palvelun laatu", r);
			Vaihtoehto hinta = new Vaihtoehto("Hintojen muutos", r);
			Vaihtoehto siisteys = new Vaihtoehto("Yleisen siisteyden parantaminen", r);
			Vaihtoehto muuu = new Vaihtoehto("Muu", r);
			vaihtoRepo.save(ruoka);
			vaihtoRepo.save(palvelu);
			vaihtoRepo.save(hinta);
			vaihtoRepo.save(siisteys);
			vaihtoRepo.save(muuu);

			vastausRepo.save(new Vastaus("Opiskelija", q));
			vastausRepo.save(new Vastaus("En ikinä", w));
			vastausRepo.save(new Vastaus("Olen nirso", e));
			vastausRepo.save(new Vastaus("Ruoan laadun parannus", r));
			vastausRepo.save(new Vastaus("-", t));
			vastausRepo.save(new Vastaus("Ei tule mitään mieleen.", y));
			
			//toka kysely + sen kysymykset
			Kysely miniKysely = new Kysely("Kulttuurivinkkaus -kysely");
			kyselyRepo.save(miniKysely);
			
			Kysymys a = new Kysymys("Mitä elokuvaa suosittelet?", miniKysely, tyyppi1);
			Kysymys b = new Kysymys("Mitä tv-sarjaa suosittelet?", miniKysely, tyyppi1);
			Kysymys c = new Kysymys("Mitä musiikkia suosittelet?", miniKysely, tyyppi1);
			
			kysymysRepo.save(a);
			kysymysRepo.save(b);
			kysymysRepo.save(c);
			
			vastausRepo.save(new Vastaus("Onnelin ja Annelin talvi", a));
			vastausRepo.save(new Vastaus("Kafka (Steven Soderbergh)", a));
			vastausRepo.save(new Vastaus("Pikkukakkonen", b));
			vastausRepo.save(new Vastaus("Metsien kätkemä", b));
			vastausRepo.save(new Vastaus("Marcus ja Martinus", c));
			vastausRepo.save(new Vastaus("Piazzolla Tangos", c));
			
		};
	}
}
