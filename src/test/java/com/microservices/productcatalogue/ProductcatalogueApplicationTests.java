package com.microservices.productcatalogue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.microservices.domain.ProductDetail;
import com.microservices.domain.VendorDetail;
import com.microservices.service.ProductDetailsService;
import com.microservices.test.RestURIConstants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductcatalogueApplicationTests {
	
	@Autowired
	public ProductDetailsService productService;
	private ProductDetail product;
	
	public static final String SERVER_URI = "http://localhost:8080/";

	@Test
	public void contextLoads() {
	}
	
	@BeforeClass  
    public static void setUpBeforeClass() throws Exception {  
       // System.out.println("before class");  
    }  
	
    @Before  
    public void setUp() throws Exception {  
        product = new ProductDetail("TestDummy","Test1","Test3",new BigDecimal(48120),new VendorDetail("10001", "DUMMYTraders", "a1-123, main street, Kolkata"));
    }  

    @Test
	public void testProductById() {
		RestTemplate restTemplate = new RestTemplate();
		ProductDetail product = restTemplate.getForObject(SERVER_URI+RestURIConstants.GET_PRODUCT_BYID+"1", ProductDetail.class);
		System.out.println(product);
		assertEquals("OnePlus5", product.getProductName());
	}
    
    @Test
    public void testGetProductByType() {
    	List<ProductDetail> products=productService.retrieveProduct("Clothing");
    	assertThat("Size",products.size()>0);
	}
    

}
