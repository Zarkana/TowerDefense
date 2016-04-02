package data;

public enum TileType {
	Grass("grass64", true), Dirt("dirt64", false), Water("water64", false);
	
		String textureName;
		boolean buildable;
	
		/**
		 * Constructs the TileType 
		 * @param textureName The name of the TileType
		 * @param buildable Whether or not the tile can be built on
		 */
		TileType(String textureName, boolean buildable){
			this.textureName = textureName;
			this.buildable = buildable;
		}
}
