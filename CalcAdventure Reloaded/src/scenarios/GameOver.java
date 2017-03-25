package scenarios;

import game.Utilities;
import game.WorldVariables;
import Entities.Player;

public class GameOver extends Scenario {
	
	public static void loadScenario(){
		Utilities.display("You died.");
		//TODO: Ask player if they would like to play again(?)
		WorldVariables.player = new Player();
		System.exit(0);
	}

}
