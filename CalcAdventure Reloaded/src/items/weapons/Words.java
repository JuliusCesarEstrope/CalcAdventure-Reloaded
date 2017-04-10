package items.weapons;


public class Words extends Weapon{
	
	public static String name = "Words";
	
	public static int[] diceRolls = new int[] {6, 4};
	public static DamageType[] damageType = new DamageType[] {DamageType.Mental};
	public static Enchantment enchant = Enchantment.None;
	public static int weight = 0;
	public static String description = "\"Swords of steel may make foes heel, but words make me want to kill myself.\"";
	
	public Words(){
		super(name, diceRolls, damageType, enchant, weight, description);
	}

}
