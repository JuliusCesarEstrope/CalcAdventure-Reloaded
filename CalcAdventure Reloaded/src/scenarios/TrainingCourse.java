package scenarios;

import game.Utilities;

public class TrainingCourse extends Scenario {
	
	private static String scenarioName = "Iceruned Plains";
	private static Scenario[] connected = {};
	private static String[] keyWords = {};

	public TrainingCourse() {
		super(scenarioName, connected, keyWords);
	}

	public void loadScenario() {
		Utilities.display(
			"",
			"",
			"",
			"");
		moveTo(new Crossroads());
	}

}
