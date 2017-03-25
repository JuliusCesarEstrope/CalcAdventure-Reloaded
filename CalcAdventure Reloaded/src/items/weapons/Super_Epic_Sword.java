package items.weapons;

import items.Weapon;

public class Super_Epic_Sword extends Weapon {
	
	public static String name = "Super Epic Sword";
	
	public static int[] diceRolls = new int[] {6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6};
	public static DamageType[] damageType = new DamageType[] {DamageType.Slashing, DamageType.Piercing};
	public static Enchantment enchant = Enchantment.None;
	public static int weight = 0;
	public static String description = "A legendary weapon wielded only by GMs.";
	
	public Super_Epic_Sword(){
		super(name, diceRolls, damageType, enchant, weight, description);
	}

}
