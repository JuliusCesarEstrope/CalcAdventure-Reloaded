package scenarios;

import game.Utilities;

public abstract class Scenario {
	
	public String scenarioName;
	public Scenario[] connected;
	public String[] destinationNames;
	public String[] keyWords;
	
	public abstract void loadScenario();
	
	public String toString(){
		return scenarioName;
	}
	
	public void showDestinations(){
		Utilities.showElements(connected);
	}
	
	public void chooseDestination(Scenario[] connectedScenes){
		String choice;
		destinationNames = Utilities.toStringArray(connectedScenes);
		choice = Utilities.getValidInput(destinationNames, "You can't go there.");
		moveTo(connected[Utilities.isInArray(choice, destinationNames)]);
	}
	
	public String[] getKeywords(){
		return keyWords;
	}

	public void moveTo(Scenario scene){
		scene.loadScenario();
	}

}
