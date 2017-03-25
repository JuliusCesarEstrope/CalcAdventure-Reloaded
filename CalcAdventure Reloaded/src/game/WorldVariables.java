package game;

import java.util.LinkedList;

import scenarios.Scenario;
import Entities.Player;

public class WorldVariables {
	
	public static Player player;
	public static LinkedList<Scenario> visited;
	
	public WorldVariables(){
		player = new Player();
	}

}
