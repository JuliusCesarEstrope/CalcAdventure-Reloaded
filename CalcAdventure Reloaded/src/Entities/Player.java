package Entities;

import game.Combat;
import game.Utilities;
import game.WorldVariables;
import items.Weapon;
import items.weapons.Fist;

public class Player extends Entity{
	
	public String playerName = "";
	
	private static Entity[] party = new Entity[] {};
	private static Weapon[] carriedWeapons = new Weapon[] {new Fist(), new Fist()};
	private static String[] actionList = {"Equip", "Unequip", "Run", "Charm"};
	private static String[] attackWords = {"Attack", "Kill", "Stab", "Slash", "Punch", "Hit", "Fire"};
	private static String[] passiveWords = {"None", "No Action", "Peace", "Stand", "Sit", "Lay", "Wiggle", "Flip"};
	private static String[] killWords = {"Suicide", "Seppuku", "Sudoku", "Kill Myself", "Kill Me", "End Game"};
	
	public Player(){
		super();
		createCharacter();
		actionList = Utilities.concatAll(actionList, attackWords, passiveWords, killWords);
	}
	
	public void createCharacter(){
		MAX_HP = 15 + Utilities.roll(4) + Utilities.roll(4);
		CUR_HP = MAX_HP;
		STR = highestThree();
		AGI = highestThree();
		DEX = highestThree();
		ITL = highestThree();
		CHA = highestThree();
	}
	
	public int highestThree(){
		int sum = 0, lowestIndex = 7;
		int[] rolls = new int[4];
		
		for(int i = 0; i < rolls.length; i++){
			rolls[i] = Utilities.roll(6);
			sum += rolls[i];
			if (rolls[i] < lowestIndex)
				lowestIndex = rolls[i];
		}
		
		sum -= lowestIndex;
		
		return sum;
	}
	
	public void performAction(Entity[] entityList){
		String action = Utilities.getValidInput(actionList, new String[]{
				"Invalid Action.",
				"Try something else.",
				"Oak's words echoed... There is a time and place for everything, but not now.",
				"You can't do that"});
		//Player performs an attack
		if(Utilities.isInArray(action, attackWords) != -1){
			Combat.characterAttack(WorldVariables.player, entityList);
			//TODO: Allow player to chose their target
			/*Entity target = WorldVariables.player;
			for(Entity character: entityList){
				
			}*/
		}
		//Player does essentially nothing
		else if(Utilities.isInArray(action, passiveWords) != -1)
			Utilities.display("You " + action.toLowerCase() + ".");
		//Player decides to stop playing
		else if(Utilities.isInArray(action, killWords) != -1){
			CUR_HP = 0;
		}
	}
	
	//The method below is now unnecessary, though is able to
	//Present a different distribution of "invalid input" messages
/*	
	private String getValidAction(){
		boolean validAction = false;
		String input = "Something went wrong in getValidAction()";
		while(!validAction){
			input = Utilities.getInput();
			for(String action: actionList){
				if(input.toLowerCase().contains(action.toLowerCase())){
					validAction = true;
					break;
				}
			}
			if(!validAction){
				switch(Utilities.roll(10)){
					case 1:
						Utilities.display("Invalid Action.");
						break;
					case 2:
						Utilities.display("Try something else.");
						break;
					case 3:
						Utilities.display("Oak's words echoed... There is a time and place for everything, but not now.");
						break;
					default:
						Utilities.display("You can't do that");
						break;
				}
			}
		}
		
		return input;
		
	}*/
	
	public static void addPartyMember(Entity[] members){
		Utilities.concatAll(party, members);
	}
	
	public static void showCarriedWeapons(){
		Utilities.showElements(carriedWeapons);
	}

}
