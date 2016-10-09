package org.dy.example.service.impl;

import org.dy.example.model.Device;
import org.dy.example.service.DeviceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class DeviceServiceImplTest {

	@Autowired
	private DeviceService service;
	
	@Test
	public void getDevicesTest() throws Exception{
		JSONObject device = service.getDevice("351565029000053");
			
		assertEquals("name not equals",device.getString("name"),"N800_0006");
	}
}
