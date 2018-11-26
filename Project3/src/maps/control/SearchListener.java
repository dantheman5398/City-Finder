package maps.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import maps.MapGUI;
import maps.cities.Cities;
import maps.cities.City;

public class SearchListener implements KeyListener {

	private MapGUI gui;
	private Cities cities;
	
	public SearchListener(MapGUI gui, Cities cities) {
		this.gui=gui;
		this.cities=cities;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		gui.clearSearchResults();
		ArrayList<City> city = cities.searchByName(gui.getSearchBar().getText());
		for(City ci: city) {
			gui.getSearchResults().addItem(ci);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
