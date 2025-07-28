package com.frigga.policy.controller;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
	@Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginRequest(@Email @NotBlank String email, @NotBlank String password) {
		super();
		this.email = email;
		this.password = password;
	}
    
    public LoginRequest() {
    	
    }

}
