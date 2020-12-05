package clinic;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity

@Data
@Builder
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@AllArgsConstructor
public class Account implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	int id;
	

	String userName;

	String passWord;
	
	Long sodu;
	
	String type;

	public Account(int id, String userName, String passWord, Long sodu, String type) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.sodu = sodu;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Long getSodu() {
		return sodu;
	}

	public void setSodu(Long sodu) {
		this.sodu = sodu;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
