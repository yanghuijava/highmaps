package com.xyb.highmaps.web.utils;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MyObjectMapper extends ObjectMapper{
	
	private static final long serialVersionUID = 1L;

	public MyObjectMapper(String dataFormat) {
//		configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		setDateFormat(new SimpleDateFormat(dataFormat));
	}
	
	public MyObjectMapper() {
		setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
	}

}
