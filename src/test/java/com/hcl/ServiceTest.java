package com.hcl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.Rollback;

import com.hcl.model.UserEntity;
import com.hcl.services.UserService;
import com.hcl.services.UserServiceImpl;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
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
		user.setId(2);
		user.setPwd("12345");
		user.setUserid("dummy5");
		service.save(user);
	UserEntity found = service.findById("dummy5").get();
		assertEquals(user, found);

	}

	@Test
	void login() {
		assertTrue(service.login("dummy5", "12345"));

	}
}
