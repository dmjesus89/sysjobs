package br.com.detec.sysjob.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.detec.sysjob.dao.h2.ProfileDAO;
import br.com.detec.sysjob.entity.ProfileEntity;
import br.com.detec.sysjob.exception.ProfileNotFoundEntityException;

@RestController
@RequestMapping("/profiles")
//@CrossOrigin("${origin-allow}")
public class ProfileController {

	@Autowired
	private ProfileDAO profileDAO;

	@GetMapping("/{id}")
	public ProfileEntity getProfile(@PathVariable Long id) {
		ProfileEntity profile = profileDAO.getOne(id);
		if(profile== null) 
			throw new ProfileNotFoundEntityException("getProfile() id= "+  id);
		
		
		
		
		return profile;
	}

	@GetMapping
	public List<ProfileEntity> getAllProfiles() {
		List<ProfileEntity> profile = profileDAO.findAll();
		return profile;
	}

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid ProfileEntity profile) {
		profileDAO.save(profile);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(profile.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ProfileEntity update(ProfileEntity profile) {
		profile = profileDAO.save(profile);
		return profile;
	}

	@DeleteMapping
	public void delete(@PathVariable Long id) {
		profileDAO.deleteById(id);
		// return profile;
	}

}
