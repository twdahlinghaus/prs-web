package com.prs.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prs.business.Vendor;
import com.prs.db.VendorRepo;

@CrossOrigin
@RestController
@RequestMapping("/api/vendors")

public class VendorController {

	@Autowired
	private VendorRepo vendorRepo;
		
	@GetMapping("/")
	public List<Vendor> getAll() {
		return vendorRepo.findAll();
	}
		
	@GetMapping("/{id}")
	public Vendor getById(@PathVariable int id) {
		return vendorRepo.findById(id).get();
			
	}
	@PostMapping("/") 
	public Vendor create(@RequestBody Vendor vendor) {
		return vendorRepo.save(vendor);
		
	}
		
	@PutMapping("/") 
	public Vendor update(@RequestBody Vendor vendor) {
		return vendorRepo.save(vendor);
			
	}
			
	@DeleteMapping("/{id}") 
	public Vendor delete(@PathVariable int id) {
		Optional<Vendor> vendor = vendorRepo.findById(id);
		if (vendor.isPresent()) {
			vendorRepo.delete(vendor.get());
		}
		else {
			System.out.println("Delete Error - vendor not found for id: "+id);
		}
		return vendor.get();
	}
}
