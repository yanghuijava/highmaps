package com.xyb.highmaps.integration.dao;

import java.util.List;
import java.util.Map;

import com.xyb.highmaps.biz.model.Area;

public interface AreaDao {
	
	public List<Area> queryAll(Map<String, Object> params);
	
	public Area queryById(Integer id);
	
	public Area queryByIdcard(Integer idcard);
	
	public List<Area> queryChildrenByDrillKey(String drillKey);

}
