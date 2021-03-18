package com.prs.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prs.business.Request;
import com.prs.db.RequestRepo;

@CrossOrigin
@RestController
@RequestMapping("/api/requests")


public class RequestController {


	@Autowired
	private RequestRepo requestRepo;
	
	@GetMapping("/")
	public List<Request> getAll() {
		return requestRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Request getById(@PathVariable int id) {
		return requestRepo.findById(id).get();
	}
		
//	@GetMapping("/list-review/{id}")
//	public List<Request> getByRequestAndUserIdNot(@PathVariable int id) {
//		return requestRepo.findByRequestAndUserIdNot(id);
//	}
	
	@GetMapping("/list-review/{id}")
	public List<Request> getReview(@PathVariable int id){
		//call custom method that gets all requests in review status and userID != currentID
		//make an array from request repo to iterate over
		List<Request> requestList = requestRepo.findAll();
		List<Request> reviewable = new ArrayList<>();
		for (Request request: requestList) {
			if (request.getStatus().equalsIgnoreCase("Review") && request.getUser().getId() != id) {
				//add item to requestList
				reviewable.add(request);
			}
		}
		return reviewable;
	}
	
	@PostMapping("/") 
	public Request create(@RequestBody Request request) {
		request.setStatus("New");
		request.setSubmittedDate(LocalDateTime.now());
		return requestRepo.save(request);
	}
		
	@PutMapping("/") 
	public Request update(@RequestBody Request request) {
		return requestRepo.save(request);
	}
	
	
	@PutMapping ("/submit-review")
	public Request reviewUpdate(@RequestBody Request request) {
		request.setStatus("Review");
		request.setSubmittedDate(LocalDateTime.now());
		if (request.getTotal() <=  50) {
		request.setStatus("Approved");
		requestRepo.save(request);
		}
		return request;
	}
		
	@PutMapping("/approve") 
	public Request approveUpdate(@RequestBody Request request) {
		request.setStatus("Approved");
		requestRepo.save(request);
		return request;
	}
	
	@PutMapping("/reject") 
	public Request rejectUpdate(@RequestBody Request request) {
		request.setStatus("Rejected");
		requestRepo.save(request);
		return request;
	}

	@DeleteMapping("/{id}") 
	public Request delete(@PathVariable int id) {
		Optional<Request> request = requestRepo.findById(id);
		if (request.isPresent()) {
			requestRepo.delete(request.get());
		}
		else {
			System.out.println("Delete Error - request not found for id: "+id);
		}
		return request.get();
		
	}
	
}
