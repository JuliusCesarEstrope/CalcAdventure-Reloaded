package items.weapons;

import items.Weapon;

public class Strong_Fist extends Weapon{
	
	public static String name = "Strong Fist";
	
	public static int[] diceRolls = new int[] {6};
	public static DamageType[] damageType = new DamageType[] {DamageType.Bludgeoning};
	public static Enchantment enchant = Enchantment.None;
	public static int weight = 0;
	public static String description = "After hitting a rock for a while, the calluses really build up.";
	
	public Strong_Fist(){
		super(name, diceRolls, damageType, enchant, weight, description);
	}

}
