package maps;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import maps.cities.Cities;
import maps.tiles.TileUtils;



public class Main {

	public static void main(String[] args) {
		Cities city = new Cities("cities.csv");
		MapGUI gui = new MapGUI(city);
		
		JFrame frame = new JFrame("");
		frame.setSize(500, 140);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().add(gui.getSearchPanel(), BorderLayout.NORTH);
        frame.getContentPane().add(gui.getMapPanel(), BorderLayout.CENTER);
        frame.pack();
        
        Cities test = new Cities("cities.csv");
        System.out.println(test.getDefaultCity().toString());
        System.out.println(test.searchByName("albany"));
        System.out.println(TileUtils.getTile(test.getDefaultCity()).getTileURL());
        
	}

}
