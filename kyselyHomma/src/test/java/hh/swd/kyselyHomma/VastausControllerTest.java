package hh.swd.kyselyHomma;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PostMapping;

import hh.swd.kyselyHomma.domain.Vastaus;
import hh.swd.kyselyHomma.domain.VastausRepository;





@RunWith(SpringRunner.class)
@DataJpaTest
public class VastausControllerTest {

	@Autowired
	private VastausRepository repository;


	

	@Test
	public void createNewVastaus() {
		Vastaus vastaus = new Vastaus("Juujoo", null);
		repository.save(vastaus);
		
		
		
	}

/*	@Test
	public void deleteCategory() {
		Genre genre = new Genre("Toiminta");
		grepository.save(genre);
		grepository.delete(genre);

	}

	

	@Test
	public void createNewUser() {
		User user2 = new User("user2", "salasana", "user@gmail.com",
				"USER");
		urepository.save(user2);
	}

	@Test
	public void deleteUser() {
		User user2 = new User("user2", "salasana", "user@gmail.com",
				"USER");
		urepository.save(user2);
		assertThat(user2.getId()).isNotNull();
		Long userId = user2.getId();
		urepository.deleteById(userId);*/

	}