package game;

import items.Weapons.DamageType;
import items.Weapons.Enchantment;

public enum Entities {
	
	//HP, STR, AGI, DEX, ITL, CHA
	Chosen_One(),
	Ohmarr(50, 5, 7, 4, 10, 0, Alignment.Neutral, 
			new DamageType[] {}, 
			new Enchantment[] {},
			new String[] {	"Your knowledge pales in comparison to mine.",
							"Face the power of my intellect!",
							"Your knowledge pales in comparison to mine.",
							"Face the power of my intellect!",
							"Your knowledge pales in comparison to mine.",
							"Face the power of my intellect!",
							"Have you read a book lately? I read ten last night."}),
	Orc(30, 2, 5, 0, -3, 0, Alignment.Enemy, 
			new DamageType[] {},
			new Enchantment[] {},
			new String[] {	"Heh. Puny.",
							"Scrawny...",
							"Weakling.",
							"Smash!"}),
	Zombie(30, 2, 5, 0, -3, 0, Alignment.Enemy, 
			new DamageType[] {DamageType.Bludgeoning},
			new Enchantment[] {Enchantment.Holy},
			new String[] {	"Rrraaaa...",
							"Graa...",
							"Zom zom, Zombie!",
							"Rrraaaa...",
							"Graa...",
							"Rrraaaa...",
							"Graa...",
							"Rrraaaa...",
							"Graa...",
							"You humans are so uncouth. Brains are for truly civilized folks."});
	
	public enum Alignment{Friendly, Neutral, Enemy};
	
	private final int MAX_HP, CUR_HP, STR, AGI, DEX, ITL, CHA;
	private Alignment align;
	private DamageType[] damageTypeWeaknesses;
	private Enchantment[] enchantWeaknesses;
	private String[] battlecries;
	
	Entities(){
		this.MAX_HP = 20;
		this.CUR_HP = MAX_HP;
		this.STR = 10;
		this.AGI = 10;
		this.DEX = 10;
		this.ITL = 10;
		this.CHA = 10;
	}
	
	Entities(int MAX_HP, int STR, int AGI, int DEX, int ITL, int CHA, Alignment align, 
			DamageType[] damageTypeWeaknesses, Enchantment[] enchantWeaknesses,
			String[] battlecries){
		this.MAX_HP = MAX_HP;
		this.CUR_HP = MAX_HP;
		this.STR = 10 + STR;
		this.AGI = 10 + AGI;
		this.DEX = 10 + DEX;
		this.ITL = 10 + ITL;
		this.CHA = 10 + CHA;
		this.align = align;
		this.damageTypeWeaknesses = damageTypeWeaknesses;
		this.enchantWeaknesses = enchantWeaknesses;
		this.battlecries = battlecries;
	}
	
	public int getMAX_HP(){
		return MAX_HP;
	}
	
	public int getCUR_HP(){
		return CUR_HP;
	}
	
	public int getSTR(){
		return STR;
	}
	
	public int getAGI(){
		return AGI;
	}
	
	public int getDEX(){
		return DEX;
	}
	
	public int getITL(){
		return ITL;
	}
	
	public int getCHA(){
		return CHA;
	}
	
	public Alignment getAlignment(){
		return align;
	}
	
	public DamageType[] getDamageTypeWeaknesses(){
		return damageTypeWeaknesses;
	}
	
	public Enchantment[] getEnchantmentWeaknesses(){
		return enchantWeaknesses;
	}
	
	public String[] getBattlecries(){
		return battlecries;
	}

}
