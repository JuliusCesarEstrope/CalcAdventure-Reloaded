package scenarios;

import game.Combat;
import game.Utilities;
import game.WorldVariables;
import Entities.Entity;
import Entities.Orc;

public class Beginning extends Scenario {
	
	public String scenarioName = "Beginning";
	public Scenario[] connected;
	public String[] destinationNames;
	public String[] keyWords;

	public Beginning() {
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
							"You hear the heavy pounding of footsteps approaching you.",
							"Looking at where they are coming from, you see an Orc charging at you full-speed.");
		
		Combat.battle(new Entity[] {WorldVariables.player, new Orc()});
		
		Utilities.display(	"Having slain the Orc, you decide to get your bearings about you, and wander off into the forest.",
							"It is not long until you reach the edge of the woods.",
							"You come across a crossroads. Here, you see a sign.",
							"The sign reads; ",
							"North is the Iceruned Plains",
							"East is the town of Argandual",
							"West is the Forest of the Ancient Challenger",
							"What would you like to do?");
		//TODO: Write function to allow player to select among connected scenes.
	}
	
}