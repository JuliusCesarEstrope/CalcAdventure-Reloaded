package game;

import Entities.Player;

public class WorldVariables {
	
	public static Player player;
	public static String[] visited = {};
	
	public WorldVariables(){
		player = new Player();
	}

}
