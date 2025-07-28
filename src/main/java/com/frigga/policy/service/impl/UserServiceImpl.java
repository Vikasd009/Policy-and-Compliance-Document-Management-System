package com.frigga.policy.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.frigga.policy.model.User;
import com.frigga.policy.repository.UserRepository;
import com.frigga.policy.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@Override
	public List<User> getAllUsers() {
	    return userRepository.findAll();
	}


}
