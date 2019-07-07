package com.emregame.rpg.player.model;

import java.io.Serializable;
import java.util.Objects;

import com.emregame.rpg.character.model.Gladiator;
import com.emregame.rpg.map.model.MapPoint;

public class SpartacusPlayer implements Moveable, Player, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -4205146454519850196L;
    String name;
    Gladiator gladiator;
    MapPoint city;

    public void setName(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public void setGladiator(Gladiator gladiator) {
	this.gladiator = gladiator;
    }

    public Gladiator getGladiator() {
	return gladiator;
    }

    @Override
    public void setMapPoint(MapPoint mapPoint) {
	this.city = mapPoint;

    }

    @Override
    public MapPoint getMapPoint() {
	return city;
    }

    @Override
    public int hashCode() {
	return Objects.hash(gladiator, name);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!(obj instanceof SpartacusPlayer))
	    return false;
	SpartacusPlayer other = (SpartacusPlayer) obj;
	return Objects.equals(gladiator, other.gladiator) && Objects.equals(name, other.name);
    }
    
    
}
