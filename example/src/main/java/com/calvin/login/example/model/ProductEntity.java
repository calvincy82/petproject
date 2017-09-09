package com.calvin.login.example.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created on 1/22/2016.
 */
@Entity
@Table(name="PRODUCT")
public class ProductEntity {

    @SequenceGenerator(name = "product_id_generator", sequenceName = "product_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_generator")
    @Id
    private long id;

	@Column(name = "product_code")
    private String productCode;

	@Column(name = "product_description")
    private String productDescription;

    protected ProductEntity() {
    }

    public long getId() {
		return id;
	}
    
	public void setId(long id) {
		this.id = id;
	}

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
}
