package hh.swd.kyselyHomma.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Kysely {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kyselyId;
	private String nimi;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="kysymys")
	private List<Kysymys> kysymykset;
	
	
	//konstruktorit
	public Kysely() {}

	public Kysely(String nimi) {
		super();
		this.nimi = nimi;
	}

	
	//setterit
	public void setKyselyId(Long kyselyId) {
		this.kyselyId = kyselyId;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public void setKysymykset(List<Kysymys> kysymykset) {
		this.kysymykset = kysymykset;
	}

	//getterit
	public Long getKyselyId() {
		return kyselyId;
	}

	public String getNimi() {
		return nimi;
	}

	public List<Kysymys> getKysymykset() {
		return kysymykset;
	}

	//toString
	@Override
	public String toString() {
		return "Kysely [kyselyId=" + kyselyId + ", nimi=" + nimi + ", kysymykset=" + kysymykset + "]";
	}
	
}
