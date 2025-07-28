package com.frigga.policy.service;

import java.util.List;
import java.util.Optional;

import com.frigga.policy.model.User;

public interface UserService {
	 Optional<User> findByEmail(String email);
	    User save(User user);
	    boolean existsByEmail(String email);
	    
	    List<User> getAllUsers();
}

