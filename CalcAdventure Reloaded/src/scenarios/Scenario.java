package scenarios;

import game.Utilities;

public abstract class Scenario {
	
	public Scenario[] connected;
	public String[] destinationNames;
	public String[] keyWords;
	
	public void loadScenario(){
		//Loops until player
		boolean inScenario = true;
		//while(inScenario){} loop of events goes here
	}
	
	public void showDestinations(){
		Utilities.showElements(connected);
	}
	
	public void chooseDestination(){
		//TODO: Player types in destination name, then load new scenario
	}
	
	public String[] getKeywords(){
		return keyWords;
	}

}
