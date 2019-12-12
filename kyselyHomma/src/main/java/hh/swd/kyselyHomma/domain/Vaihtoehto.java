package hh.swd.kyselyHomma.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Vaihtoehto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long vaihtoehtoId;
	private String content;
	

	//@JsonIgnore
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="kysymysId")
	private Kysymys kysymys;
	
	public Vaihtoehto() {
		super();
	}


	public Vaihtoehto(String content, Kysymys kysymys) {
		super();
		this.content = content;
		this.kysymys = kysymys;
	}


	//Setters
	public void setVaihtoehtoId(Long vaihtoehtoId) {
		this.vaihtoehtoId = vaihtoehtoId;
	}


	public void setContent(String content) {
		this.content = content;
	}

	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}


	//Getters
	public Long getVaihtoehtoId() {
		return vaihtoehtoId;
	}


	public String getContent() {
		return content;
	}


	public Kysymys getKysymys() {
		return kysymys;
	}
	
}
