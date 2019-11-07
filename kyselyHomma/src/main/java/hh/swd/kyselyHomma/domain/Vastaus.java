package hh.swd.kyselyHomma.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vastaus {
	
	//attribuutit
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String content;
	
	@ManyToOne
	@JoinColumn(name="kysymys")
	private Kysymys kysymys;
	
	
	//konstruktorit
	public Vastaus() {
		super();
	}

	public Vastaus(String content, Kysymys kysymys) {
		super();
		this.content = content;
		this.kysymys = kysymys;
	}

	public Long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public Kysymys getKysymys() {
		return kysymys;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}

}
