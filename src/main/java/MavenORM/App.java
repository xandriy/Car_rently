package MavenORM;


import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Car;
import entity.CarType;
import entity.Fuel;
import entity.History;
import entity.Role;
import entity.Trasmission;
import entity.User;
import entity.UserDetails;


public class App 
{
    public static void main( String[] args )
    {
    
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
    	EntityManager em = factory.createEntityManager();
    	em.getTransaction().begin();
    	
    	UserDetails JonhDetails = new UserDetails();
    	JonhDetails.setFirstName("Jonh");
    	JonhDetails.setLastName("Doe");
    	JonhDetails.setYearOfBirth(1993);
    	JonhDetails.setLicenseNumber("fdsfdafwe233r3");
    	JonhDetails.setPassportNumber("sdfs24r32ff32");
    	JonhDetails.setEmail("jonh_932@email.com");
    	
    	User Jonh = new User();
    	Jonh.setLogin("jonh1");
    	Jonh.setPassword("123");
    	Jonh.setRole(Role.ROLE_CLIENT);
    	Jonh.setUserDetails(JonhDetails);
    
    	em.persist(Jonh);
    
    	User Bill_client = new User();
    	Bill_client.setLogin("billy");
    	Bill_client.setPassword("12345");
    	Bill_client.setRole(Role.ROLE_CLIENT);
    	   	
    	em.persist(Bill_client);
    	
    	UserDetails Bill_details = new UserDetails();
    	Bill_details.setFirstName("Bill");
    	Bill_details.setLastName("Garret");
    	Bill_details.setYearOfBirth(1995);
    	Bill_details.setEmail("billEmail@email.com");
    	Bill_details.setLicenseNumber("sdfsgs3r321egs");
    	Bill_details.setPassportNumber("fdsfsgweg3223r");
    	
    	User bill = em.find(User.class, new Long(1));
    	
    	bill.setUserDetails(Bill_details);
    	em.merge(bill);
    	
    	Car toureg = new Car(CarType.SUV, "Volkswagen", "Toureg", 2012, Fuel.DIESEL, 249, 
    			Trasmission.AUTOMATIC, 5, 95, 580, 2700, false, false);
    	
    	em.persist(toureg);
 
    	em.getTransaction().commit();
    	em.close();
    	factory.close();
    	
    }
}
