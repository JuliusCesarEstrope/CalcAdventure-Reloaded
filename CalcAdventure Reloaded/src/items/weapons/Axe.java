package items.weapons;


public class Axe extends Weapon{
	
	public static String name = "Axe";
	
	public static int[] diceRolls = new int[] {10};
	public static DamageType[] damageType = new DamageType[] {DamageType.Slashing};
	public static Enchantment enchant = Enchantment.None;
	public static int weight = 10;
	public static String description = "A heavy, sharp crescent of metal affixed to the end of a wooden handle.";
	
	public Axe(){
		super(name, diceRolls, damageType, enchant, weight, description);
	}

}
