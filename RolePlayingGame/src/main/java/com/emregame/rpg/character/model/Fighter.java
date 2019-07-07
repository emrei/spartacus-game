package com.emregame.rpg.character.model;

public interface Fighter {
    /**
     * attack to a fighter
     * @param fighter
     */
    public void attack(Fighter fighter);
    /**
     * take damage, it changes with respect to shield, it can be smaller than taken
     * @param takenDamage
     */
    /**
     * take damage, it changes with respect to shield, it can be smaller than taken.
     * returns actual taken damage
     * @param takenDamage
     * @return
     */
    public int damage(int takenDamage);
    /**
     * is dead or not
     * @return
     */
    public boolean isDead();
    /**
     * gain experience
     */
    public void gainExperience();
}
