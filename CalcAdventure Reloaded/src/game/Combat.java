package game;

import Entities.Entity;
import Entities.Entity.Alignment;
import Entities.Player;

public class Combat {

	private static Entity[] entityList;

	public static void battle(Entity[] entityList) {

		boolean inBattle = true;

		sortEntities(entityList);
		
		// Loop continues while enemies exist
		while (inBattle) {
			
			
			displayHP(entityList);

			for (int i = 0; i < entityList.length; i++) {
				// TODO: Automatic combat AI
				if(entityList[i].toString().equalsIgnoreCase("Chosen_One"))
					WorldVariables.player.performAction(entityList);
				else if(entityList[i].getCUR_HP() > 0)
					characterAttack(entityList[i], entityList);
			}
			
			boolean friendlyAlive = true, enemyAlive = true;
			for (int i = 0; i < entityList.length; i++) {
				// TODO: Automatic combat AI
				if(entityList[i].getName().equals(WorldVariables.player.getName()) && entityList[i].getCUR_HP() <= 0)
					friendlyAlive = false;
				if(entityList[i].getAlignment() == Alignment.Enemy && entityList[i].getCUR_HP() <= 0)
					enemyAlive = false;
				if(!friendlyAlive || !enemyAlive)
					inBattle = false;
			}
		}
	}

	// Sorts entities in entityList in descending order byAGI.
	private static void sortEntities(Entity[] entityList) {
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			Entity temp;

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
	private static void displayHP(Entity[] entityList) {

		for (int i = 0; i < entityList.length; i++) {
			Utilities.display(entityList[i].getName() + ": "
					+ entityList[i].getCUR_HP() + "HP");
		}
	}
	
	public static void characterAttack(Entity character, Entity[] potentialTargets){
		Entity target = WorldVariables.player;
		for(Entity ent: potentialTargets){
			if(!character.getAlignment().equals(ent.getAlignment()) && ent.getCUR_HP() > 0)
					target = ent;
		}
		character.performAttack(target);
	}

}
