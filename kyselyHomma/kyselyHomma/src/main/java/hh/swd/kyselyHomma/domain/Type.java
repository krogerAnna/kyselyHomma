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
public class Type {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long typeId;
	private String type;
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="type")
	private List<Kysymys> kysymykset;

	
	public Type() {}
	
	public Type(String type) {
		super();
		this.type = type;
	}
	
	//Setters
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	//Getters
	public Long getTypeId() {
		return typeId;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", type=" + type + ", kysymykset=" + kysymykset + "]";
	}	
	
}
