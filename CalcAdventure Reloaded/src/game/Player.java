package game;

import game.Entities.Alignment;
import Items.Weapons;
import Items.Weapons.DamageType;
import Items.Weapons.Enchantment;

public class Player {
	
	public static String playerName = "";
	
	public static int MAX_HP = 20, CUR_HP = 1, STR = 0, AGI = 0, DEX = 0, ITL = 0, CHA = 0;
	public static Alignment align = Alignment.Neutral;
	public static DamageType[] damageTypeWeaknesses;
	public static Enchantment[] enchantWeaknesses;
	public static String battlecry = "";
	
	private static Entities[] party = new Entities[] {Entities.Chosen_One};
	private static Weapons weapon1 = Weapons.Fist, weapon2 = Weapons.Fist;
	private static String[] actionList = {"Equip", "Unequip", "Attack", "Run"};
	private static String[] passiveWords = {"None", "No Action", "Peace", "Stand", "Sit", "Lay"};
	private static String[] killWords = {"Suicide", "Seppuku", "Sudoku", "Kill Myself", "Kill Me"};
	
	
	Player(){
		MAX_HP = 15 + Utilities.roll(4) + Utilities.roll(4);
		CUR_HP = MAX_HP;
		actionList = Utilities.concatAll(actionList, passiveWords, killWords);
		
	}
	
	public static void performAction(){
		String action = getValidAction();
		
	}
	
	private static String getValidAction(){
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
		
	}
	
	public static void performAttack(){
		
	}
	
	public static void addPartyMember(Entities[] members){
		Utilities.concatAll(party, members);
	}

}
