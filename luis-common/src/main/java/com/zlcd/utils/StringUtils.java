package com.zlcd.utils;

import java.util.List;

public class StringUtils {

	public static String subString(String string, int max) {
		int sum = 0;
		if (string != null && string.length() > max) {
			StringBuilder sb = new StringBuilder(max);
			for (int i = 0; i < string.length(); i++) {
				int c = string.charAt(i);
				if ((c & 0xff00) != 0)
					sum += 2;
				else
					sum += 1;
				if (sum <= max)
					sb.append((char) c);
				else
					break;
			}
			return sb.append("...").toString();
		} else
			return string != null ? string : "";
	}

	public static String getStringToSqlParamter(List<String> array) {
		if(array==null || array.size()==0){
			return "";
		}
		String temp="";
		for (int i=array.size()-1;i>=0;i--){
			if(i>0){
				temp = temp + "'" + array.get(i) +"',";
			}else{
				temp = temp + "'" + array.get(i) +"'";
			}
		}
		return temp;
	}

}
