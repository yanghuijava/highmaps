package com.xyb.highmaps.web.dto;


public class Maps {
	
	private String title;
	
	private String subtitle;
	
	private MapsSeries series;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public MapsSeries getSeries() {
		return series;
	}

	public void setSeries(MapsSeries series) {
		this.series = series;
	}
}
