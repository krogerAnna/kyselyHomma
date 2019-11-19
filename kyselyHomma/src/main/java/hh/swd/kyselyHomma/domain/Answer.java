package hh.swd.kyselyHomma.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long vastausId;
	private String content;
	
	
	@ManyToOne
	@JoinColumn(name="kysymysId")
	private Question kysymys;
	
	
	//konstruktorit
	public Answer() {
		super();
	}

	public Answer(String content, Question kysymys) {
		super();
		this.content = content;
		this.kysymys = kysymys;
	}

	//setterit
	public void setVastausId(Long id) {
		this.vastausId = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setKysymys(Question kysymys) {
		this.kysymys = kysymys;
	}
	
	//getterit
	public Long getVastausId() {
		return vastausId;
	}

	public String getContent() {
		return content;
	}

	public Question getKysymys() {
		return kysymys;
	}

	//toString
	@Override
	public String toString() {
		return "Vastaus [vastausId=" + vastausId + ", content=" + content + ", kysymys=" + kysymys + "]";
	}
	
}
