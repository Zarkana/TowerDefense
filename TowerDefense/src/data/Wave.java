package data;

import java.util.ArrayList;
import static helpers.Clock.*;


public class Wave {

	private float timeSinceLastSpawn, spawnTime;
	private Enemy enemyType;
	private ArrayList<Enemy> enemyList;
	
	public Wave(float spawnTime, Enemy enemyType){
		this.enemyType = enemyType;
		this.spawnTime = spawnTime;
		enemyList = new ArrayList<Enemy>();
	}
	
	/**
	 * Responsible for Updating and Drawing all the enemies on the screen
	 */
	public void Update() {
		timeSinceLastSpawn += Delta();
		if(timeSinceLastSpawn > spawnTime){
			Spawn();
			timeSinceLastSpawn = 0;
		}
		
		//Cycle through every enemy in the wave
		for (Enemy e: enemyList) {
			if (e.isAlive()){
				e.Update();
				e.Draw();
			}
		}
	}
	private void Spawn(){
		enemyList.add(new Enemy(enemyType.getTexture(), enemyType.getStartTile(), enemyType.getTileGrid(), 64, 64, enemyType.getSpeed()));
		
	}
	
}
