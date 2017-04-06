package items.weapons;

import items.Weapon;

public class Wand extends Weapon{

public static String name = "Wand";
	
	public static int[] diceRolls = new int[] {4};
	public static DamageType[] damageType = new DamageType[] {DamageType.Magic};
	public static Enchantment enchant = Enchantment.None;
	public static int weight = 1;
	public static String description = "A wand used to channel the user's mental thoughts into energy.";
	
	public Wand(){
		super(name, diceRolls, damageType, enchant, weight, description);
	}

}
