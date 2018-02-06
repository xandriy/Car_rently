package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_details")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = "user")
public class UserDetails extends BaseEntity{


	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "year_of_birth")
	private int yearOfBirth;
	
	@Column(name = "license_number")
	private String licenseNumber;
	
	@Column(name = "passport_number")
	private String passportNumber;
	
	@Column(name = "email")
	private String email;
	
	@OneToOne(mappedBy = "userDetails", cascade = CascadeType.ALL)
	private User user;

	public UserDetails(String firstName, String lastName, int yearOfBirth, String licenseNumber, String passportNumber,
			String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearOfBirth = yearOfBirth;
		this.licenseNumber = licenseNumber;
		this.passportNumber = passportNumber;
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDetails [firstName=" + firstName + ", lastName=" + lastName + ", yearOfBirth="
				+ yearOfBirth + ", licenseNumber=" + licenseNumber + ", passportNumber=" + passportNumber + ", email="
				+ email + "]";
	}
	
	
	
	
}
