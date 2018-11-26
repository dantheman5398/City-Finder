package maps.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import maps.MapGUI;
import maps.cities.City;
import maps.tiles.TileUtils;

public class CitySelectListener implements ActionListener {

	private MapGUI map;
	
	public CitySelectListener(MapGUI map){
		this.map=map;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		map.setReferenceTile(TileUtils.getTile((City) map.getSearchResults().getSelectedItem()));
		map.setWeatherPanel((City) map.getSearchResults().getSelectedItem());
	}

}
