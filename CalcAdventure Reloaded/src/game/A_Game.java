package game;

import scenarios.Beginning;

public class A_Game {
	
	public static void main(String[] args){
		
		new WorldVariables();
		new Beginning().loadScenario();
		while(WorldVariables.playing){
			WorldVariables.getDestination().loadScenario();
		}
	}

}
