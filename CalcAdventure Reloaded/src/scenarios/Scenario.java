package scenarios;

import game.Utilities;

public abstract class Scenario {
	
	public String scenarioName;
	public Scenario[] connected;
	public String[] destinationNames;
	public String[] keyWords;
	
	public void loadScenario(){
		//Loops until player
		//boolean inScenario = true;
		//while(inScenario){} loop of events goes here
	}
	
	public String toString(){
		return scenarioName;
	}
	
	public void showDestinations(){
		Utilities.showElements(connected);
	}
	
	public void chooseDestination(Scenario[] connectedScenes){
		int sceneIndex = -1;
		String choice;
		destinationNames = Utilities.toStringArray(connectedScenes);
		choice = Utilities.getValidInput(destinationNames, "You can't go there.");
		Utilities.isInArray(var, arr)
	}
	
	public String[] getKeywords(){
		return keyWords;
	}

	public void moveTo(Scenario scene){
		scene.loadScenario();
	}

}
