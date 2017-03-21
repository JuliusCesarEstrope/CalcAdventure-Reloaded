package items;


public abstract class Weapon extends Item{

	public enum DamageType{None, Bludgeoning, Piercing, Slashing, Ranged};
	public enum Enchantment{None, Fire, Lightning, Poison, Holy};
	
	private int[] dieRolls;
	private DamageType[] dmgType;
	private Enchantment enchant;
	
	public Weapon(String Name, int[] dieRolls, DamageType[] dmgType, Enchantment enchant, int weight, String description){
		super(weight, description);
		this.name = Name;
		this.dieRolls = dieRolls;
		this.dmgType = dmgType;
		this.enchant = enchant;
	}
	
	public int[] getDieRolls(){
		return dieRolls;
	}
	
	public DamageType[] getDamageType(){
		return dmgType;
	}
	
	public Enchantment getEnchantment(){
		return enchant;
	}
}
