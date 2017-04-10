package scenarios;

import game.Utilities;
import game.WorldVariables;

public class Inn extends Scenario {
	
	private static String scenarioName = "Iceruned Plains";
	private static Scenario[] connected = {};
	private static String[] keyWords = {};

	public Inn() {
		super(scenarioName, connected, keyWords);
	}

	public void loadScenario() {
		
		Utilities.display(
			"You walk into the tavern and stay the night.",
			"...");
		if(WorldVariables.player.getCHA() < 10)
			Utilities.display("*snore*");
		if(WorldVariables.player.getCHA() < 6)
			Utilities.pauseForEffect(1500);
			Utilities.display("*SNOOOORLAAAX*");
		Utilities.display("You have been fully healed.");
		WorldVariables.player.healFully();
		if(Utilities.roll(10) > 7){
			encounterDoctor();
		} else {
			Utilities.display("You leave the tavern, and head back to the town square.");
			moveTo(new Argandual());
		}
		
	}
	
	private void encounterDoctor(){
		boolean playerSaysYes = false;
		Utilities.display(
				"You leave the tavern, and as you head through the doorway, a small, blue, building-like structure peaks your interest.",
				"Do you inspect it?");
			playerSaysYes = Utilities.playerYN();
			if(playerSaysYes){
				Utilities.display(
					"You approch the odd blue box.",
					"Out pops a peculiar man, dressed in a peculiar manner, with an object around his neck, and an interesting red hat.",
					"\"Ello there! 576 AD, a new hero is born.\"",
					"You respond,",
					"\"Ah... Greetings, good gentleman. If I may ask without being insulting, why are you dressed in such an odd fashion?\"",
					"He says,",
					"\"Why, I am not insulted at all! I get that all the time. Though, I am quite surprised that you haven't asked about the box yet.\"",
					"\"You know, if you want to look inside, you can.\"",
					"Do you?");
				playerSaysYes = Utilities.playerYN();
				if(playerSaysYes){
					Utilities.display(
						"Your curiosity overwhelms your proper judgement.",
						"\"This thing is just so peculiar. I must inspect it.\"",
						"As you walk in, you are amazed.",
						"\"What... What IS this?\"",
						"\"I have never seen anything of such complex caliber or design! And in such a small space to.\"",
						"\"Is this some sort of sorcery?\"",
						"The man says,",
						"\"Well that's one I haven't heard before.\"",
						"You ask,",
						"\"What does it do?\"",
						"In reply, the man says,",
						"\"Let me show you.\"");
					Utilities.waitForEnter();
					Utilities.display(
						"He plays around with the controls at the center panel.",
						"Then, you hear an odd noise, reminding you of a horse braying in the middle of a large battle.",
						"When the noise stops, the man says,",
						"\"Look outside\"");
					moveTo(new AngelWeep());
				} else {
					Utilities.display("You decline the offer and leave, heading back to the town square.");
					moveTo(new Argandual());
				}
			} else {
				Utilities.display("You head for the town square, wondering what it was.");
				moveTo(new Argandual());
			}
	}

}
