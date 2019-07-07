package com.emregame.rpg.character.service.impl;

import com.emregame.rpg.character.model.GameCharacter;
import com.emregame.rpg.character.model.Gladiator;
import com.emregame.rpg.character.service.ViewService;
import com.emregame.rpg.io.SpartacusGameWriter;

public class GladiatorViewService implements ViewService {

    @Override
    public void view(GameCharacter gameCharacter) {
	SpartacusGameWriter.printGladiatorInfo((Gladiator) gameCharacter);
	
    }

}
