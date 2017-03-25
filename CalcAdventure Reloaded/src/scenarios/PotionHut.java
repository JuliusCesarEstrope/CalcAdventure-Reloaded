package scenarios;

import game.Utilities;

public class PotionHut extends Scenario {
	
	public void loadScene(){
		Utilities.display(	"Off in the distance, you can see the forest.",
							"As you prepare to enter, a strange man hails you,",
							"\"Come hither! I can show you items of magic!\"",
							"Do you trust him?");
		//TODO: Player chooses to trust, and events happen based on the choice.
		//If players trusts stranger
		Utilities.display(	"He takes you to his cottage a little ways into the woods.",
							"When you enter, the glimmer of colored bottles overwhelms you.",
							"The plethora of magical potions is intimidating.",
							"The stranger asks,",
							"Would you care to try some of the potions?");
		/*TODO: Player chooses a potion, gives a description of what it is, and 
		 *		decide what happens based on ITL and AGI
		 *		Random potions have different effects on the player. 
		 *		If player drinks more than three, they are sick and lose 3 HP
		 *		Check if they die, tell them they died from potion poisoning
		 */
		//If player does not trust stranger
		Utilities.display(	"You respectfully decline the offer.");
		ForestOfTheAncientChallenger.loadScenario();
	}

}
