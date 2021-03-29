package com.plm;

import com.plm.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringbootWebApplicationTests {

	@Autowired
	UserServiceImpl userService;

	@Test
	void contextLoads() throws SQLException {
		System.out.println(userService.queryUserByName("admin"));
	}

}
