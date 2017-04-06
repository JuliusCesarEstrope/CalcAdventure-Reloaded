package items;


public abstract class Weapon extends Item{

	public enum DamageType{None, Bludgeoning, Piercing, Slashing, Ranged, Mental, Magic};
	public enum Enchantment{None, Fire, Lightning, Poison, Holy};
	
	private int[] dieRolls;
	private DamageType[] damageType;
	private Enchantment enchant;
	
	public Weapon(String Name, int[] dieRolls, DamageType[] dmgType, Enchantment enchant, int weight, String description){
		super(weight, description);
		this.name = Name;
		this.dieRolls = dieRolls;
		this.damageType = dmgType;
		this.enchant = enchant;
	}
	
	public int[] getDieRolls(){
		return dieRolls;
	}
	
	public DamageType[] getDamageType(){
		return damageType;
	}
	
	public Enchantment getEnchantment(){
		return enchant;
	}
}
