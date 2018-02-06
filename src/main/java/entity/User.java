package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"userDetails", "history"})
public class User extends BaseEntity{
	
	@Column(name = "login")
	private String login;
	
	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", role=" + role + ", history=" + history
				+ ", getId()=" + getId() + "]";
	}

	@Column(name = "password")
	private String password;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_details_id", nullable = true)
	private UserDetails userDetails;
	
	@OneToOne(mappedBy = "user", cascade = {CascadeType.DETACH, 
			CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			fetch = FetchType.LAZY)
	private History history;

	public User(String login, String password, Role role) {
		this.login = login;
		this.password = password;
		this.role = role;
	}

}
