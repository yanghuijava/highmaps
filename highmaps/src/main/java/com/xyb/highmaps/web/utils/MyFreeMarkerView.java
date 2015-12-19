package com.xyb.highmaps.web.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

public class MyFreeMarkerView extends FreeMarkerView{
	
	private static final String CONTEXT_RANDOM_VALUE = "rand";
	private static final String CONTEXT_BASE_PATH = "base";

	/*@Override
	protected SimpleHash buildTemplateModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {
		SimpleHash fmModel = super.buildTemplateModel(model, request, response);
		String path = request.getContextPath();
		String basePath = null;
		if (request.getServerPort() == 80) {
			basePath = request.getScheme() + "://" + request.getServerName() + path+"/";
		}
		else {
			basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path+"/";
		}
		fmModel.put(CONTEXT_BASE_PATH, basePath);
		fmModel.put(CONTEXT_RANDOM_VALUE, (""+Math.random()).substring(2, 8));
		return fmModel;
	}*/
	
	@Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
		String path = request.getContextPath();
		String basePath = null;
		if (request.getServerPort() == 80) {
			basePath = request.getScheme() + "://" + request.getServerName() + path+"/";
		}
		else {
			basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path+"/";
		}
		model.put(CONTEXT_BASE_PATH, basePath);
		model.put(CONTEXT_RANDOM_VALUE, (""+Math.random()).substring(2, 8));
        super.exposeHelpers(model, request);
    }
}
