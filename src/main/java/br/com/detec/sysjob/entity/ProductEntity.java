package br.com.detec.sysjob.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity(name = "product")
public class ProductEntity {

	public ProductEntity() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String name;

	@OneToOne
	private ProductStatusEntity productStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductStatusEntity getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(ProductStatusEntity productStatus) {
		this.productStatus = productStatus;
	}

}
