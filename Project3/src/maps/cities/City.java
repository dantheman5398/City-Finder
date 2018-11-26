package maps.cities;

public class City {

	
	private int poupulation;
	private String name;
	private String region;
	private String country;
	private double latitude;
	private double longitude;
	
	public City(int pop, String name, String reg, String count, double latitude, double longitude) {
		this.poupulation=pop;
		this.name=name;
		this.region=reg;
		this.country=count;
		this.latitude=latitude;
		this.longitude=longitude;
	}

	public int getPoupulation() {
		return poupulation;
	}

	public void setPoupulation(int poupulation) {
		this.poupulation = poupulation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String toString() {
		return this.poupulation+" - "+this.name+", "+this.region+", "+this.country;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
