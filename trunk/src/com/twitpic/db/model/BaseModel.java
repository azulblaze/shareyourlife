package com.twitpic.db.model;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;


public abstract class BaseModel {
	
	/**
	 * @param field  make sure the field'Accessible is true!
	 * @return the field's value
	 */
    public Object getFieldValue(Field field){
    	try {
			Object obj = field.get(this);
			if( obj == null )
				obj = "";
			return obj;
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
    
    }
    
    /**
     * Convert object to json object
     * @return JSONObject
     * @throws JSONException
     */
    public JSONObject to_json()throws JSONException{
    	JSONObject jo = new JSONObject();
    	Field[] fields = this.getClass().getDeclaredFields();
    	//to make the field's value can be get
    	AccessibleObject.setAccessible(fields, true);
		for(Field field:fields){
			jo.put(field.getName(), this.getFieldValue(field));
		}
		AccessibleObject.setAccessible(fields, false);
		return jo;
    }
    
    public String toString(){
    	try {
			return to_json().toString();
		} catch (JSONException e) {
			
		}
		return super.toString();
    }
}
