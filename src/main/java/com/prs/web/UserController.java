package com.prs.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prs.business.User;
import com.prs.db.UserRepo;

@CrossOrigin
@RestController
@RequestMapping("/api/users")

public class UserController {

	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/")
	public List<User> getAll() {
		return userRepo.findAll();
	}
	
	// list all users
	@GetMapping("/{id}")
	public User getById(@PathVariable int id) {
		return userRepo.findById(id).get();
	}
	//authenticate via GET
	@GetMapping()
	public User login(@RequestParam String username, @RequestParam String password) {
		return userRepo.findByUsernameAndPassword(username, password);
	}
	
	//authenticate via POST
	@PostMapping()
	public User login(@RequestBody User u) {
		return userRepo.findByUsernameAndPassword(u.getUsername(), u.getPassword());
	}
	
	@PostMapping("/") 
	public User create(@RequestBody User user) {
		return userRepo.save(user);
		
	}
		
	@PutMapping("/") 
	public User update(@RequestBody User user) {
		return userRepo.save(user);
		
	}
		
	@DeleteMapping("/{id}") 
	public User delete(@PathVariable int id) {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			userRepo.delete(user.get());
		}
		else {
			System.out.println("Delete Error - user not found for id: "+id);
		}
		return user.get();
		
	}
	
}
