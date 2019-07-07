package com.emregame.rpg.io;

import java.util.Scanner;

/**
 * Read input from console
 * 
 * @author YunusEmre
 *
 */
public class SpartacusGameReader {

    static final Scanner inputScanner = new Scanner(System.in);
    
    public static String readLine() {
	return inputScanner.nextLine();
    }

    public static void close() {
	inputScanner.close();
	
    }


}
