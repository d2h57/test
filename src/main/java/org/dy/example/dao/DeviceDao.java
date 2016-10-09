package org.dy.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.dy.example.model.Device;

import com.alibaba.fastjson.JSONObject;

@Mapper
public interface DeviceDao {
	JSONObject getDevice(String id);
}
