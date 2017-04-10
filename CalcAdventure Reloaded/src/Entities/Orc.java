package Entities;

import items.weapons.Axe;
import items.weapons.Fist;
import items.weapons.Weapon.DamageType;
import items.weapons.Weapon.Enchantment;

public class Orc extends Entity {

	public static String Name = "Orc";
	public static int 	MAX_HP = 30, 
						CUR_HP = 30, 
						STR = 5, 
						AGI = 2, 
						DEX = 0, 
						ITL = -3, 
						CHA = 0;
	public static Alignment align = Alignment.Enemy;
	public static DamageType[] damageTypeWeaknesses = new DamageType[] {};
	public static Enchantment[] enchantWeaknesses = new Enchantment[] {};
	public static String[] battlecries = {	"Heh. Puny.",
											"Scrawny...",
											"Weakling.",
											"Smash!"};

	public Orc() {
		super(Name, MAX_HP, STR, AGI, DEX, ITL, CHA, align,damageTypeWeaknesses, enchantWeaknesses, battlecries);
		weapon1 = new Axe();
		weapon2 = new Fist();
	}

}
