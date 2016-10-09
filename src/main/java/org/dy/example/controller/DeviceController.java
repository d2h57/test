package org.dy.example.controller;

import org.dy.example.model.Device;
import org.dy.example.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
public class DeviceController {
	@Autowired
	private DeviceService service;
	
	@GetMapping("/device")
    public String getDevies(String id) {
		JSONObject device = service.getDevice(id);
        String result = JSONObject.toJSONString(device);
        return result;
    }
}
