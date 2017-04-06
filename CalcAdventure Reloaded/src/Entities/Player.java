package Entities;

import game.Combat;
import game.Utilities;
import game.WorldVariables;
import items.Weapon;
import items.weapons.Axe;
import items.weapons.Boomerang;
import items.weapons.Fist;
import items.weapons.Strong_Fist;
import items.weapons.Wand;
import items.weapons.Words;
import scenarios.GameOver;

public class Player extends Entity{
	
	public String playerName = "";
	
	private static Entity[] party = new Entity[] {};
	private static Weapon[] carriedWeapons = new Weapon[] {new Fist(), new Fist()};
	private static String[] actionList = {"Equip", "Unequip", "Run", "Charm"};
	private static String[] attackWords = {"Attack", "Strike", "Kill", "Stab", "Slash", "Punch", "Hit"/*, "Fire"*/};
	//private static String[] magicWords = {"Cast", "Abracadabra", "Magic"};
	//private static String[] healWords = {"Recover", "Heal"};
	//private static String[] throwWords = {"Toss", "Throw", "Fling", "Lob", "Chuck", "Catapult", "Loose", "Launch", "Let Fly"};
	//private static String[] lookWords = {"Look", "Examine", "Search", "Inspect"};
	private static String[] passiveWords = {/*"None", "No Action", "Peace",*/ "Stand", "Sit", "Lay Down", "Wiggle", "Flip", "Cry", "Roll"};
	//private static String[] diplomaticWords = {"Peace", "Intimidate", "Diplomacy", "Intimidation"};
	//private static String[] tameWords = {"Tame", "Feed", "Calm", "Play"};
	//private static String[] runWords = {"Run", "Escape", "Leave"};
	private static String[] killWords = {"Suicide", "Seppuku", "Sudoku", "Kill Myself", "Kill Me", "End Game"};
	
	public Player(){
		super();
		createCharacter();
		setStartingWeapon();
		actionList = Utilities.concatAll(actionList, attackWords, passiveWords, killWords);
		/*weapon1 = new Super_Epic_Sword();
		Orc friendlyOrc = new Orc();
		friendlyOrc.setAlignment(Alignment.Friendly);
		addPartyMember(friendlyOrc);*/
	}
	
	private void createCharacter(){
		MAX_HP = 15 + Utilities.roll(4) + Utilities.roll(4);
		CUR_HP = MAX_HP;
		STR = highestThree();
		AGI = highestThree();
		DEX = highestThree();
		ITL = highestThree();
		CHA = highestThree();
	}
	
	private int highestThree(){
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
	
	private void setStartingWeapon(){
		if(STR > ITL && STR > CHA){
			if(STR > DEX)
				weapon1 = new Axe();
			else if(STR == DEX)
				weapon1 = new Strong_Fist();
			else
				weapon1 = new Boomerang();
		}
		else if(ITL > CHA)
			weapon1 = new Wand();
		else
			weapon1 = new Words();
	}
	
	public void performAction(Entity[] entityList){
		Utilities.display("What action do you take?");
		String action = Utilities.getValidInput(actionList, new String[]{
				"Invalid Action.",
				"Try something else.",
				"Oak's words echoed... There is a time and place for everything, but not now.",
				"You can't do that."});
		//Player performs an attack
		if(Utilities.isInArray(action, attackWords) != -1){
			Entity target = WorldVariables.player;
			String targetName = "";
			int targetIndex = -1;
			boolean validTarget = false;
			String[] targetList = {};
			String[] temp = {};
			
			Utilities.display("Who do you " + action.toLowerCase() + "?");
			
			for(Entity character: entityList){
				temp = targetList;
				targetList = new String[temp.length + 1];
				for(int i = 0; i < temp.length; i++)
					targetList[i] = temp[i];
				targetList[temp.length] = character.toString();
			}
			
			while(!validTarget){
				targetName = Utilities.getValidInput(targetList, "That is not a valid target");
				targetIndex = Utilities.isInArray(targetName, targetList);
				if(targetIndex != -1)
					validTarget =  true;
			}
			target = entityList[targetIndex];
			Combat.characterAttack(WorldVariables.player, new Entity[] {target});
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
	
	public void modCUR_HP(){
		this.CUR_HP += CUR_HP;
		if(CUR_HP > MAX_HP)
			this.CUR_HP = MAX_HP;
		if(this.CUR_HP <1)
			new GameOver();
	}

	public Entity[] getParty(){
		return party;
	}
	
	public void addPartyMember(Entity member){
		party = Utilities.concatAll(party, new Entity[] {member});
	}
	
	public void addPartyMembers(Entity[] members){
		party = Utilities.concatAll(party, members);
	}
	
	public void removePartyMember(Entity member){
		party = Utilities.removeEntity(member, party);
	}
	
	public void showCarriedWeapons(){
		Utilities.showElements(carriedWeapons);
	}

}
