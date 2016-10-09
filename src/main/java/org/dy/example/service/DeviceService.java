package org.dy.example.service;

import org.dy.example.model.Device;

import com.alibaba.fastjson.JSONObject;

public interface DeviceService {
	JSONObject getDevice(String id);
}
