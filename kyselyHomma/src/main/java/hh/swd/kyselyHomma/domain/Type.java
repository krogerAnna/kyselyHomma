package hh.swd.kyselyHomma.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Type {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long typeId;
	private String type;
	
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
}
