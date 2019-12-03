package hh.swd.kyselyHomma.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Kysely {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kyselyId;
	private String name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="kysely")
	private List<Kysymys> kysymykset;
	
	
	
	
	//konstruktorit
	public Kysely() {}

	public Kysely(String name) {
		super();
		this.name = name;
	}

	
	//setterit
	public void setKyselyId(Long kyselyId) {
		this.kyselyId = kyselyId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setKysymykset(List<Kysymys> kysymykset) {
		this.kysymykset = kysymykset;
	}

	//getterit
	public Long getKyselyId() {
		return kyselyId;
	}

	public String getName() {
		return name;
	}

	public List<Kysymys> getKysymykset() {
		return kysymykset;
	}

	//toString
	@Override
	public String toString() {
		return "Kysely [kyselyId=" + kyselyId + ", name=" + name + ", kysymykset=" + kysymykset + "]";
	}
	
}
