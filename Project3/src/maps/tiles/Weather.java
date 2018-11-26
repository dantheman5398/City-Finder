package maps.tiles;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.client.fluent.Request;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

public class Weather {

	static String secretKey = "6fc9c6f7a9243401aa2a7a6ee8bee62d";
	private double lat;
	private double lon;
	private String weatherURL;
	private String jsonObject;
	private double temperature;
	private String summary;
	private double precipProbability;
	
	public Weather(double lat, double lon) {
		this.lat=lat;
		this.lon=lon;
		getURL();
		getJSONObject();
		parseJSON();
	}
	
	public void getURL() {
		this.weatherURL = "https://api.darksky.net/forecast/"+secretKey+"/"+this.lat+","+this.lon+"?exclude=minutely,hourly,daily,alerts,flags";
	}
	
	public void getJSONObject() {
		
		try{
	        this.setJsonObject(Request.Get(this.weatherURL).execute().returnContent().asString());
	    }catch(IOException ex){
	        ex.printStackTrace();
	    }
		
	}

	public String getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(String jsonObject) {
		this.jsonObject = jsonObject;
	}
	
	public void parseJSON() {
		 JsonValue jsonValue = Json.parse(jsonObject);
		 JsonObject jsonObject = jsonValue.asObject();
		 
		 JsonObject jsonObject1 = jsonObject.get("currently").asObject();
		 this.setTemperature(jsonObject1.get("temperature").asDouble());
		 this.setSummary(jsonObject1.get("summary").asString());
		 this.setPrecipProbability(jsonObject1.get("precipProbability").asDouble());
		 
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public double getPrecipProbability() {
		return precipProbability;
	}

	public void setPrecipProbability(double precipProbability) {
		this.precipProbability = precipProbability;
	}
}
