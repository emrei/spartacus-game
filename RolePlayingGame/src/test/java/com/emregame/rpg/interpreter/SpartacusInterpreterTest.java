package com.emregame.rpg.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.emregame.rpg.interpreter.enums.SpartacusCommandEnum;
import com.emregame.rpg.interpreter.service.impl.SpartacusInterpreter;

public class SpartacusInterpreterTest {
    SpartacusInterpreter spartacusInterpreter;
    
    
    @Test
    public void testGetMainMenuCommand_New(){
	SpartacusCommandEnum gameMenuCommand = SpartacusInterpreter.getInstance().getMainMenuCommand("new");
	assertEquals(SpartacusCommandEnum.NEW, gameMenuCommand);
    }
    
    @Test
    public void testGetMainMenuComman_Load(){
	SpartacusCommandEnum gameMenuCommand = SpartacusInterpreter.getInstance().getMainMenuCommand("load");
	assertEquals(SpartacusCommandEnum.LOAD, gameMenuCommand);
    }
    
    @Test
    public void testGetGameMenuCommand_View(){
	SpartacusCommandEnum gameMenuCommand = SpartacusInterpreter.getInstance().getGameMenuCommand("view");
	assertEquals(SpartacusCommandEnum.VIEW, gameMenuCommand);
    }
    
    @Test
    public void testGetGameMenuCommand_Heal(){
	SpartacusCommandEnum gameMenuCommand = SpartacusInterpreter.getInstance().getGameMenuCommand("heal");
	assertEquals(SpartacusCommandEnum.HEAL, gameMenuCommand);
    }
    
    @Test
    public void testGetGameMenuCommand_Fight(){
	SpartacusCommandEnum gameMenuCommand = SpartacusInterpreter.getInstance().getGameMenuCommand("fight");
	assertEquals(SpartacusCommandEnum.FIGHT, gameMenuCommand);
    }
    
    @Test
    public void testGetGameMenuCommand_Explore(){
	SpartacusCommandEnum gameMenuCommand = SpartacusInterpreter.getInstance().getGameMenuCommand("explore");
	assertEquals(SpartacusCommandEnum.EXPLORE, gameMenuCommand);
    }
}
