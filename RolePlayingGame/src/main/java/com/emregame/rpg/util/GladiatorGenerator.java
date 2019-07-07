package com.emregame.rpg.util;

import java.util.ArrayList;
import java.util.List;

import com.emregame.rpg.character.enums.ShieldType;
import com.emregame.rpg.character.enums.WeaponType;
import com.emregame.rpg.character.model.Gladiator;

public class GladiatorGenerator {

    static final String[] gladiatorNames = { "spartacus", "crixus", "oenomaus", "gannicus", "agron", "barca", "lugo",
	    "donar", "saxa", "varro", "nemetis" };
    static final int[] gladiatorHealths = { 100, 95, 94, 93, 84, 88, 79, 75, 70, 79, 80 };
    static final int[] gladiatorExperiences = { 4, 4, 4, 3, 3, 2, 1, 1, 0, 0, 0 };
    static final WeaponType[] gladiatorWeapons = { WeaponType.SWORD, WeaponType.SWORD, WeaponType.SWORD,
	    WeaponType.LANCEA, WeaponType.HAMMER, WeaponType.SPEAR, WeaponType.NET, WeaponType.TRIDENT, WeaponType.BOW,
	    WeaponType.TRIDENT, WeaponType.HAMMER };
    static final ShieldType[] gladiatorShields = { ShieldType.CHAINMAIL, ShieldType.HELMET, ShieldType.SCUTUM,
	    ShieldType.KITE, ShieldType.SCUTUM, ShieldType.SCUTUM, ShieldType.HELMET, ShieldType.ARMOR,
	    ShieldType.CHAINMAIL, ShieldType.ARMOR, ShieldType.HELMET };

    public static List<Gladiator> generateGladitorList() {
	List<Gladiator> gladiatorList = new ArrayList<Gladiator>();
	for (int i = 0; i < gladiatorNames.length; i++) {
	    gladiatorList.add(createGladiator(gladiatorNames[i], gladiatorHealths[i], gladiatorExperiences[i],
		    gladiatorWeapons[i], gladiatorShields[i]));
	}
	return gladiatorList;

    }

    public static Gladiator createGladiator(String name, int maxHealth, int experience, WeaponType weapon,
	    ShieldType shield) {
	Gladiator gladiator = new Gladiator();
	gladiator.setName(name);
	gladiator.setMaxHealth(maxHealth);
	gladiator.setCurrentHealth(maxHealth);
	gladiator.setExperience(experience);
	gladiator.prepareFight(weapon, shield);
	return gladiator;
    }
}
