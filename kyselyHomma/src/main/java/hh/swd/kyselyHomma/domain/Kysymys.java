package hh.swd.kyselyHomma.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Kysymys {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kysymysId;
	private String content;
	

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy="kysymys")
	private List<Vastaus> vastaukset;
	

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="kyselyId")
	private Kysely kysely;
	
	// ei tarvita jsonIgnorea
	//@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="typeId")
	private Type type;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy="kysymys")
	private List<Vaihtoehto> vaihtoehdot;
	
	//konstuktorit
	public Kysymys() {}
	
//	public Kysymys(String content, Kysely kysely, Type type) {
//		super();
//		this.content = content;
//		this.kysely = kysely;
//		this.type = type;
//	}
	
	public Kysymys(String content, Kysely kysely, Type type) {
		super();
		this.content = content;
		this.kysely = kysely;
		this.type = type;
		this.vaihtoehdot = new ArrayList<>();
	}
	
//	public Kysymys(String content, Type type, Kysely kysely) {
//		super();
//		this.content = content;
//		this.type = type;
//		this.vaihtoehdot = new ArrayList<>();
//		this.kysely = kysely;
//		
//	}
	
	public Kysymys(String content, Kysely kysely, Type type, List<Vaihtoehto> vaihtoehdot) {
		super();
		this.content = content;
		this.kysely = kysely;
		this.type = type;
		// toimiiko?
		this.vaihtoehdot = new ArrayList<Vaihtoehto>(vaihtoehdot);
	}
	
	
	//setterit
	
	public void setVaihtoehto(Vaihtoehto vaihtoehto) {
		vaihtoehdot.add(vaihtoehto);
	}

	public void setKysymysId(Long id) {
		this.kysymysId = id;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void setVastaukset(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}
	
	public void setKysely(Kysely kysely) {
		this.kysely = kysely;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public void setVaihtoehdot(List<Vaihtoehto> vaihtoehdot) {
		this.vaihtoehdot = vaihtoehdot;
	}
	
	//getterit
	public Long getKysymysId() {
		return kysymysId;
	}

	public String getContent() {
		return content;
	}
	
	public List<Vastaus> getVastaukset() {
		return vastaukset;
	}
	
	public Kysely getKysely() {
		return kysely;
	}

	public Type getType() {
		return type;
	}
	
	public List<Vaihtoehto> getVaihtoehdot() {
		return vaihtoehdot;
	}

	//toString
	@Override
	public String toString() {
		return "Kysymys [kysymysId=" + kysymysId + ", content=" + content + ", vastaukset=" + vastaukset + ", kysely="
				+ kysely + "]";
	}

//	public void addVaihtoehto(Vaihtoehto opiskelija) {
//		// TODO Auto-generated method stub
//		
//	}
	
}
