package com.microservices.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_PRODUCTDETAILS")
public class ProductDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	protected Long id;
	
	@Column(name = "name")
	protected String productName;
	
	@Column(name = "type")
	private String productType;
	
	@Column(name = "description")
	protected String description;
	
	@Column(name = "price")
	protected BigDecimal price;
	
	@ManyToOne
	protected VendorDetail vendor;

	public ProductDetail(String productName, String productType,
			String description, BigDecimal price, VendorDetail vendor) {
		super();
		this.productName = productName;
		this.productType = productType;
		this.description = description;
		this.price = price;
		this.vendor = vendor;
	}
	
	protected ProductDetail() {
    }

	public Long getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public VendorDetail getVendor() {
		return vendor;
	}

	public void setVendor(VendorDetail vendor) {
		this.vendor = vendor;
	}
	
	@Override
    public String toString() {
		String output ="{" +
                "productName:" + productName +
                ", description:" + description + 
                ", productType:" + productType +
                ", price:" + price +
                ", vendor:" + vendor +
                "}";
        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDetail product = (ProductDetail) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(description, product.description) &&
                Objects.equals(price, product.price) &&
                Objects.equals(productType, product.productType) &&
                Objects.equals(vendor, product.vendor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, description, price, productType, vendor);
    }
	
	

}
