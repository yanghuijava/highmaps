package com.xyb.highmaps.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyb.highmaps.biz.service.MapsDataService;
import com.xyb.highmaps.web.dto.Maps;
import com.xyb.highmaps.web.dto.MapsSeries;
import com.xyb.highmaps.web.utils.QueryMap;

@Controller
@RequestMapping("/highmaps")
public class HighmapsController {
	
	@Resource
	private MapsDataService mapsDataService;
	
	@RequestMapping("/testData1.json")
	@ResponseBody
	public Maps testData1(QueryMap map){
		Maps maps = new Maps();
		maps.setTitle("种子用户分布图");
		maps.setSubtitle("中国");
		
		MapsSeries ms = new MapsSeries();
		ms.setName("种子用户数");
		if(map.getMap().get("drillKey") == null) {
			ms.setJoinBy("drill-key");
		}else {
			ms.setJoinBy("name");
		}
		maps.setSeries(ms);
		ms.setData(this.mapsDataService.getData1(map.getMap()));
		return maps;
	}
}
