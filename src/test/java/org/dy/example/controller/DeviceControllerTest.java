package org.dy.example.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.dy.example.model.Device;
import org.dy.example.service.DeviceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.alibaba.fastjson.JSONObject;


@RunWith(SpringRunner.class)
@WebMvcTest(DeviceController.class)
public class DeviceControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
    private DeviceService deviceService;
	
	@Test
	public void testGetDevices() throws Exception {
		JSONObject obj = new JSONObject();
		obj.put("id1", "name1");
		given(deviceService.getDevice("sboot")).willReturn(obj);
		mvc.perform(get("/device").accept(MediaType.APPLICATION_JSON_UTF8).param("id", "sboot"))
        .andExpect(status().isOk()).andExpect(content().string("{\"id\":\"id1\",\"name\":\"name1\"}"));
	}
}
