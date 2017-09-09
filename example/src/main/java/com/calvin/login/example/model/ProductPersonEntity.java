package com.calvin.login.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_PERSON")
public class ProductPersonEntity {

	@SequenceGenerator(name = "product_person_generator", sequenceName = "product_person_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_person_generator")
    @Id
    private long id;
    
    @Column(name = "product_id")
    private long productId;

    @Column(name = "person_id", insertable = false, updatable = false)
    private String personId;

	public long getId() {
		return id;
	}

	public long getProductId() {
		return productId;
	}

	public String getPersonId() {
		return personId;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

}
