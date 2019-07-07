package com.emregame.rpg.interpreter.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.emregame.rpg.character.enums.ShieldType;
import com.emregame.rpg.character.enums.WeaponType;
import com.emregame.rpg.interpreter.enums.CommandType;
import com.emregame.rpg.interpreter.enums.SpartacusCommandEnum;
import com.emregame.rpg.interpreter.service.Interpreter;

public class SpartacusInterpreter implements Interpreter {

    private static final Map<String, SpartacusCommandEnum> spartacusCommandMap = new HashMap<String, SpartacusCommandEnum>();
    private static final Map<String, WeaponType> weaponCommandMap = new HashMap<String, WeaponType>();
    private static final Map<String, ShieldType> shieldCommandMap = new HashMap<String, ShieldType>();

    private static SpartacusInterpreter instance = null;

    public static SpartacusInterpreter getInstance() {
	if (instance == null)
	    instance = new SpartacusInterpreter();

	return instance;
    }

    private SpartacusInterpreter() {
	for (SpartacusCommandEnum commandEnum : SpartacusCommandEnum.values()) {
	    spartacusCommandMap.put(commandEnum.getValue(), commandEnum);
	}
	for (WeaponType weapon : WeaponType.values()) {
	    weaponCommandMap.put(weapon.getName(), weapon);
	}
	for (ShieldType shield : ShieldType.values()) {
	    shieldCommandMap.put(shield.getName(), shield);
	}
    }

    public SpartacusCommandEnum getMainMenuCommand(String commandString) {
	SpartacusCommandEnum spartacusCommandEnum = spartacusCommandMap.get(commandString);
	if (spartacusCommandEnum != null && spartacusCommandEnum.getCommandType() == CommandType.MAIN) {
	    return spartacusCommandEnum;
	} else {
	    return null;
	}
    }

    public SpartacusCommandEnum getGameMenuCommand(String commandString) {
	SpartacusCommandEnum spartacusCommandEnum = spartacusCommandMap.get(commandString);
	if (spartacusCommandEnum != null && spartacusCommandEnum.getCommandType() == CommandType.GAME) {
	    return spartacusCommandEnum;
	} else {
	    return null;
	}
    }

    public WeaponType getWeapon(String commandString) {
	return weaponCommandMap.get(commandString);
    }

    public ShieldType getShield(String commandString) {
	return shieldCommandMap.get(commandString);
    }

}
