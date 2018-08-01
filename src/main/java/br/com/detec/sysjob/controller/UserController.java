package br.com.detec.sysjob.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.detec.sysjob.dao.h2.UserRepository;
import br.com.detec.sysjob.entity.UserEntity;

@RestController
@RequestMapping("/users")
//@CrossOrigin("http://localhost")
public class UserController {

	public UserController() {

	}

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/{id}")
	public UserEntity getUser(@PathVariable Long id) {
		System.out.println(userRepository.getOne(id));
		return userRepository.getOne(id);
	}

	@GetMapping
	public List<UserEntity> getAllUsers() {
		List<UserEntity> users = userRepository.findAll();
		System.out.println(users);
		System.out.println(users);
		return users;
	}

	@PostMapping
	public void saveUser(@RequestBody UserEntity user) {
		userRepository.save(user);
	}

	@PutMapping
	public UserEntity update(@RequestBody @Valid UserEntity user) {
		user = userRepository.save(user);
		return user;
	}

	@DeleteMapping
	@PreAuthorize("hasRole('Admin')")
	public void delete(@PathVariable Long id) {
		userRepository.deleteById(id);
	}

}
