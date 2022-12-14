package vh.objectManagers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import vh.object.MapTile;
import static vh.helper.Constants.TilesClass.*;

public class MapTileManager {
	
	// Pavement to be inserted later
	//public MapTile Block, Road;
	//public MapTile Pavement;
	public BufferedImage mapAtlas;
	public ArrayList<MapTile> tiles = new ArrayList<>();
	
	public BufferedImage img = null;
	
	
	public MapTileManager() {
		
		loadAtlas();
		createTiles();
	}
	
	private void createTiles() {
		
		for (int y = 0; y <= 25; y++) {
			for (int x = 0; x <= 28; x++) {
				// ???
				int id = (y*28) + x;
				
				if (id == 28) tiles.add(new MapTile(getMap(x, y), 1));
				else if (id == 80) tiles.add(new MapTile(getMap(x, y), 2));
				else tiles.add(new MapTile(getMap(x, y), 0));
			}
		}
	}
	
	private void loadAtlas() {

		InputStream is = getClass().getResourceAsStream("/outdoors.png");
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.mapAtlas = img;
	}
	
	public BufferedImage getMap(int id) {
		return tiles.get(id).getMap();
	}
	
	private BufferedImage getMap(int X, int Y) {
		return mapAtlas.getSubimage(X * 16, Y * 16, 16, 16);
	}
	
	public MapTile getTile(int id) {
		return tiles.get(id);
	}
}