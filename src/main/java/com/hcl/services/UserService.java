package com.hcl.services;

import java.util.Optional;

import com.hcl.model.UserEntity;


public interface UserService {
	public UserEntity save(UserEntity user);
	public Optional<UserEntity> findById(String userid);
	public boolean login(String userid, String pwd);
}
