package game;

public class Combat {

	private static Entities[] entityList;

	public static void battle(Entities[] entityList) {

		boolean inBattle = true;

		sortEntities();
		
		// Loop continues while enemies exist
		while (inBattle) {
			
			displayHP();

			for (int i = 0; i < entityList.length; i++) {
				// TODO: Automatic combat AI
				Player.performAction();
			}

		}
	}

	// Sorts entities in entityList in descending order byAGI.
	private static void sortEntities() {
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			Entities temp;

			for (int i = 0; i < entityList.length - 1; i++) {
				if (entityList[i].getAGI() < entityList[i + 1].getAGI()) {
					temp = entityList[i];
					entityList[i] = entityList[i + 1];
					entityList[i + 1] = temp;
					sorted = false;
				}
			}
		}
	}

	// Displays HP of all entities in scene
	private static void displayHP() {

		for (int i = 0; i < entityList.length; i++) {
			Utilities.display(entityList[i].name() + ": "
					+ entityList[i].getCUR_HP() + "HP");
		}
	}

}
