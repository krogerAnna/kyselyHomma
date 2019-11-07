package hh.swd.kyselyHomma.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kysymys {
	
	//attribuutit
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String content;
	
	
	//konstuktorit
	public Kysymys() {}
	
	public Kysymys(String content) {
		super();
		this.content = content;
	}

	//getterit
	public Long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	
	//setterit
	public void setId(Long id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}
