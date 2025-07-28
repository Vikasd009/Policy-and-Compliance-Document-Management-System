package com.frigga.policy.service;

import java.util.Optional;

import com.frigga.policy.model.Role;

public interface RoleService {
	Optional<Role> findByName(String name);
    Role save(Role role);
}
