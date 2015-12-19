package com.xyb.highmaps.web.dto;

import java.util.HashMap;
import java.util.Map;

public class MapDto {
	
    private Map<String, Object> map = new HashMap<String, Object>();
	
	public void put(String key, Object value) {
		map.put(key, value);
	}
	
	public Map<String, Object> getMap() {
		return map;
	}

}
