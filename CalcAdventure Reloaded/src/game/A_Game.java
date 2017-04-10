package game;


public class A_Game {
	
	public static void main(String[] args) throws InterruptedException{
		while(true){
			Utilities.display(Utilities.getGameTime() + " is the time.");
			Thread.sleep(1000);
		}
		/*new WorldVariables();
		new Beginning().loadScenario();
		while(WorldVariables.playing){
			WorldVariables.getDestination().loadScenario();
		}*/
	}

}
