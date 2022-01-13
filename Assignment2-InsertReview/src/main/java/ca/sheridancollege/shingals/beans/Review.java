package ca.sheridancollege.shingals.beans;



import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Review implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private Long id;
	private Double datee;
	private Double timee;
	private String review;
	

}
