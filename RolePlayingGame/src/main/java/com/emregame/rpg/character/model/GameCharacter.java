package com.emregame.rpg.character.model;

import java.io.Serializable;
import java.util.Objects;

public class GameCharacter implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -5473510473776300825L;
    private String name;
    private int experience;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
	return Objects.hash(experience, name);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!(obj instanceof GameCharacter))
	    return false;
	GameCharacter other = (GameCharacter) obj;
	return experience == other.experience && Objects.equals(name, other.name);
    }
    
    

}
