package com.vendor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vendor.entity.VendorEntity;



public interface VendorDAO extends JpaRepository<VendorEntity, String> {


	@Query("Select v from VendorEntity v where v.vendorName=:x1")
	VendorEntity getVendorDetailsByName(@Param("x1") String name);
}
