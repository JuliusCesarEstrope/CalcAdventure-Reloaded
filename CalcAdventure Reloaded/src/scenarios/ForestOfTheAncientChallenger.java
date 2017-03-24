package scenarios;

import game.Utilities;

public class ForestOfTheAncientChallenger extends Scenario {

	public ForestOfTheAncientChallenger() {
		// TODO Auto-generated constructor stub
	}
	
	public static void loadScenario(){
		Utilities.display(	"After your encounter with the strange man,",
							"You get to the forest entrance",
							"Outside, you find another sign",
							"It heeds a warning",
							"\"Ahead is the Forest of the Ancient Challenger\"",
							"\"Enter at your own risk\"",
							"Against your better judgement, you decide to go in");//Perhaps let player decide?
	}

}
