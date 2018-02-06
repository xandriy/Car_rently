package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "history")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"locations", "car", "user"})
public class History extends BaseEntity{

	
	@Column(name = "date_from")
	private String dateFrom;
	
	@Column(name = "date_to")
	private String dateTo;

	@OneToOne(cascade = {CascadeType.DETACH, 
			CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = true)
	private User user;
	
	@OneToOne(cascade = {CascadeType.DETACH, 
			CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id", nullable = true)
	private Car car;
	
	@OneToMany(mappedBy = "history", cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH},
			fetch = FetchType.LAZY)
	private List<Location> locations = new ArrayList<>();  
	

	@Override
	public String toString() {
		return "History [dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", getId()=" + getId() + "]";
	}
	
	
	
	
	
	
}
