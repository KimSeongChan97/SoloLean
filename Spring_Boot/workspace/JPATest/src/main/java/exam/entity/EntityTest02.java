package exam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EntityTest02 {

	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id; 
    private String name; 
    private int num1; 
    private Integer num2;
    
    
}
