package com.prs.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prs.business.LineItem;
import com.prs.business.Request;
import com.prs.db.LineItemRepo;
import com.prs.db.RequestRepo;

@CrossOrigin
@RestController
@RequestMapping("/api/line-items")

public class LineItemController {

	@Autowired
	private LineItemRepo lineItemRepo;
	@Autowired
	private RequestRepo requestRepo;
		
	@GetMapping("/")
	public List<LineItem> getAll() {
		return lineItemRepo.findAll();
	}
		
	@GetMapping("/{id}")
	public LineItem getById(@PathVariable int id) {
		return lineItemRepo.findById(id).get();
			
	}
	
	@GetMapping("/lines-for-pr/{id}")
	public List<LineItem> getByRequest(@PathVariable int id) {
		return lineItemRepo.findByRequestId(id);
	}
	// add a lineItem
	@PostMapping("/")
	public LineItem addLineItem(@RequestBody LineItem li) {
		//save li
		lineItemRepo.save(li);
		//recalculate line item value
		recalculateItemValue(li);
		return li;
	}
	
	private void recalculateItemValue(LineItem li) {
		Request r = li.getRequest();
		// get all li's for this request
		List<LineItem> lis = lineItemRepo.findAllByRequestId(li.getRequest().getId());
		// declare a new total
		double newTotal = 0.0;
		// loop thru lis
		for (LineItem lineItem: lis) {
			// add (product price * qty) to newTotal
			newTotal += (lineItem.getQuantity() * lineItem.getProduct().getPrice());
		}
		// set newTotal in request
		r.setTotal(newTotal);
		
		// save request
		requestRepo.save(r);
	}

	@PutMapping("/") 
	public LineItem update(@RequestBody LineItem lineItem) {
		lineItemRepo.save(lineItem);
		recalculateItemValue(lineItem);
		return lineItem;
	}
			
	@DeleteMapping("/{id}") 
	public LineItem delete(@PathVariable int id) {
		Optional<LineItem> lineItem = lineItemRepo.findById(id);
		if (lineItem.isPresent()) {
			lineItemRepo.delete(lineItem.get());
			recalculateItemValue(lineItem.get());
		}
		else {
			System.out.println("Delete Error - line item not found for id: "+id);
		}
		return lineItem.get();
			
		}
	
}
