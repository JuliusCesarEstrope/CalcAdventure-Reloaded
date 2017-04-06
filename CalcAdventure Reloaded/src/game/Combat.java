package game;

import scenarios.GameOver;
import Entities.Entity;
import Entities.Entity.Alignment;

public class Combat {
	
	private static Entity[] deadEntities = {};

	public static void battle(Entity[] entityList) {

		Utilities.waitForEnter();

		boolean inBattle = true;

		sortEntities(entityList);
		performBattlecries(entityList);

		// Loop continues while enemies exist
		while (inBattle) {
			displayHP(entityList);
			performAttacks(entityList);
			inBattle = battleOver(entityList);
			entityList = cleanupEntities(entityList);
		}

		Utilities.waitForEnter();
		
	}

	private static void performBattlecries(Entity[] entityList) {
		for (Entity entity : entityList)
			Utilities.display(entity.toString() + ": " + entity.getBattlecry());
	}

	private static void performAttacks(Entity[] entityList) {
		for (int i = 0; i < entityList.length; i++) {
			// TODO: Automatic combat AI
			if (entityList[i] == WorldVariables.player)
				WorldVariables.player.performAction(entityList);
			else if (entityList[i].getCUR_HP() > 0)
				characterAttack(entityList[i], entityList);
		}
	}

	private static boolean battleOver(Entity[] entityList){
		boolean enemyAlive = false;
		for (int i = 0; i < entityList.length; i++) {
			// TODO: Automatic combat AI
			if(entityList[i] == WorldVariables.player && entityList[i].getCUR_HP() <= 0){
				GameOver endGame = new GameOver();
				endGame.loadScenario();
			}
			if(entityList[i].getAlignment() == Alignment.Enemy && entityList[i].getCUR_HP() > 0)
				enemyAlive = true;
			else if (entityList[i].getCUR_HP() <= 0)
				deadEntities = Utilities.concatAll(deadEntities, new Entity[]{entityList[i]});
		}
		return enemyAlive;
	}
	
	private static Entity[] cleanupEntities(Entity[] entityList){
		while(deadEntities.length > 0){
			Utilities.display(deadEntities[0].toString() + " is dead.");
			entityList = Utilities.removeEntity(deadEntities[0], entityList);
			if(Utilities.isInArray(deadEntities[0], WorldVariables.player.getParty()) != -1)
					WorldVariables.player.removePartyMember(deadEntities[0]);
			deadEntities = Utilities.removeEntity(deadEntities[0], deadEntities);
		}
		return entityList;
	}

	// Sorts entities in entityList in descending order byAGI.
	private static void sortEntities(Entity[] entityList) {
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			Entity temp;

			for (int i = 1; i < entityList.length - 1; i++) {
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

	public static void characterAttack(Entity character,
			Entity[] potentialTargets) {
		Entity target = WorldVariables.player;
		for (Entity entity : potentialTargets) {
			if (!character.getAlignment().equals(entity.getAlignment())
					&& entity.getCUR_HP() > 0)
				target = entity;
		}
		if (!character.getAlignment().equals(target.getAlignment()))
				character.performAttack(target);
		else
			Utilities.display(character.toString() + " has no targets.");
	}

}
