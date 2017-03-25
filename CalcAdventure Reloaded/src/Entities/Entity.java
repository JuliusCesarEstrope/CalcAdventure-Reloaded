package Entities;

import game.Utilities;
import items.Weapon;
import items.Weapon.DamageType;
import items.Weapon.Enchantment;
import items.weapons.Fist;
import items.weapons.None;

public abstract class Entity {
	
	public enum Alignment{Friendly, Neutral, Enemy};
	
	public String Name;
	public int MAX_HP, CUR_HP, STR, AGI, DEX, ITL, CHA;
	public Weapon	weapon1 = new Fist(), 
					weapon2 = new Fist();
	public Alignment align;
	public DamageType[] damageTypeWeaknesses = new DamageType[] {};
	public Enchantment[] enchantWeaknesses = new Enchantment[] {};
	public String[] battlecries = {"..."};
	
	public Entity(){
		this.Name = "Anonymous";
		this.MAX_HP = 1;
		this.CUR_HP = 1;
		this.STR = 10;
		this.AGI = 10;
		this.DEX = 10;
		this.ITL = 10;
		this.CHA = 10;
		this.align = Alignment.Friendly;
	}
	
	public Entity(String Name, int MAX_HP, int STR, int AGI, int DEX, int ITL, int CHA, Alignment align, 
			DamageType[] damageTypeWeaknesses, items.Weapon.Enchantment[] enchantWeaknesses,
			String[] battlecries){
		this.Name = Name;
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
	
	public String toString(){
		return Name;
	}
	
	public String getName(){
		return Name;
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
	
	public String getBattlecry(){
		return battlecries[Utilities.randNum(0, battlecries.length)];
	}
	
	public void setName(String Name){
		this.Name = Name;
	}
	
	public void setMAX_HP(int MAX_HP){
		this.MAX_HP = MAX_HP;
	}
	
	public void setCUR_HP(int CUR_HP){
		this.CUR_HP = CUR_HP;
	}
	
	public void setSTR(int STR){
		this.STR =  STR;
	}
	
	public void setAGI(int AGI){
		this.AGI = AGI;
	}
	
	public void setDEX(int DEX){
		this.DEX = DEX;
	}
	
	public void setITL(int ITL){
		this.ITL = ITL;
	}
	
	public void setCHA(int CHA){
		this.CHA = CHA;
	}
	
	public void setAlignment(Alignment align){
		this.align = align;
	}
	
	//Below should be changed for changing these values
	//Could be used to change player characteristics
/*	public void addDamageTypeWeakness(DamageType[] weaknesses){
		Utilities.concatAll(damageTypeWeaknesses, weaknesses)
	}
	
	public Enchantment[] getEnchantmentWeaknesses(){
		return enchantWeaknesses;
	}
	
	public String[] getBattlecries(){
		return battlecries;
	}*/
	
	public void dealDamage(int damage){
		CUR_HP -= damage;
	}

	public void showWeapons(){
		if(weapon1.equals(weapon2))
			Utilities.display(this.Name + " is equipped with two " + weapon1.toString() + "s.");
		else {
			if(!(weapon1.equals(new Fist()) || weapon1.equals(new None())))
				Utilities.display(this.Name + " is equipped with " + weapon1.toString());
			if (!(weapon2.equals(new Fist()) || weapon1.equals(new None())))
				Utilities.display(" and " + weapon2.toString());
		}
	}
	
	public void performAttack(Entity target){
		int hit = Utilities.roll(20) + ((getSTR() - 10) / 2);
		int dodge = 10 + (target.getDEX() - 10) / 2;
		int damage = 0;
		int weapon1Mod = 0;
		int weapon2Mod = 0;
		//Sets weapon1's damage modifier
		if(Utilities.isInArray(DamageType.Magic, weapon1.getDamageType()) != -1)
			weapon1Mod = (getITL() - 10) / 2;
		else if(Utilities.isInArray(DamageType.Ranged, weapon1.getDamageType()) != -1)
			weapon1Mod = (getDEX() - 10) / 2;
		else
			weapon1Mod = (getSTR() - 10) / 2;
		//Sets weapon2's damage modifier
		if(Utilities.isInArray(DamageType.Magic, weapon2.getDamageType()) != -1)
			weapon2Mod = (getITL() - 10) / 2;
		else if(Utilities.isInArray(DamageType.Ranged, weapon2.getDamageType()) != -1)
			weapon2Mod = (getDEX() - 10) / 2;
		else
			weapon2Mod = (getSTR() - 10) / 2;
		if(hit >= dodge){
			if(weapon1.toString().equalsIgnoreCase(weapon2.toString())){
				Utilities.display(this.Name + " strikes with two " + weapon1.toString() + "s.");
				for (int i = 0; i < 2; i++)
					for (int die : weapon1.getDieRolls())
						damage += Utilities.roll(die) + 2 * weapon1Mod;
			} else {
				if(!(weapon1.equals(new Fist()) || weapon1.equals(new None()))){
					Utilities.display(this.Name + " strikes with " + weapon1.toString());
					for (int die : weapon1.getDieRolls())
						damage += Utilities.roll(die) + weapon1Mod;
				}
				if (!(weapon2.equals(new Fist()) || weapon2.equals(new None()))){
					Utilities.display(" and " + weapon2.toString());
					for (int die : weapon2.getDieRolls())
						damage += Utilities.roll(die) + weapon2Mod;
				}
			}
			if(hit == 20){
				damage *= 2;
				target.dealDamage(damage);
				Utilities.display(this.Name + " deals " + damage + "critical damage!");
			} else{
				target.dealDamage(damage);
				Utilities.display(this.Name + " deals " + damage + " damage.");
			}
		} else
			Utilities.display(this.Name + " missed " + target.toString());
		
	}
	
}
