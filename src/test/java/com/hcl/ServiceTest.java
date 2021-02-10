package com.hcl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.Rollback;

import com.hcl.model.UserEntity;
import com.hcl.services.UserService;
import com.hcl.services.UserServiceImpl;

@DataJpaTest
class ServiceTest {

	static UserEntity user;

	@TestConfiguration
	static class ServiceImplTestContextConfiguration {

		@Bean
		public UserService employeeService() {
			return new UserServiceImpl();
		}
	}

	@Autowired
	UserServiceImpl service;

	@Test
	@Rollback(false)
	void save() {
		user = new UserEntity();
		user.setPwd("1234");
		user.setUserid("dummy");
		service.update(user);
		Optional<UserEntity> found = service.findById("dummy");
		assertEquals(user, found.get());

	}
	@Test
	void login() {
		assertTrue(service.login("dummy","1234"));

	}
}
