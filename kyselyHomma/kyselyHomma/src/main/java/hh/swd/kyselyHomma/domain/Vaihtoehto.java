package hh.swd.kyselyHomma.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vaihtoehto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long vaihtoehtoId;
	private String content;
	
	@ManyToOne
	@JoinColumn(name="kysymysId")
	private Kysymys kysymys;
	
	public Vaihtoehto() {
		super();
	}


	public Vaihtoehto(String content) {
		super();
		this.content = content;
	}


	//Setters
	public void setVaihtoehtoId(Long vaihtoehtoId) {
		this.vaihtoehtoId = vaihtoehtoId;
	}


	public void setContent(String content) {
		this.content = content;
	}

	//Getters
	public Long getVaihtoehtoId() {
		return vaihtoehtoId;
	}


	public String getContent() {
		return content;
	}


	@Override
	public String toString() {
		return "Vaihtoehto [vaihtoehtoId=" + vaihtoehtoId + ", content=" + content + ", kysymys=" + kysymys + "]";
	}
	
	
	
	
}
