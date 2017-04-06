package items.weapons;

import items.Weapon;

public class Bite extends Weapon{
	
	public static String name = "Bite";
	
	public static int[] diceRolls = new int[] {4};
	public static DamageType[] damageType = new DamageType[] {DamageType.Piercing};
	public static Enchantment enchant = Enchantment.None;
	public static int weight = 0;
	public static String description = "An attack that pierces the skin, ripping flesh with teeth.";
	
	public Bite(){
		super(name, diceRolls, damageType, enchant, weight, description);
	}

}
