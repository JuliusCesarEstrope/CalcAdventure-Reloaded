package scenarios;

import game.Utilities;
import game.WorldVariables;

public abstract class Scenario {
	
	private String scenarioName;
	private Scenario[] connected;
	private String[] keyWords;
	
	public Scenario(String scenarioName, Scenario[] connected, String[] keyWords){
		this.scenarioName = scenarioName;
		this.connected = connected;
		this.keyWords = keyWords;
	}
	
	public abstract void loadScenario();
	
	public String toString(){
		return scenarioName;
	}
	
	public void showDestinations(){
		Utilities.showElements(connected);
	}
	
	public void chooseDestination(Scenario[] connectedScenes){
		String choice;
		String[] destinationNames;
		destinationNames = Utilities.toStringArray(connectedScenes);
		choice = Utilities.getValidInput(destinationNames, "You can't go there.");
		moveTo(connected[Utilities.isInArray(choice, destinationNames)]);
	}
	
	public String[] getKeywords(){
		return keyWords;
	}

	public void moveTo(Scenario scene){
		WorldVariables.setDestination(scene);
	}

}
