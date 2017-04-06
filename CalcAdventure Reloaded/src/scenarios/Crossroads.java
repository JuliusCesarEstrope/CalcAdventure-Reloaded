package scenarios;

import game.Utilities;

public class Crossroads extends Scenario {
	

	public Crossroads() {
		scenarioName = "Crossroads";
		connected = new Scenario[]{new PotionHut(), new IcerunedPlains(), new Argandual()};
		
	}
	
	public void loadScenario(){
		//TODO: Add chance for 
		Utilities.display(	"You arrive at the crossroads.",
							/*"What do you do?"*/
							"Where would you like to go?");
		chooseDestination(connected);
	}

}
