package com.microservices.service;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.Produces;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservices.domain.ProductDetail;
import com.microservices.domain.VendorDetail;
import com.microservices.repository.ProductDetailRepository;
import com.microservices.repository.VendorDetailRepository;

@Service
public class ProductDetailsService {
	private ProductDetailRepository productDetailsRepo;
	private VendorDetailRepository vendorDetailsRepository;

	@Autowired
	public ProductDetailsService(ProductDetailRepository productDetailsRepo,VendorDetailRepository vendorDetailsRepository) {
		super();
		this.productDetailsRepo = productDetailsRepo;
		this.vendorDetailsRepository = vendorDetailsRepository;
	}
	
	@Produces("application/json")
	public ResponseEntity<ProductDetail> addProduct(String productName,String productType,String description,BigDecimal price, String vendorCode)  {
		VendorDetail vendorDetails =vendorDetailsRepository.findOne(vendorCode);
		if(vendorDetails == null) {
			return new ResponseEntity<ProductDetail>(HttpStatus.NOT_FOUND);
		}
		try {
			ProductDetail output=productDetailsRepo.save(new ProductDetail(productName, productType, description, price, vendorDetails)); 
        	return new ResponseEntity<ProductDetail>(HttpStatus.OK);
        } catch (ServiceException e){
        	System.out.println("Service exception==>" +e);
        } catch (Exception ex){
        	System.out.println("exception==>" +ex);
        }
	 return new ResponseEntity<ProductDetail>(HttpStatus.BAD_REQUEST);
	}
	
	@Produces("application/json")
	public List<ProductDetail> retrieveProduct(String productType){
		List<ProductDetail> productDetailsList = productDetailsRepo.findByproductType(productType);
		return productDetailsList;	
	}
	
	@Produces("application/json")
	public ResponseEntity<ProductDetail> removeProduct(Long productId) {
		//JSONObject json = new JSONObject(); 
		try {
			productDetailsRepo.delete(productId);	
			return new ResponseEntity<ProductDetail>(HttpStatus.OK);
        } catch (Exception e){
        	System.out.println("exception==>" +e);
        }
		return null;
	}


	public long total() {
		return productDetailsRepo.count();
	}
}
