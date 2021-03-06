package com.example.demo;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.lin.feng.sheng.EurekaServerApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EurekaServerApplication.class)
@WebAppConfiguration
public class DemoApplicationTests {
	public Logger logger= Logger.getLogger(this.getClass());

	public RestTemplate template = new RestTemplate();


	 @Autowired
	 Environment env;


	 private String url ="http://slf.test.center:9009/springSession";



	 @Test
   public void test3(){

		 for (int i = 1; i < 2; i++) {

	        String url =this.url+ "/index/";

	        String name  ="Tome-"+i;
	        url=url+name;

	        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
	        for (int j = 0; j < 5; j++) {
	        	map.add("p"+j+i, "Lily"+(i*j));

			}
	        String result = template.postForObject(url, map, String.class);
	        logger.info("result="+result);
		 }
    }

}
