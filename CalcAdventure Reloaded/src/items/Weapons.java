package items;

public enum Weapons {

	Fist(new int[] {4}, new DamageType[] {DamageType.Bludgeoning}, Enchantment.None),
	Dagger(new int[] {4}, new DamageType[] {DamageType.Piercing, DamageType.Ranged}, Enchantment.None),
	Posion_Dagger(new int[] {4, 4}, new DamageType[] {DamageType.Piercing, DamageType.Ranged}, Enchantment.Poison),
	Longsword(new int[] {6}, new DamageType[] {DamageType.Piercing, DamageType.Slashing}, Enchantment.None),
	Bow(new int[] {4}, new DamageType[] {DamageType.Bludgeoning}, Enchantment.None),
	Arrow(new int[] {4}, new DamageType[] {DamageType.Piercing, DamageType.Ranged}, Enchantment.None),
	Arrow_of_Flame(new int[] {4, 4}, new DamageType[] {DamageType.Piercing, DamageType.Ranged}, Enchantment.Fire),
	Arrow_of_Lightning(new int[] {4, 4}, new DamageType[] {DamageType.Piercing, DamageType.Ranged}, Enchantment.Lightning),
	Arrow_of_Poison(new int[] {4, 4}, new DamageType[] {DamageType.Piercing, DamageType.Ranged}, Enchantment.Poison),
	Arrow_of_Light(new int[] {4, 4}, new DamageType[] {DamageType.Piercing, DamageType.Ranged}, Enchantment.Holy);

	public enum DamageType{None, Bludgeoning, Piercing, Slashing, Ranged};
	public enum Enchantment{None, Fire, Lightning, Poison, Holy};
	
	private int[] DAMAGE;
	private DamageType[] dmgType;
	private Enchantment enchant;
	
	Weapons(int[] DAMAGE, DamageType[] dmgType, Enchantment enchant){
		this.DAMAGE = DAMAGE;
		this.dmgType = dmgType;
		this.enchant = enchant;
	}
	
	public int[] getDamage(){
		return DAMAGE;
	}
	
	public DamageType[] getDamageType(){
		return dmgType;
	}
	
	public Enchantment getEnchantment(){
		return enchant;
	}
	
}
