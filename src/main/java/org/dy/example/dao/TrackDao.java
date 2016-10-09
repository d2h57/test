package org.dy.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.alibaba.fastjson.JSONObject;

@Mapper
public interface TrackDao {
	List<String> getAllTrack();
	void updateTrackDistince(JSONObject params);
	List<JSONObject> getTrackPoint(String trackId);
}
