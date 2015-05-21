package com.cerqueira.gson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class GsonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			
		System.out.println(fromJson());
		System.out.println(fromJsonArray());
	}

	public static List<Fruta> fromJsonArray() {
		
		ArrayList<Fruta> frutas = new ArrayList<Fruta>();
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonArray jArray = parser.parse(getJSON()).getAsJsonArray();

	    for(JsonElement obj : jArray )
	    {
	        Fruta fruta = gson.fromJson( obj , Fruta.class);
	        frutas.add(fruta);
	    }
	    
	    return frutas;
	}
	
	public static List<Fruta> fromJson() {
		Gson gson = new Gson();
		java.lang.reflect.Type collectionType = new TypeToken<List<Fruta>>() {		}.getType();
		List<Fruta> frutas = gson.fromJson(getJSON(), collectionType);
		return frutas;
	}
	
	public static String getJSON() {
		
		String json = null;
		
		try {
			json = FileUtil.readString(new File("frutas.json"));
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
		return json;
	}
	
}
