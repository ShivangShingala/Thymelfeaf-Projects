package ca.sheridancollege.shingals.beans;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Discussion implements Serializable{
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String datee;
	private String thread;
	
}
