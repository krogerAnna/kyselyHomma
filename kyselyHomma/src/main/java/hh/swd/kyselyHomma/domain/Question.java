package hh.swd.kyselyHomma.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kysymysId;
	private String content;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="kysymys")
	private List<Answer> vastaukset;
	
//	@ManyToOne
//	@JoinColumn(name="kyselyId")
//	private Kysely kysely;
	
	
	//konstuktorit
	public Question() {}
	
	public Question(String content /*Kysely kysely*/) {
		super();
		this.content = content;
//		this.kysely = kysely;

	}
	
	//setterit
	public void setKysymysId(Long id) {
		this.kysymysId = id;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void setVastaukset(List<Answer> vastaukset) {
		this.vastaukset = vastaukset;
	}
	
//	public void setKysely(Kysely kysely) {
//		this.kysely = kysely;
//	}
	
	//getterit
	public Long getKysymysId() {
		return kysymysId;
	}

	public String getContent() {
		return content;
	}
	
	public List<Answer> getVastaukset() {
		return vastaukset;
	}
	
//	public Kysely getKysely() {
//		return kysely;
//	}

	//toString
	@Override
	public String toString() {
		return "Kysymys [kysymysId=" + kysymysId + ", content=" + content + ", vastaukset=" + vastaukset /*+ ", kysely="
				+ kysely*/ + "]";
	}
	
}
