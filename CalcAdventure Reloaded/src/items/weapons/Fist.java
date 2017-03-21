package items.weapons;

import items.Weapon;

public class Fist extends Weapon{
	
	public static String name = "Fist";
	
	public static int[] diceRolls = new int[] {4};
	public static DamageType[] damageType = new DamageType[] {DamageType.Bludgeoning};
	public static Enchantment enchant = Enchantment.None;
	public static int weight = 0;
	public static String description = "A mass of fingers tightly squeezed together.";
	
	public Fist(){
		super(name, diceRolls, damageType, enchant, weight, description);
	}

}
