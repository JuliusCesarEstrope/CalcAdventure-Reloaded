package game;

import scenarios.Beginning;
import Entities.Player;

public class A_Game {
	
	public static void main(String[] args){
		WorldVariables world = new WorldVariables();
		Beginning beginning = new Beginning();
		beginning.loadScenario();
	}

}
