package com.vendor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendor.bean.VendorBean;
import com.vendor.dao.VendorDAO;
import com.vendor.entity.VendorEntity;


@Service
public class VendorServiceImpl implements VendorService{

	private static final Logger logger = LoggerFactory.getLogger(VendorServiceImpl.class);
	
	/*
	 * Autowire VendorDAO object
	 * 
	 * */
	@Autowired
	VendorDAO vendorDAO;
	
	// Your Code Here

	
	/*
	 * Method - getVendorDetails()
	 * Use the VendorDAO to get all the vendors
	 * Check if vendors is not empty then 
	 * 		Declare VendorBean object with null value
	 * 		Loop through all the vendors 
	 * 			Create a new bean object 
	 * 			Copy each property value of entity object to bean object
	 * 			Add the bean object to the vendorBeans list
	 * */

	@Override
	public List<VendorBean> getVendorDetails() {
		List<VendorBean> vendorBeans = new ArrayList<VendorBean>();
		List<VendorEntity> vendorEntities= vendorDAO.findAll();
		if(vendorEntities!=null) {
			for(VendorEntity en: vendorEntities) {
			VendorBean v=new VendorBean();
			BeanUtils.copyProperties(en, v);
			vendorBeans.add(v);
		}
	}
	return vendorBeans;
	}

	@Override
	public VendorBean getVendorById(String vendorId) {
		// TODO Auto-generated method stub
		VendorBean vb=new VendorBean();
		Optional<VendorEntity> ve=vendorDAO.findById(vendorId);
		BeanUtils.copyProperties(ve.get(), vb);
		return vb;
	}

	@Override
	public VendorBean getVendorByName(String name) {
		// TODO Auto-generated method stub
		
		VendorBean vb=new VendorBean();
		VendorEntity ve=vendorDAO.getVendorDetailsByName(name);
		BeanUtils.copyProperties(ve, vb);
		return vb;
	} 
	
	
}
