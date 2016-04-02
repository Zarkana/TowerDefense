package data;

import static helpers.Artist.*;

public class TileGrid {
	
	public Tile[][] map;
	
	/**
	 * Constructs a generic grass tilegrid
	 */
	public TileGrid() {
		map = new Tile[20][15];
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length; j++){
				map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Grass);
			}
		}
	}
	
	public TileGrid(int[][] newMap){
		map = new Tile[20][15];
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length; j++){
				switch(newMap[j][i]){
					case 0:
						map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Grass);
						break;
					case 1:
						map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Dirt);
						break;
					case 2:
						map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Water);
						break;
				}
			}
		}
	}
	
	/**
	 * Sets the tile at a given coordinate to a certain type
	 * @param xCoord the x coordinate of the new tile
	 * @param yCoord the y coordinate of the new tile
	 * @param type  the type of the new tile
	 */
	public void SetTile(int xCoord, int yCoord, TileType type){
		map[xCoord][yCoord] = new Tile(xCoord * 64, yCoord * 64, 64, 64, type);
	}
	
	/**
	 * Gets the tile at a given coordinate 
	 * @param xCoord the x coordinate of the tile
	 * @param yCoord the y coordinate of the tile
	 * @return the Tile
	 */
	public Tile GetTile(int xCoord, int yCoord){
		return map[xCoord][yCoord];
	}
	
	
	/**
	 * Draws the textures of the entire map onto the screen
	 */
	public void Draw() {
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length; j++){
				Tile t = map[i][j];
				DrawQuadTex(t.getTexture(), t.getX(), t.getY(), t.getWidth(), t.getHeight());
			}
		}
	}
}
