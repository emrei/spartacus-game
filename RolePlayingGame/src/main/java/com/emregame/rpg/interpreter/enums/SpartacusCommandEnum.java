package com.emregame.rpg.interpreter.enums;

public enum SpartacusCommandEnum {
    SAVE("save", CommandType.GAME), 
    LOAD("load", CommandType.MAIN), 
    EXIT("exit", CommandType.GAME),
    NEW("new", CommandType.MAIN),
    VIEW("view", CommandType.GAME), 
    HEAL("heal", CommandType.GAME),
    FIGHT("fight", CommandType.GAME), 
    EXPLORE("explore", CommandType.GAME);

    String value;
    CommandType commandType;
    

    private SpartacusCommandEnum(String value, CommandType commandType) {
	this.value = value;
	this.commandType = commandType;
    }


    public String getValue() {
	return value;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    
}
