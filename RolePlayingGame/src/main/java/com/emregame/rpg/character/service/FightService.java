package com.emregame.rpg.character.service;

import com.emregame.rpg.character.model.GameCharacter;
import com.emregame.rpg.map.model.MapPoint;

public interface FightService {
    /**
     * start a combat between two game character and returns winner
     * @param first
     * @param second
     * @return
     */
    public GameCharacter fight(GameCharacter first, GameCharacter second);
    /**
     * select a target for fighting in a map point
     * @param mapPoint
     * @return
     */
    public GameCharacter selectTarget(MapPoint mapPoint);
}
