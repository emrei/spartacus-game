package com.emregame.rpg.map.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.emregame.rpg.character.model.Gladiator;

public class City implements MapPoint, Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -1306709472361351904L;
    String name;
    int healPack;
    int minRequiredExperience;
    List<Gladiator> gladiatorList;
    Map<String, Gladiator> gladiatorMap;
    
    public String getName() {
	return name;
    }
    
    public void setName(String name) {
	this.name = name;
    }
    
    public int getHealPack() {
	return healPack;
    }
    
    public void setHealPack(int healPack) {
	this.healPack = healPack;
    }
    
    public int getMinRequiredExperience() {
	return minRequiredExperience;
    }
    
    public void setMinRequiredExperience(int minRequiredExperience) {
	this.minRequiredExperience = minRequiredExperience;
    }
    
    public void setGladiatorList(List<Gladiator> gladiatorList) {
	this.gladiatorList = gladiatorList;
    }
    
    public List<Gladiator> getGladiatorList() {
	return gladiatorList;
    }
    
    public void setGladiatorMap(Map<String, Gladiator> gladiatorMap) {
	this.gladiatorMap = gladiatorMap;
    }
    
    public Map<String, Gladiator> getGladiatorMap() {
	return gladiatorMap;
    }
    
    public void listTargets() {
	
    }

    @Override
    public int hashCode() {
	return Objects.hash(gladiatorList, healPack, name);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!(obj instanceof City))
	    return false;
	City other = (City) obj;
	return Objects.equals(gladiatorList, other.gladiatorList) && healPack == other.healPack
		&& Objects.equals(name, other.name);
    }
    
    
}
