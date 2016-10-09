package org.dy.example.service.impl;

import java.util.List;

import org.dy.example.dao.TrackDao;
import org.dy.example.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

@Service
public class TrackServiceImpl implements TrackService{
	@Autowired
	private TrackDao dao;

	@Override
	public List<String> processTrack() {
		return dao.getAllTrack();
	}

	@Override
	public void updateTrackDistince(JSONObject params) {
		dao.updateTrackDistince(params);
	}

	@Override
	public List<JSONObject> getTrackEvent(String trackId) {
		return dao.getTrackPoint(trackId);
	}

}
