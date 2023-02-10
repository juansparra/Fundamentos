package com.fundamentosplazi.springboot.fundamentos.service;

import java.util.List;

import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.fundamentosplazi.springboot.fundamentos.entity.User;
import com.fundamentosplazi.springboot.fundamentos.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	private final org.apache.juli.logging.Log LOG = LogFactory.getLog(UserService.class);
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Transactional
	public void saveTransactional(List<User> users) {

		users.stream().peek(user -> LOG.info("Usuario insertado " + user)).forEach(userRepository::save);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User save(User newUser) {
		// TODO Auto-generated method stub
		return userRepository.save(newUser);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		userRepository.delete(new User(id));
	}

	public User update(User newUser, Long id) {
		// TODO Auto-generated method stub
		return 
		userRepository.findById(id)
		.map(
				user -> {
			user.setEmail(newUser.getEmail());
			user.setBirthDate(newUser.getBirthDate());
			user.setName(newUser.getName());
			return userRepository.save(user);
			}
		).get();
	
	}

}
