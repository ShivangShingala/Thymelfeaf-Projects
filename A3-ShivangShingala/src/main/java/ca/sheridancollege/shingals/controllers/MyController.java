package ca.sheridancollege.shingals.controllers;

import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.shingals.beans.Discussion;
import ca.sheridancollege.shingals.beans.EmployeeRegistration;
import ca.sheridancollege.shingals.database.DatabaseAccess;

//Use local host 8443 

@Controller
public class MyController {

	List<Discussion> db = new CopyOnWriteArrayList<Discussion>();

	@Autowired
	private DatabaseAccess da;

	@Autowired
	JdbcUserDetailsManager jdbcUserDetailsManager;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/")
	public String getIndex() {
		return "index";
	}

	@GetMapping("/register")
	public String register(Model model, EmployeeRegistration employee) {
		model.addAttribute("employee", employee);
		return "register";
	}

	@PostMapping("/register")
	public String processRegister(@ModelAttribute EmployeeRegistration employee) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		if (employee.getAuthority().equalsIgnoreCase("employee")) {
			authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
		} else if (employee.getAuthority().equalsIgnoreCase("boss")) {
			authorities.add(new SimpleGrantedAuthority("ROLE_BOSS"));
		} else {
			authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
		}

		String encodedPassword = bCryptPasswordEncoder.encode(employee.getPassword());
		User newuser = new User(employee.getUsername(), encodedPassword, authorities);
		jdbcUserDetailsManager.createUser(newuser);
		return "redirect:/";
	}

	@GetMapping("/NewDiscussion")
	public String getDiscussions(Model model) {
		model.addAttribute("discussion", new Discussion());
		return "NewDiscussion";
	}

	@PostMapping("/AddNewDiscussion")
	public String processDiscussions(@ModelAttribute Discussion discussion) {
		da.insertDiscussion(discussion);
		return "redirect:/AddNewDiscussion"; 
	}

	@GetMapping("/discussions")
	public String showDiscussions(Model model) {
		model.addAttribute("discussions", da.getAllDiscussions());
		return "discussions";
	}

	@GetMapping("/login")
	public String login() {
		return "login.html";
	}

	@GetMapping("/home")
	public String getHome() {
		return "home";
	}

	@GetMapping("/access-denied")
	public String accessDenied() {
		return "/error/access-denied.html";
	}

}
