package com.vendor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vendor.bean.VendorBean;
import com.vendor.service.VendorService;



@RestController
public class VendorController {

	private static final Logger logger = LoggerFactory.getLogger(VendorController.class);
	
	@Autowired
	VendorService vendorService;
	// Your Code Here
	
	@GetMapping("/")
	public String index() {
		return "Welcome to Spring Boot Vendor Service API!";
	}

	
	/* 
	 * Method - getVendorDetails()
	 * Fetch all the vendor details using VendorService and store it inside a List
	 * Return a ResponseEntity object passing the list of vendor details
	 * 
	 */
	
	@GetMapping("/vendor/controller/getVendors")
	public ResponseEntity<List<VendorBean>> getVendorDetails() {
		List<VendorBean> vendorBeanList= vendorService.getVendorDetails();
		if(vendorBeanList!=null) {
			
			return new ResponseEntity<List<VendorBean>>(vendorBeanList,HttpStatus.OK);
		}
		else
			return new ResponseEntity<List<VendorBean>>(HttpStatus.NOT_FOUND);
			
	}
	
	@GetMapping("/vendor/controller/getVendors/{vendorId}")
	public ResponseEntity<VendorBean> getVendorDetailsById(@PathVariable String vendorId) {
		VendorBean vendorBean= vendorService.getVendorById(vendorId);
		if(vendorBean!=null) {
			
			return new ResponseEntity<VendorBean>(vendorBean ,HttpStatus.OK);
		}
		else
			return new ResponseEntity<VendorBean>(HttpStatus.NOT_FOUND);
			
	}
	
	
	@GetMapping("/vendor/controller/getVendorsByName/{vendorName}")
	public ResponseEntity<VendorBean> getVendorByName(@PathVariable String vendorName) {
		VendorBean vendorBean= vendorService.getVendorByName(vendorName);
		if(vendorBean!=null) {
			
			return new ResponseEntity<VendorBean>(vendorBean ,HttpStatus.OK);
		}
		else
			return new ResponseEntity<VendorBean>(HttpStatus.NOT_FOUND);
			
	}
}
