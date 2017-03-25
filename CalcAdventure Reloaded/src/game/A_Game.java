package game;

import scenarios.Beginning;
import Entities.Player;

public class A_Game {
	
	public static WorldVariables world;
	
	public static void main(String[] args){
		new WorldVariables();
		new Beginning();
	}

}
