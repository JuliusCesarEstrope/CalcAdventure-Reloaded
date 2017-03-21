package scenarios;

import game.Combat;
import game.Utilities;
import game.WorldVariables;
import Entities.Entity;
import Entities.Orc;

public class Beginning extends Scenario {

	public Beginning() {
	}
	
	public void loadScenario(){
		Utilities.display(	"You wake up in a clearing in the middle of the forest.",
							"In the immediate area, all you see are yellow flowers and shrubs.",
							"With no recollection of who you are, you create an identity for yourself.",
							"What is your name?");
		WorldVariables.player.setName(Utilities.getInput());
		
		Utilities.display(	"You hear the heavy pounding of footsteps approaching you.",
							"Looking at where they are coming from, you see an Orc charging at you full-speed.");
		
		Combat.battle(new Entity[] {WorldVariables.player, new Orc()});
		
		Utilities.display(	"Having slain the Orc, you get decide to get your bearings about you, and wander off into the forest.",
							"...",
							"You begin feeling faint.",
							"...",
							"...",
							"The world around you fades to black as you lose conciousness.");
		loadScenario();
	}

}