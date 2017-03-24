package scenarios;

import game.A_Game;
import game.Utilities;
import game.WorldVariables;
import Entities.Player;

public class GameOver extends Scenario {

	public GameOver() {
		// TODO Auto-generated constructor stub
	}
	
	public void loadScene(){
		Utilities.display("You died.");
		//TODO: Ask player if they would like to play again(?)
		WorldVariables.player = new Player();
		new A_Game();
	}

}
