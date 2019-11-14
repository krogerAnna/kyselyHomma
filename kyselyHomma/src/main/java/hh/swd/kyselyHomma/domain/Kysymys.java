package hh.swd.kyselyHomma.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Kysymys {
	
	//attribuutit
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kysymysId;
	private String content;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="kysymys")
	private List<Vastaus> vastaukset;
	
	
	//konstuktorit
	public Kysymys() {}
	
	public Kysymys(String content) {
		super();
		this.content = content;
	}

	//getterit
	public Long getKysymysId() {
		return kysymysId;
	}

	public String getContent() {
		return content;
	}
	
	public void getVastaukset(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}
	
	//setterit
	public void setKysymysId(Long id) {
		this.kysymysId = id;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void setVastaukset(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}
	
	

}
