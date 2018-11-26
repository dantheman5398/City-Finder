package maps.tiles;

import java.util.ArrayList;

import maps.cities.City;

public class TileUtils {

	
	public static Tile getTile(City city) {
		double lat = city.getLatitude();
		double lon = city.getLongitude();
		int xTile;
		int yTile;
		int n = (int) Math.pow(2, Tile.z);
		xTile=(int) (n*((lon+180)/360));
		yTile= (int) (n*(1-(Math.log(Math.tan(Math.toRadians(lat))+(1/Math.cos(Math.toRadians(lat))))/Math.PI)) / 2);
		Tile tile = new Tile(xTile, yTile);
		return tile;
	}
	
	public static ArrayList<Tile> getTileMap(Tile tile){
		int x = tile.getxTile();
		int y = tile.getyTile();
		
		ArrayList<Tile> tileMap = new ArrayList<Tile>();
		
		tileMap.add(new Tile(x-1, y-1));
		tileMap.add(new Tile(x, y-1));
		tileMap.add(new Tile(x+1, y-1));
		tileMap.add(new Tile(x-1, y));
		tileMap.add(new Tile(x, y));
		tileMap.add(new Tile(x+1, y));
		tileMap.add(new Tile(x-1, y+1));
		tileMap.add(new Tile(x, y+1));
		tileMap.add(new Tile(x+1, y+1));
		
		return tileMap;
	}
	
	public static Weather getWeather(City city) {
		Weather weather = new Weather(city.getLatitude(),city.getLongitude());
		return weather;
	}
	public static String weatherJSON(Weather weather) {
		return weather.getJsonObject();
	}
	
}
