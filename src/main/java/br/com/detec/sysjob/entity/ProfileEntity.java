package br.com.detec.sysjob.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "profile")
public class ProfileEntity {

	public ProfileEntity() {

	}
	
	public ProfileEntity(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	@NotNull
	@Size(min = 1, max = 100, message="Min 1 caracters Max 100 caracters")
	private String name;

	@OneToMany
	@JoinColumn(name = "id")
	private List<UserEntity> users;
	
	

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

}
