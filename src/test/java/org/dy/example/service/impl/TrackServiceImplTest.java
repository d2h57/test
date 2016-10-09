package org.dy.example.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.dy.example.service.TrackService;
import org.dy.example.util.DistinceCalculate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class TrackServiceImplTest {
	@Autowired
	private TrackService service;
	
	@Test
	public void test() {
		List<String> trackIds = service.processTrack();
		
		for(String trackId : trackIds){
			List<JSONObject> points = service.getTrackEvent(trackId);
			double distince = 0;
			JSONObject prePoint = null;
			for(JSONObject point : points){
				if(null != prePoint){
					distince += DistinceCalculate.distance(prePoint.getDoubleValue("longitude"), 
							prePoint.getDoubleValue("latitude"), point.getDoubleValue("longitude"),
							point.getDoubleValue("latitude"));
				}
				
				prePoint = point;
			}
			
			JSONObject params = new JSONObject();
			params.put("id", trackId);
			params.put("distance", distince/1000);
			service.updateTrackDistince(params);
		}
	}

}
