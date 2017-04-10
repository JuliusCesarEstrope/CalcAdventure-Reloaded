package scenarios;

public class AngelWeep extends Scenario {
	
	private static String scenarioName = "Angel Weep";
	private static Scenario[] connected = {};
	private static String[] keyWords = {};

	public AngelWeep() {
		super(scenarioName, connected, keyWords);
	}

	public void loadScenario() {
		moveTo(new Crossroads());
	}

}
