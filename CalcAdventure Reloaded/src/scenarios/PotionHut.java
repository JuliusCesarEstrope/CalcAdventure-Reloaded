package scenarios;

import game.Utilities;
import game.WorldVariables;

public class PotionHut extends Scenario {
	
	private static String scenarioName = "Forest of the Ancient Challenger";
	private static Scenario[] connected = {};
	private static String[] keyWords = {};

	public PotionHut() {
		super(scenarioName, connected, keyWords);
	}

	public void loadScenario() {
		Utilities.display("Off in the distance, you can see the forest.",
				"As you prepare to enter, a strange man hails you,",
				"\"Come hither! I can show you items of magic!\"",
				"Do you trust him?");
		// TODO: Player chooses to trust, and events happen based on the choice.
		// If players trusts stranger

		potionDrink();
	}

	private void potionDrink(){
		
		boolean playerSaysYes = Utilities.playerYN();
		boolean drinkingPotions = true;
		int potionsDrunk = 0;
		
		if(playerSaysYes){
			Utilities.display(	
				"He takes you to his cottage a little ways into the woods.",
				"When you enter, the glimmer of colored bottles overwhelms you.",
				"The plethora of magical potions is intimidating.",
				"The stranger asks,",
				"Would you care to try some of the potions?");
			
			drinkingPotions = Utilities.playerYN();
			
			while(drinkingPotions){
				
				int potionChance = Utilities.roll(100);
				
				if (potionChance == 36) {
					Utilities.display(
						"You say,",
						"\"Wow... I don't feel well...\"",
						"You collapse on the floor.",
						"The stranger exclaims,",
						"\"Oh no! Not the siren's piss!\"",
						"You collapse on the floor and die.", "GAME OVER");
					new GameOver();
				} else if (potionChance <= 10) {
					Utilities.display("\"Ouch!\"", "You take 2 damage.");
				} else if (potionChance == 100) {
					Utilities.display(
						"\"WOAH\"", "\"GHRAHTYLIOOUS\"",
						"Interesting...",
						"You feel more strong and agile, ",
						"but your ability to think and express yourself are impaired.");
					WorldVariables.player.modMAX_HP(10);
					WorldVariables.player.modSTR(6);
					WorldVariables.player.modAGI(10);
					WorldVariables.player.modDEX(5);
					WorldVariables.player.modITL(-5);
					WorldVariables.player.modCHA(-10);
				} else if (potionChance > 82) {
					Utilities.display(	
						"\"I feel more buff...\"",
						"You feel more buff.");
					WorldVariables.player.modSTR(7);
				} else if (potionChance < 30) {
					Utilities.display(	
						"\"Tastes sugary...\"",
						"You feel more agile.");
					WorldVariables.player.modAGI(4);
				} else if (potionChance >= 70) {
					Utilities.display(	
						"\"What the heck is a carrot?\"",
						"Your dodging ability increases.");
					WorldVariables.player.modDEX(10);
				} else if (potionChance <= 35) {
					Utilities.display(	
						"\"Sudden urge... To invent...\"",
						"You feel more intelligent.");
					WorldVariables.player.modITL(10);
				} else if (potionChance == 69) {
					Utilities.display(	
						"\"I feel sexy!\"",
						"The scouter says your charm level is now over 9000.");
					WorldVariables.player.modCHA(9020);
				} else
					Utilities.display(
						"\"Wow. That tastes good.\"",
						"Nothing else Happens");

				Utilities.display("Want another?");
				playerSaysYes = Utilities.playerYN();
				
				if (playerSaysYes) {
					drinkingPotions = true;
					potionsDrunk++;
					if (potionsDrunk > 3) {
						Utilities.display("You feel slightly bloated...",
								"\"Too many...\"");
						WorldVariables.player.modCUR_HP(-3);
						drinkingPotions = false;
					} 
				} else {
					Utilities.display("You decline the offer and continue on your way");
					drinkingPotions = false;
				}
				
			}
		} else{
			//If player does not trust stranger
			Utilities.display(	"You decline the offer and continue on your way.");
		}
		if(Utilities.isInArray("Forest of the Ancient Challenger", WorldVariables.visited) == -1){
			Utilities.concatAll(WorldVariables.visited, new String[]{"Forest of the Ancient Challenger"});
			moveTo(new ForestOfTheAncientChallenger());
		} else {
			Utilities.display("You head back to the crossroads.");
			moveTo(new Crossroads());
		}
	}
}
