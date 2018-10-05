package com.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.domain.VendorDetail;
import com.microservices.repository.VendorDetailRepository;

@Service
public class VendorService {
	@Autowired
	private VendorDetailRepository vendorDetailsRepo;

	public VendorService(VendorDetailRepository vendorDetailsRepo) {
		super();
		this.vendorDetailsRepo = vendorDetailsRepo;
	}
	
	public String addVendorDetails(String code,String vendorName,String address) {
		//JSONObject json = new JSONObject();
		try {
			vendorDetailsRepo.save(new VendorDetail(code, vendorName, address));	
			return "SUCCESSFUL";
        } catch (Exception e){
        	System.out.println("exception==>" +e);
        }	
		return null;
	}

	 public long total() {
	        return vendorDetailsRepo.count();
	    }

}
