package com.xyb.highmaps.biz.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyb.highmaps.biz.model.Area;
import com.xyb.highmaps.biz.service.MapsDataService;
import com.xyb.highmaps.integration.dao.AreaDao;

@Service
public class MapsDataServiceImpl implements MapsDataService {
	
	@Autowired
	private AreaDao areaDao;

	@Override
	public List<Map<String, Object>> getData1(Map<String, Object> params) {
		Random random = new Random();
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		List<Area> provinceList = null;
		if(params.get("drillKey") == null) {
			params.put("level", 0);
			provinceList = this.areaDao.queryAll(params);
			for(Area p : provinceList){
				Map<String, Object> item = new HashMap<String, Object>();
				item.put("drill-key", p.getDrillKey());
				item.put("value", random.nextInt(1000));
				item.put("drilldown", p.getDrillKey());
				result.add(item);
			}
		}else {
			provinceList = this.areaDao.queryChildrenByDrillKey(params.get("drillKey").toString());
			for(Area p : provinceList){
				Map<String, Object> item = new HashMap<String, Object>();
				item.put("name", p.getName());
				item.put("value", random.nextInt(1000));
				result.add(item);
			}
		}
		
		return result;
	}

}
