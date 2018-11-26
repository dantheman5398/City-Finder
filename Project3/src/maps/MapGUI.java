package maps;

import java.awt.GridLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import maps.cities.Cities;
import maps.cities.City;
import maps.control.CitySelectListener;
import maps.control.SearchListener;
import maps.control.TranslateListener;
import maps.tiles.Tile;
import maps.tiles.TileUtils;
import maps.tiles.Weather;

public class MapGUI {
	
	private JTextField searchBar;
	private JComboBox<City> searchResults;
	private JButton selectedCity;
	private JPanel searchPanel;
	private JLabel label1x1;
	private JLabel label1x2;
	private JLabel label1x3;
	private JLabel label2x1;
	private JLabel label2x2;
	private JLabel label2x3;
	private JLabel label3x1;
	private JLabel label3x2;
	private JLabel label3x3;
	private JLabel label4x1;
	private JLabel label4x2;
	private JLabel label4x3;
	private ArrayList<Tile> tiles;
	
	public MapGUI(Cities city) {
		this.searchBar = new JTextField(20);
		this.searchBar.addKeyListener(new SearchListener(this, city));
		this.searchResults = new JComboBox<City>();
		this.selectedCity = new JButton("Select");
		this.selectedCity.addActionListener(new CitySelectListener(this));
		this.searchPanel = new JPanel();
		this.label1x1=new JLabel("");
		this.label1x1.addMouseListener(new TranslateListener(this, -1, -1));
		this.label1x2=new JLabel("");
		this.label1x2.addMouseListener(new TranslateListener(this, 0, -1));
		this.label1x3=new JLabel("");
		this.label1x3.addMouseListener(new TranslateListener(this, 1, -1));
		this.label2x1=new JLabel("");
		this.label2x1.addMouseListener(new TranslateListener(this, -1, 0));
		this.label2x2=new JLabel("");
		this.label2x3=new JLabel("");
		this.label2x3.addMouseListener(new TranslateListener(this, 1, 0));
		this.label3x1=new JLabel("");
		this.label3x1.addMouseListener(new TranslateListener(this, -1, 1));
		this.label3x2=new JLabel("");
		this.label3x2.addMouseListener(new TranslateListener(this, 0, 1));
		this.label3x3=new JLabel("");
		this.label3x3.addMouseListener(new TranslateListener(this, 1, 1));
		this.label4x1=new JLabel("");
		this.label4x2=new JLabel("");
		this.label4x3=new JLabel("");
		
		setReferenceTile(TileUtils.getTile(city.getDefaultCity()));
		setWeatherPanel(city.getDefaultCity());
		
	}
	
	public JPanel getSearchPanel() {
		this.searchPanel.add(this.searchBar);
		this.searchPanel.add(this.searchResults);
		this.searchPanel.add(this.selectedCity);
		
		return this.searchPanel;
		
	}
	
	
	public JPanel getMapPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 3));
		panel.add(this.label1x1);
		panel.add(this.label1x2);
		panel.add(this.label1x3);
		panel.add(this.label2x1);
		panel.add(this.label2x2);
		panel.add(this.label2x3);
		panel.add(this.label3x1);
		panel.add(this.label3x2);
		panel.add(this.label3x3);
		panel.add(this.label4x1);
		panel.add(this.label4x2);
		panel.add(this.label4x3);
		return panel;
	}
	
	public Tile returnTile() {
		return this.tiles.get(4);
	}
	
	public void setReferenceTile(Tile tile) {
		this.tiles=TileUtils.getTileMap(tile);
		
		
		 try{
			this.label1x1.setIcon(new ImageIcon(new URL(tiles.get(0).getTileURL())));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.label1x2.setIcon(new ImageIcon(new URL(tiles.get(1).getTileURL())));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.label1x3.setIcon(new ImageIcon(new URL(tiles.get(2).getTileURL())));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.label2x1.setIcon(new ImageIcon(new URL(tiles.get(3).getTileURL())));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.label2x2.setIcon(new ImageIcon(new URL(tiles.get(4).getTileURL())));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.label2x3.setIcon(new ImageIcon(new URL(tiles.get(5).getTileURL())));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.label3x1.setIcon(new ImageIcon(new URL(tiles.get(6).getTileURL())));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.label3x2.setIcon(new ImageIcon(new URL(tiles.get(7).getTileURL())));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.label3x3.setIcon(new ImageIcon(new URL(tiles.get(8).getTileURL())));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void setWeatherPanel(City city) {
		this.label4x1.setText("The temperature is "+Double.toString(new Weather(city.getLatitude(),city.getLongitude()).getTemperature())+" degrees Farenheit");
		this.label4x2.setText("			"+Double.toString(new Weather(city.getLatitude(),city.getLongitude()).getPrecipProbability())+"% chance of raining");
		this.label4x3.setText("Summary: "+(new Weather(city.getLatitude(),city.getLongitude()).getSummary()));
	}

	public JTextField getSearchBar() {
		return searchBar;
	}

	public void setSearchBar(JTextField searchBar) {
		this.searchBar = searchBar;
	}

	public JComboBox<City> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(JComboBox<City> searchResults) {
		this.searchResults = searchResults;
	}
	public void clearSearchResults() {
		this.searchResults.removeAllItems();
	}

	public JButton getSelectedCity() {
		return selectedCity;
	}

	public void setSelectedCity(JButton selectedCity) {
		this.selectedCity = selectedCity;
	}
}
