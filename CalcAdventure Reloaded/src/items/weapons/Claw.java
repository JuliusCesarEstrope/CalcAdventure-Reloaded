package items.weapons;


public class Claw extends Weapon{
	
	public static String name = "Claw";
	
	public static int[] diceRolls = new int[] {4};
	public static DamageType[] damageType = new DamageType[] {DamageType.Slashing};
	public static Enchantment enchant = Enchantment.None;
	public static int weight = 0;
	public static String description = "The claw of a beast.";
	
	public Claw(){
		super(name, diceRolls, damageType, enchant, weight, description);
	}

}
