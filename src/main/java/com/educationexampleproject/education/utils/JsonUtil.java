package com.educationexampleproject.education.utils;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonUtil {
	public static ObjectMapper objectMapper = new ObjectMapper();

	public static <T> T readValue(String jsonStr, Class<T> valueType) {
		try {
			return objectMapper.readValue(jsonStr, valueType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 把JavaBean转换为json字符串
	 * 
	 * @param object
	 * @return
	 */
	public static String toJSon(Object object) {
		try {
			objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>()  
	        {  
	            @Override  
	            public void serialize(  
	                    Object value,  
	                    JsonGenerator jg,  
	                    SerializerProvider sp) throws IOException, JsonProcessingException  
	            {  
	                jg.writeString("");  
	            }  
	        });  
			return objectMapper.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> parseMap(String jsonStr) { 
		try{
			return objectMapper.readValue(jsonStr, Map.class);  
		}catch(Exception e){
			e.printStackTrace();
		}
        return null;  
    }  
}
