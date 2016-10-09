package org.dy.example.service.impl;

import org.dy.example.dao.DeviceDao;
import org.dy.example.model.Device;
import org.dy.example.properties.CfgProperties;
import org.dy.example.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

@Service
public class DeviceServiceImpl implements DeviceService {
	@Autowired
	private DeviceDao dao;
	
	/*@Autowired
	private CfgProperties prop;*/
	
	@Value("${cfg.item}")
	private String item;
	
	@Override
	public JSONObject getDevice(String id) {
//		System.out.println("item value:"+prop.getItem());
		System.out.println("item value1111:"+item);
		return dao.getDevice(id);
	}

}
