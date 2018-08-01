package br.com.detec.sysjob.entity;


import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ProductRattingEntityPK implements Serializable {

	public ProductRattingEntityPK() {
		super();
	}

	@ManyToOne
	private ProductEntity product;

	private Long customerId;
	// @OneToMany
	// private CustomerEntity customer;

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

}
