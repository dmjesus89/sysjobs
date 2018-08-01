package br.com.detec.sysjob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.detec.sysjob.dao.h2.ProductRepository;
import br.com.detec.sysjob.entity.ProductEntity;

@Service
public class ProductService {

	private ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public ProductEntity getUser(@PathVariable Long id) {
		return productRepository.getOne(id);
	}

	public List<ProductEntity> getAllProducts() {
		List<ProductEntity> products = productRepository.findAll();
		return products;
	}

}
