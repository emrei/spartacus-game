package com.emregame.rpg.character.service;

import com.emregame.rpg.character.model.GameCharacter;

public interface HealService {
    /**
     * heal game character by using given healPack
     * return remaining of healPack
     * @param gameCharacter
     * @param healPack
     * @return
     */
    public int heal(GameCharacter gameCharacter, int healPack);
}
