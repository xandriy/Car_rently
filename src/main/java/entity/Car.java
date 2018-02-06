package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "car")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude= "history")
public class Car extends BaseEntity{
	


	@Column(name = "car_type")
	@Enumerated(value = EnumType.STRING)
	private CarType carType;
	
	@Column(name = "make")
	private String make;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "manufacture_year")
	private int manufactureYear;
	
	@Column(name = "fuel_type")
	@Enumerated(value = EnumType.STRING)
	private Fuel fuel_type;
	
	@Column(name = "power")
	private int power;
	
	@Column(name = "tramsmission_type")
	@Enumerated(value = EnumType.STRING)
	private Trasmission transmissionType;
	
	@Column(name = "number_of_place")
	private int numberOfPlace;

	@Column(name = "day_rental")
	private int dayRental;
	
	@Column(name = "week_rental")
	private int weekRental;
	
	@Column(name = "mounthRental")
	private int mounthRental;

	@Column(name = "is_rented")
	private boolean isRented;
	
	@Column(name = "is_booked")
	private boolean isBooked;

	@OneToOne(mappedBy = "car", cascade = {CascadeType.DETACH, 
			CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			fetch = FetchType.LAZY)
	private History history;


	public Car(CarType carType, String make, String model, int manufactureYear, Fuel fuel_type, int power,
			Trasmission transmissionType, int numberOfPlace, int dayRental, int weekRental, int mounthRental,
			boolean isRented, boolean isBooked) {
		super();
		this.carType = carType;
		this.make = make;
		this.model = model;
		this.manufactureYear = manufactureYear;
		this.fuel_type = fuel_type;
		this.power = power;
		this.transmissionType = transmissionType;
		this.numberOfPlace = numberOfPlace;
		this.dayRental = dayRental;
		this.weekRental = weekRental;
		this.mounthRental = mounthRental;
		this.isRented = isRented;
		this.isBooked = isBooked;
	}




	@Override
	public String toString() {
		return "Car [carType=" + carType + ", make=" + make + ", model=" + model + ", manufactureYear="
				+ manufactureYear + ", fuel_type=" + fuel_type + ", power=" + power + ", transmissionType="
				+ transmissionType + ", numberOfPlace=" + numberOfPlace + ", dayRental=" + dayRental + ", weekRental="
				+ weekRental + ", mounthRental=" + mounthRental + ", isRented=" + isRented + ", isBooked=" + isBooked
				+ ", getId()=" + getId() + "]";
	}


	
	
	

	
	
}
