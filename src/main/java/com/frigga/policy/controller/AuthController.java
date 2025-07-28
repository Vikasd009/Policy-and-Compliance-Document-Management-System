package com.frigga.policy.controller;

import com.frigga.policy.config.JwtUtil;
import com.frigga.policy.model.Role;
import com.frigga.policy.model.User;
import com.frigga.policy.service.RoleService;
import com.frigga.policy.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
	private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterRequest request) {
        if (userService.existsByEmail(request.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already in use.");
        }

        Role defaultRole = roleService.findByName("EMPLOYEE")
            .orElseGet(() -> roleService.save(Role.builder().name("EMPLOYEE").build()));

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .active(true)
                .roles(Set.of(defaultRole))
                .build();

        userService.save(user);

        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody @Valid LoginRequest request) {
        Authentication auth = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String token = jwtUtil.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(Map.of("token", token));
    }

	public AuthController(AuthenticationManager authenticationManager, UserService userService, RoleService roleService,
			PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
		super();
		this.authenticationManager = authenticationManager;
		this.userService = userService;
		this.roleService = roleService;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
	}    
    
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
	    return ResponseEntity.ok(userService.getAllUsers());
	}

    
}
