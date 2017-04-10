package items.weapons;

import items.Item;


public abstract class Weapon extends Item{

	public enum DamageType{None, Bludgeoning, Piercing, Slashing, Ranged, Mental, Magic};
	public enum Enchantment{None, Fire, Lightning, Poison, Holy};
	
	private int[] dieRolls;
	private DamageType[] damageType;
	private Enchantment enchant;
	
	public Weapon(String name, int[] dieRolls, DamageType[] dmgType, Enchantment enchant, int weight, String description){
		super(name, weight, description);
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
