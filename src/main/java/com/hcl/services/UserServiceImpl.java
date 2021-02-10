package com.hcl.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.model.UserEntity;
import com.hcl.repo.UserEntityCrudRepository;


@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private  UserEntityCrudRepository userEntityCrudRepository;

	@Override
	public UserEntity update(UserEntity user) {
		return userEntityCrudRepository.save(user);
		
	}

	@Override
	public Optional<UserEntity> findById(String userid) {
		return userEntityCrudRepository.findById(userid);
		
	}

	@Override
	public boolean login(String userid, String pwd) {
		
		
		if(findById(userid).get().getPwd().equals(pwd)) {
			return true;
		}
		return false;
	}

}
