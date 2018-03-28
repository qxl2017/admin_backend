package com.qxl;

import com.alibaba.fastjson.JSON;
import com.qxl.entity.PhoneBook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class AdminBackendApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void test() throws Exception{
		String data = "[{\"name\":\"姓名1\",\"phone\":\"12345678900\"},{\"name\":\"姓名2\",\"phone\":\"12345678901\"}]".replaceAll("name", "nickname").replaceAll("phone", "mobile");
		List<PhoneBook> list = JSON.parseArray(data, PhoneBook.class);
		System.out.println(list.size());

	}
}
