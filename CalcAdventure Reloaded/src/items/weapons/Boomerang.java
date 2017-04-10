package items.weapons;


public class Boomerang extends Weapon{
	
	public static String name = "Boomerang";
	
	public static int[] diceRolls = new int[] {4, 4};
	public static DamageType[] damageType = new DamageType[] {DamageType.Bludgeoning, DamageType.Ranged};
	public static Enchantment enchant = Enchantment.None;
	public static int weight = 3;
	public static String description = "\"Boomerang! You do always come back!\"";
	
	public Boomerang(){
		super(name, diceRolls, damageType, enchant, weight, description);
	}

}
