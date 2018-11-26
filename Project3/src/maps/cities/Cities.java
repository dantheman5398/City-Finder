package maps.cities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cities {

	private String filename;
	private ArrayList<City> cityList;
	
	public Cities(String filename) {
		
		this.filename=filename;
		this.cityList=getCityList();
		
	}
	
	public ArrayList<City> getCityList(){
		ArrayList<City> cityList = new ArrayList<City>(); 
		try {
			for(String line : Files.readAllLines(Paths.get(filename))){
			    String data[] = line.split(",");
			    cityList.add(new City(Integer.parseInt(data[3]),data[1],data[2],data[0], Double.parseDouble(data[4]), Double.parseDouble(data[5])));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cityList;
	}

	public City getDefaultCity() {
		
		int count = -1;
		int temp = 0;
		for(City ci: this.cityList) {
			count++;
			if(ci.getName().equals("buffalo")&&ci.getRegion().equals("NY")) {
				temp = count;
			}
		}
		return this.cityList.get(temp);
	}
	
	public ArrayList<City> searchByName(String search){
		ArrayList<City> searchResults = new ArrayList<City>();
		for(City ci: this.cityList) {
			if(ci.getName().contains(search)) {
				searchResults.add(ci);
			}
		}
		Collections.sort(searchResults, new Comparator<City>() {
			public int compare(City arg0, City arg1) {
				return arg1.getPoupulation()-arg0.getPoupulation();
			}
		});
		
		return searchResults;
	}
	
}
