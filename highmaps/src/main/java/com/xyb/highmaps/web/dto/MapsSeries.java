package com.xyb.highmaps.web.dto;

import java.util.List;
import java.util.Map;

public class MapsSeries {
	
	private List<Map<String, Object>> data;
	
	private String joinBy;
	
	private String name;

	public List<Map<String, Object>> getData() {
		return data;
	}

	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}

	public String getJoinBy() {
		return joinBy;
	}

	public void setJoinBy(String joinBy) {
		this.joinBy = joinBy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
