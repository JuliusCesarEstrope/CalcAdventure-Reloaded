package scenarios;

import game.Combat;
import game.Utilities;
import game.WorldVariables;
import Entities.Entity;
import Entities.Young_Wolf;

public class Beginning extends Scenario {

	public Beginning() {
		scenarioName = "Beginning";
		connected = new Scenario[]{new PotionHut(), new IcerunedPlains(), new Argandual()};
	}
	
	public void loadScenario(){
		Utilities.display(	"You wake up in a wide, open field.",
							"In the immediate area, all you see are yellow flowers and shrubs.",
							"With no recollection of who you are, you create an identity for yourself.",
							"What is your name?");
		WorldVariables.player.setName(Utilities.getInput());
		
		Utilities.display(	"*thud*",
							"...",
							"*thud*",
							"You hear soft padded footsteps approaching you.",
							"Looking at where they are coming from, you see two Young Wolves approaching.");
		
		Combat.battle(Utilities.concatAll(WorldVariables.player.getParty(), 
				new Entity[] {WorldVariables.player, new Young_Wolf(), new Young_Wolf()}));
		
		Utilities.display(	"You decide to get your bearings about you, and wander off into the forest.",
							"It is not long until you reach the edge of the woods.",
							"You come across a crossroads. Here, you see a sign.",
							"The sign reads; ",
							"North is the Iceruned Plains",
							"East is the town of Argandual",
							"West is the Forest of the Ancient Challenger",
							/*"What would you like to do?"*/
							"Where would you like to go?");
		//TODO: Allow player to do other things before leaving
		chooseDestination(connected);
	}
	
}