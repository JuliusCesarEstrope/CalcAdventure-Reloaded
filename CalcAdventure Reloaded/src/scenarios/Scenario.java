package scenarios;

import game.Utilities;

public abstract class Scenario {
	
	public String scenarioName;
	public Scenario[] connected;
	public String[] destinationNames;
	public String[] keyWords;
	
	public static void loadScenario(){
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
	
	public void chooseDestination(){
		
	}
	
	public String[] getKeywords(){
		return keyWords;
	}

}
