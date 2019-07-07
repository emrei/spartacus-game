package com.emregame.rpg.io.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.emregame.rpg.game.model.Game;
import com.emregame.rpg.io.service.SaveService;

public class GameSaveService implements SaveService {
    FileOutputStream fileOutputStream;
    ObjectOutputStream objectOutputStream;


    @Override
    public void save(String name, Game game) {
	try {
	    
	    File directory = new File("SavedGames/");
	    if (! directory.exists()){
		directory.mkdir();
	    }
	    
	    fileOutputStream = new FileOutputStream(new File(directory + "/" + name));
	    objectOutputStream = new ObjectOutputStream(fileOutputStream);
	    objectOutputStream.writeObject(game);
	    objectOutputStream.close();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
    }
}
