package game;

import scenarios.Scenario;
import Entities.Player;

public class WorldVariables {

	
	public static boolean playing = true;
	public static Player player;
	public static String[] visited = {};
	private static Scenario destination;
	
	public WorldVariables(){
		player = new Player();
	}
	
	public static void setDestination(Scenario scene){
		destination = scene;
	}
	
	public static Scenario getDestination(){
		return destination;
	}

}
