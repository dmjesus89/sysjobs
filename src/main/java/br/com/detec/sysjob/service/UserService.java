package br.com.detec.sysjob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.detec.sysjob.dao.h2.UserRepository;
import br.com.detec.sysjob.entity.UserEntity;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserEntity getUser(@PathVariable Long id) {
		return userRepository.getOne(id);
	}

	public List<UserEntity> getAllUsers() {
		List<UserEntity> users = userRepository.findAll();
		return users;
	}

	public void saveUser(UserEntity user) {
		userRepository.save(user);
	}

	public UserEntity update(UserEntity user) {
		user = userRepository.save(user);
		return user;
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}

}
