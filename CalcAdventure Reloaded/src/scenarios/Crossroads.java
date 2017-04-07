package scenarios;

import game.Utilities;

public class Crossroads extends Scenario {
	
	private static String scenarioName = "Crossroads";
	private static Scenario[] connected = {new PotionHut(), new IcerunedPlains(), new Argandual()};
	private static String[] keyWords = {};

	public Crossroads() {
		super(scenarioName, connected, keyWords);
	}
	
	public void loadScenario(){
		//TODO: Add chance for 
		Utilities.display(	"You arrive at the crossroads.",
							/*"What do you do?"*/
							"Where would you like to go?");
		chooseDestination(connected);
	}

}
