package com.twitpic.util;

import java.util.ArrayList;
import java.util.List;

public class ConvertUtil {
	
	public static List<Integer> string_array_2_integer_list(String[] ary){
		List<Integer> list = new ArrayList<Integer>();
		for (String item : ary) {
			list.add(Integer.parseInt(item));
		}
		return list;
	}

}
