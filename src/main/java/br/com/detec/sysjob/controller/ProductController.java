package br.com.detec.sysjob.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.detec.sysjob.dao.h2.AddressDAO;
import br.com.detec.sysjob.entity.AddressEntity;

@RestController
@RequestMapping("/products")
//@CrossOrigin("${origin-allow}")
public class ProductController {

	@Autowired
	private AddressDAO addressDAO;

	@GetMapping("/{id}")
	public AddressEntity getAddress(@PathVariable Long id) {
		AddressEntity address = addressDAO.getOne(id);
		return address;
	}

	@GetMapping
	public List<AddressEntity> getAllAdresses() {
		List<AddressEntity> adresses = addressDAO.findAll();
		return adresses;
	}

	@PostMapping
	public AddressEntity save(@RequestBody @Valid AddressEntity address) {
		address = addressDAO.save(address);
		return address;
	}

	@PutMapping
	public AddressEntity update(AddressEntity address) {
		address = addressDAO.save(address);
		return address;
	}

	@DeleteMapping
	public void delete(@PathVariable Long id) {
		addressDAO.deleteById(id);
		// return address;
	}

}
