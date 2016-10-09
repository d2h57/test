package org.dy.example.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public interface TrackService {
	List<String> processTrack();
	void updateTrackDistince(JSONObject params);
	List<JSONObject> getTrackEvent(String trackId);
}
