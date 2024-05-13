package com.java.payxpert.util;

import java.util.ResourceBundle;

public class DBPropertyUtil {
	public static String ConnectionString(String ParameterFile) {
		ResourceBundle rb=ResourceBundle.getBundle(ParameterFile);
		String connstr=rb.getString("url");
		return connstr;
	}

}
