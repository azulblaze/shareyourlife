package com.zhela.android.core.net;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class DateTypeAdapter implements JsonSerializer<Date>,
		JsonDeserializer<Date> {
	//2010-11-10T13:49:51+08:00
	private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

	public JsonElement serialize(Date src, Type typeOfSrc,
			JsonSerializationContext context) {
		String dateFormatAsString = format.format(src);
		return new JsonPrimitive(dateFormatAsString);
	}

	public Date deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		if (!(json instanceof JsonPrimitive)) {
			throw new JsonParseException("The date should be a string value");
		}
		try {
			String input = json.getAsString();
			if ( input.endsWith( "Z" ) ) {
	            input = input.substring( 0, input.length() - 1) + "GMT-00:00";
	        } else {
	            int inset = 6;
	        
	            String s0 = input.substring( 0, input.length() - inset );
	            String s1 = input.substring( input.length() - inset, input.length() );

	            input = s0 + "GMT" + s1;
	        }
			return format.parse(input);
		} catch (ParseException e) {
			throw new JsonParseException(e);
		}
	}
}
