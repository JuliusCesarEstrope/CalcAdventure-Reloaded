package items.weapons;

import items.Weapon;

public class None extends Weapon{
	
	public static String name = "Claw";
	
	public static int[] diceRolls = new int[] {4};
	public static DamageType[] damageType = new DamageType[] {DamageType.None};
	public static Enchantment enchant = Enchantment.None;
	public static int weight = 0;
	public static String description = "Not a weapon.";
	
	public None(){
		super(name, diceRolls, damageType, enchant, weight, description);
	}

}
