package scenarios;

import game.Utilities;

public class Tavern extends Scenario {
	
	private static String scenarioName = "Iceruned Plains";
	private static Scenario[] connected = {};
	private static String[] keyWords = {};

	public Tavern() {
		super(scenarioName, connected, keyWords);
	}

	public void loadScenario() {
		Utilities.display(
			"You enter the Iceruned Plains",
			"As the name implies, there isn't much to behold",
			"All you can see is a plain of ice",
			"You decide to turn back");
		moveTo(new Crossroads());
	}

}
