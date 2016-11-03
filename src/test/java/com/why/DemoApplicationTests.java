package com.why;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Resource
	DataSource dataSource;

//	@Resource
//	private PersonMapper personMapper;

	@Test
	public void run() throws Exception {
		System.out.println("====================================");
		System.out.println(dataSource.getConnection());
//		System.out.println(personMapper.getPersonById(1));
	}

}
