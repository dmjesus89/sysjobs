/**
 * 
 */
package br.com.detec.sysjob.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author diegomauricio
 *
 */
@ApiModel(description = "Toda descricacao sobre o usuario")
@Entity(name = "user")
public class UserEntity implements UserDetails {

	public UserEntity() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;

	@NotEmpty
	@Size(min = 1, max = 100, message = "Min 1 caracters Max 100 caracters")
	@Column(length = 100, nullable = false)
	private String name;

	@NotEmpty
	@Size(min = 1, max = 50, message = "Min 1 caracters Max 50 caracters")
	@Column(length = 50, nullable = false)
	private String userName;

	@ApiModelProperty(notes = "deve conter apenas um caracter")
	@NotEmpty
	@Size(min = 1, max = 1, message = "Only 1 caracters")
	private String genre;

	@ApiModelProperty(notes = "Data born need is old")
	@Past(message = "Data Born need is old")
	private LocalDate dtBorn;

	@NotEmpty
	@Size(min = 1, max = 100, message = "Min 1 caracters Max 100 caracters")
	private String phone;

	@NotEmpty
	@Email(message = "Need is mail valid")
	@Size(min = 1, max = 100, message = "Min 1 caracters Max 50 caracters")
	@Column(nullable = false, updatable = false)
	private String mail;

	@NotEmpty
	@ApiModelProperty(notes = "Caracteres alfa numerico pelo menos 1 letra maiuscula e um numero")
	@Size(min = 1, max = 100, message = "Caracteres alfa numerico pelo menos 1 letra maiuscula e um numero")
	@Column(nullable = false)
	private String password;

	@ApiModelProperty(notes = "Data de cadastro preenchida automaticamente")
	private LocalDate dtInsert;

	@OneToOne
	private ProfileEntity profile;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private List<AddressEntity> adresses;

	@OneToMany
	@JoinColumn(name = "id")
	private List<OrderEntity> orders;

	@OneToOne
	private UserStatusEntity userStatus;

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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@JsonIgnore
	public LocalDate getDtBorn() {
		return dtBorn;
	}

	public void setDtBorn(LocalDate dtBorn) {
		this.dtBorn = dtBorn;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<AddressEntity> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<AddressEntity> adresses) {
		this.adresses = adresses;
	}

	public ProfileEntity getProfile() {
		return profile;
	}

	public void setProfile(ProfileEntity profile) {
		this.profile = profile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDtInsert() {
		return dtInsert;
	}

	public void setDtInsert(LocalDate dtInsert) {
		this.dtInsert = dtInsert;
	}

	public List<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}

	public UserStatusEntity getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatusEntity userStatus) {
		this.userStatus = userStatus;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
