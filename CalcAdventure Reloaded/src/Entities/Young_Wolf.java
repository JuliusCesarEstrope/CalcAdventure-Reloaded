package Entities;

import items.Weapon;
import items.Weapon.DamageType;
import items.Weapon.Enchantment;
import items.weapons.Claw;
import items.weapons.None;

public class Young_Wolf extends Entity {

	public static String Name = "Young Wolf";
	public static int 	MAX_HP = 12, 
						CUR_HP = 12, 
						STR = 2, 
						AGI = 5, 
						DEX = 3, 
						ITL = 0, 
						CHA = 0;
	public static Weapon	weapon1 = new Claw(), 
							weapon2 = new None();
	public static Alignment align = Alignment.Enemy;
	public static DamageType[] damageTypeWeaknesses = new DamageType[] {};
	public static Enchantment[] enchantWeaknesses = new Enchantment[] {};
	public static String[] battlecries = {	"Grrr...",
											"*snarl*",
											"Auuuuuu!"};

	public Young_Wolf() {
		super(Name, MAX_HP, STR, AGI, DEX, ITL, CHA, align,damageTypeWeaknesses, enchantWeaknesses, battlecries);
		weapon1 = new Claw();
		weapon2 = new None();
	}

}
