package com.microservices;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.ApplicationPath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.service.ProductDetailsService;
import com.microservices.service.VendorService;

@SpringBootApplication
@ApplicationPath("/api")
public class ProductcatalogueApplication implements CommandLineRunner{
	@Autowired
	private ProductDetailsService productDetailsService;
	
	@Autowired
	private VendorService vendorDetailsService;

	public static void main(String[] args) {
		SpringApplication.run(ProductcatalogueApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		//TODOD
		System.out.println("here");
		vendorDetailsService.addVendorDetails("0001", "samsungtraders", "a1-123, main street, mumbai");
		vendorDetailsService.addVendorDetails("0002", "fashion", "197, main street bangalore");
		vendorDetailsService.addVendorDetails("0003", "westernunion", "a-35, main street, pune");
		vendorDetailsService.addVendorDetails("0004", "marketleaders", "40, main street chennai");
		vendorDetailsService.addVendorDetails("0005", "oneplustraders", "39/40, main street mumbai");
		System.out.println("Number of vendors  =" + vendorDetailsService.total());
		ProductDetailsFromFile.importData().forEach(t->productDetailsService.addProduct(
				t.productName,
				t.productType, 
				t.description,
				new BigDecimal(t.price), 
				t.vendorCode));
		System.out.println("Number of products =" + productDetailsService.total());
		System.out.println(productDetailsService.retrieveProduct("Mobile"));
	}
	
	static class ProductDetailsFromFile {
		//attributes as listed in the .json file
		private String productName, productType , description,price, vendorCode ;


		static List<ProductDetailsFromFile> importData() throws IOException {
			return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).
					readValue(ProductDetailsFromFile.class.getResourceAsStream("/ProductDetails.json"),new TypeReference<List<ProductDetailsFromFile>>(){});
		}
	}

}
