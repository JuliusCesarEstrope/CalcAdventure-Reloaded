package Entities;

import items.Weapon;
import items.Weapon.DamageType;
import items.Weapon.Enchantment;
import items.weapons.Fist;
import items.weapons.Wand;

public class Ohmarr extends Entity {

	public static String Name = "Ohmarr";
	public static int 	MAX_HP = 50, 
						CUR_HP = 50, 
						STR = 5, 
						AGI = 7, 
						DEX = 4, 
						ITL = 10, 
						CHA = 0;
	public static Weapon	weapon1 = new Wand(), 
							weapon2 = new Fist();
	public static Alignment align = Alignment.Neutral;
	public static DamageType[] damageTypeWeaknesses = new DamageType[] {};
	public static Enchantment[] enchantWeaknesses = new Enchantment[] {};
	public static String[] battlecries = {	"Your knowledge pales in comparison to mine.",
											"Face the power of my intellect!",
											"Your knowledge pales in comparison to mine.",
											"Face the power of my intellect!",
											"Your knowledge pales in comparison to mine.",
											"Face the power of my intellect!",
											"Have you read a book lately? I read ten last night."};

	public Ohmarr() {
		super(Name, MAX_HP, STR, AGI, DEX, ITL, CHA, align,damageTypeWeaknesses, enchantWeaknesses, battlecries);
	}

}
