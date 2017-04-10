package scenarios;

import game.Utilities;

public class Argandual extends Scenario {
	
	private static String scenarioName = "Argandual";
	private static Scenario[] connected = {new Tavern(), new TrainingCourse(), new Inn(), new Crossroads()};
	private static String[] keyWords = {};

	public Argandual() {
		super(scenarioName, connected, keyWords);
	}

	public void loadScenario() {
		Utilities.display(
			"The city of Argandual looms ahead.",
			"You walk through the main gate.",
			"You arrive at the town square, which leads to other places in the city.",
			"Where would you like to go?");
		chooseDestination(connected);
	}

}
