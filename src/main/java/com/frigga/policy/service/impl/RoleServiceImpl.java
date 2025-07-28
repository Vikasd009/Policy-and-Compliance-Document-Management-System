package com.frigga.policy.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.frigga.policy.model.Role;
import com.frigga.policy.repository.RoleRepository;
import com.frigga.policy.service.RoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{
	private final RoleRepository roleRepository;

    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

	public RoleServiceImpl(RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}
}
