package com.example.readinglist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.allinpay.sample.spring.boot.readinglist.ReadingListApplication;

@RunWith(SpringRunner.class)
//bean容器配置
@SpringBootTest(classes=ReadingListApplication.class)
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
