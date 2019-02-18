package com.alsis.shoppingcart.utils;

import java.util.Scanner;

/**
 * This util offers methods to do user input checking 
 * @author RAJESH
 *
 */
public class InputCheckingUtil {
	private static InputCheckingUtil util;

	// Private constructor prevents direct instantiation
	private InputCheckingUtil() {
	}

	public static InputCheckingUtil getUtil() {
		if (util == null) {
			util = new InputCheckingUtil();
		}
		return util;
	}

	/*public static int getIntWithChecking(Scanner scan) {
		int mInt; 
		while (!scan.hasNextInt()) {
			System.out.println("That's not a number!");
			scan.next(); 
		}
		mInt = scan.nextInt();
		return mInt; 
	}*/
	
	public static long getLongWithChecking(Scanner scan) {
		long mInt; 
		while (!scan.hasNextLong()) {
			System.out.println("That's not a number!");
			scan.nextLine(); 
		}
		mInt = scan.nextLong();
		return mInt; 

	}

}
