package ca.sheridancollege.shingals.beans;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRegistration {
	
	private String username;
	private String password;
	private String authority="employee";
}
