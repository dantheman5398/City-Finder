package maps.tiles;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

public class Tile {

	static int z = 6;
	private int xTile;
	private int yTile;
	
	public Tile(int xtile, int ytile) {
		this.xTile=xtile;
		this.yTile=ytile;		
	}
	
	public String getTileURL() {
		return "http://a.tile.openstreetmap.org/"+Tile.z+"/"+this.xTile+"/"+this.yTile+".png";
	}
	
	public ImageIcon getImageIcon() {
		ImageIcon image = new ImageIcon();
		try {
			URL url = new URL(getTileURL());
			image = new ImageIcon(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
	
	public String toString() {
		return this.xTile+", "+this.yTile;
	}

	public int getxTile() {
		return xTile;
	}

	public void setxTile(int xTile) {
		this.xTile = xTile;
	}

	public int getyTile() {
		return yTile;
	}

	public void setyTile(int yTile) {
		this.yTile = yTile;
	}
	
	
}
