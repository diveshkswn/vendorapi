package com.vendor.service;

import java.util.List;

import com.vendor.bean.VendorBean;



public interface VendorService {
	List<VendorBean> getVendorDetails();
	

	VendorBean getVendorById(String vendorId);
	VendorBean getVendorByName(String name);
}
