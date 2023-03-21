package com.api.fichagincana.util;

import java.util.List;

public class AppUtil {

	public static boolean isNotNullAndNotEmpty(Object object) throws Exception {
		return object != null && !object.toString().trim().equals("") && !object.toString().trim().equals("0") && !object.toString().trim().equals("0.0") && (!(object instanceof List) || !((List)object).isEmpty());		
	}
	
}
