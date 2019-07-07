package com.emregame.rpg.io.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.emregame.rpg.game.model.Game;
import com.emregame.rpg.game.model.SpartacusGame;
import com.emregame.rpg.io.SpartacusGameWriter;
import com.emregame.rpg.io.service.LoadService;

public class GameLoadService implements LoadService {
    FileInputStream fileInputStream;
    ObjectInputStream objectInputStream;

    @Override
    public Game loadGame(String name) {
	SpartacusGame savedGame = null;
	try {
	    fileInputStream = new FileInputStream(new File("SavedGames/" + name));
	    objectInputStream = new ObjectInputStream(fileInputStream);
	    savedGame = (SpartacusGame) objectInputStream.readObject();
	    objectInputStream.close();
	} catch (IOException e) {
	    SpartacusGameWriter.printInfo("File not found. Please type a valid name");
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	return savedGame;
    }
}
