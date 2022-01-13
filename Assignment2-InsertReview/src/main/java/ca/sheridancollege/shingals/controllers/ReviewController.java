package ca.sheridancollege.shingals.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import ca.sheridancollege.shingals.beans.Review;
import ca.sheridancollege.shingals.database.DatabaseAccess;

@Controller
public class ReviewController {
	
	@Autowired
	private DatabaseAccess da;
	
	@GetMapping("/")
	public String show(Model model) {
		model.addAttribute("reviews", da.getAllReviews());
		return "show";
	}
	
	
	@GetMapping("/insert")
	public String insert(Model model) {
		model.addAttribute("review", new Review());
		return "insertReview";
	}
	

}
