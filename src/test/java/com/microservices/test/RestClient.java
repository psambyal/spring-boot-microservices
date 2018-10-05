package com.microservices.test;

import java.math.BigDecimal;

import javax.ws.rs.core.Response;

import org.springframework.web.client.RestTemplate;

import com.microservices.domain.ProductDetail;
import com.microservices.domain.VendorDetail;
import static org.junit.Assert.assertEquals;

public class RestClient {

	public static final String SERVER_URI = "http://localhost:8080/";
	
	public static void main(String args[]){
		
		testProductById();
		System.out.println("*****");
		testAddProduct();
		System.out.println("*****");
		testGetProductByType();
		System.out.println("*****");
		
	}

	private static void testProductById() {
		RestTemplate restTemplate = new RestTemplate();
		ProductDetail product = restTemplate.getForObject(SERVER_URI+RestURIConstants.GET_PRODUCT_BYID+"1", ProductDetail.class);
		printData(product);
		assertEquals("OnePlus5", product.getProductName());
	}

	private static void testAddProduct() {
		RestTemplate restTemplate = new RestTemplate();
		ProductDetail product = new ProductDetail("TestDummy","Test1","Test3",new BigDecimal(48120),new VendorDetail("10001", "DUMMYTraders", "a1-123, main street, Kolkata"));
		ProductDetail response = restTemplate.postForObject(SERVER_URI+RestURIConstants.ADD_PRODUCT, product, ProductDetail.class);
		System.out.println(response.toString());
	}

	private static void testGetProductByType() {
		RestTemplate restTemplate = new RestTemplate();
		Object resposne = restTemplate.getForObject(SERVER_URI+RestURIConstants.GET_PRODUCT_BYTYPE+"productType=Clothing", Object.class);
		System.out.println(resposne);
	}
	
	public static void printData(ProductDetail product){
		System.out.println("Name="+product.getProductName()+",Description="+product.getDescription()
				+",ProductType="+product.getProductType()+",Price="+product.getPrice());
	}
}