package com.xyb.highmaps.web.utils;

import java.util.Map;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class QueryMapArgumentResolver implements HandlerMethodArgumentResolver{
	
	//private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	//private static DateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return (parameter.getParameterType() == QueryMap.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		QueryMap ret = new QueryMap();
		Map<String, String[]> map = webRequest.getParameterMap();
		//String page = null;
		//String rows = null;
		for (String key:map.keySet()) {
			ret.put(key, map.get(key)[0]);
			/*if (key.equals("page")) {
				page = map.get(key)[0];
			}
			else if (key.equals("rows")) {
				rows = map.get(key)[0];
			}
			else if (key.equals("id")) {
				ret.put("id", Long.valueOf(map.get(key)[0]));
			}
			else if (map.get(key) != null && !"".equals(map.get(key)[0])) {
				int len = key.length();
				if (key.endsWith("_s")) {
					ret.put(key.substring(0, len-2), map.get(key)[0]);
				}
				else if (key.endsWith("_i")) {
					ret.put(key.substring(0, len-2), Integer.valueOf(map.get(key)[0]));
				}
				else if (key.endsWith("_f")) {
					ret.put(key.substring(0, len-2), Double.valueOf(map.get(key)[0]));
				}
				else if (key.endsWith("_d")) {
					ret.put(key.substring(0, len-2), dateFormat.parse(map.get(key)[0]));
				}
				else if (key.endsWith("_da")) {
					Calendar instance = Calendar.getInstance();
					instance.setTime(dateFormat.parse(map.get(key)[0]));
					instance.set(Calendar.HOUR_OF_DAY, 0);
					instance.set(Calendar.MINUTE, 0);
					instance.set(Calendar.SECOND, 0);
					instance.set(Calendar.MILLISECOND, 0);
					ret.put(key.substring(0, len-3), instance.getTime());
				}
				else if (key.endsWith("_db")) {
					Calendar instance = Calendar.getInstance();
					instance.setTime(dateFormat.parse(map.get(key)[0]));
					instance.set(Calendar.HOUR_OF_DAY, 23);
					instance.set(Calendar.MINUTE, 59);
					instance.set(Calendar.SECOND, 59);
					instance.set(Calendar.MILLISECOND, 999);
					ret.put(key.substring(0, len-3), instance.getTime());
				}
				else if (key.endsWith("_dc")) {
					Calendar instance = Calendar.getInstance();
					instance.setTime(dateFormat.parse(map.get(key)[0]));
					instance.add(Calendar.DAY_OF_YEAR, -1);
					instance.set(Calendar.HOUR_OF_DAY, 23);
					instance.set(Calendar.MINUTE, 59);
					instance.set(Calendar.SECOND, 59);
					instance.set(Calendar.MILLISECOND, 999);
					ret.put(key.substring(0, len-3), instance.getTime());
				}
				else if (key.endsWith("_dd")) {
					Calendar instance = Calendar.getInstance();
					instance.setTime(dateFormat.parse(map.get(key)[0]));
					instance.add(Calendar.DAY_OF_YEAR, 1);
					instance.set(Calendar.HOUR_OF_DAY, 0);
					instance.set(Calendar.MINUTE, 0);
					instance.set(Calendar.SECOND, 0);
					instance.set(Calendar.MILLISECOND, 0);
					ret.put(key.substring(0, len-3), instance.getTime());
				}
				else if (key.endsWith("_t")) {
					ret.put(key.substring(0, len-2), timeFormat.parse(map.get(key)[0]));
				}
				else {
					ret.put(key, map.get(key)[0]);
				}
			}*/
		}
		/*if (page != null && rows != null) {
			Long rowFrom = (Long.valueOf(page)-1L)*Long.valueOf(rows);
			Long rowTo = rowFrom + Long.valueOf(rows);
			// used for mysql, postgresql, h2
			ret.put("firstResult", rowFrom);
			ret.put("maxResults", rows);
			
			// used for oracle, db2, mssql
			ret.put("firstRow", rowFrom + 1);
			ret.put("lastRow", rowTo + 1);
			
			// used for legacy code
			ret.put("pageRow", Integer.valueOf(rows));
			ret.put("rowFrom", rowFrom);
			ret.put("rowTo", rowTo.toString());
			
		}
		else {
			// used for mysql, postgresql, h2
			ret.put("firstResult", 0);
			ret.put("maxResults", 10);

			// used for oracle, db2, mssql
			ret.put("firstRow", 1);
			ret.put("lastRow", 11);
			
			// used for legacy code
			ret.put("pageRow", 10);
			ret.put("rowFrom", 0);
			ret.put("rowTo", "10");
		}*/
		return ret;
	}

}
