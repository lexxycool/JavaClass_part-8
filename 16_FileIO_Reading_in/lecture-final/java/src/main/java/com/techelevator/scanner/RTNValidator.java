package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTNValidator {
	
	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };

	public static void main(String[] args)  {

		printApplicationBanner();

		File inputFile = getInputFileFromUser();  // call the method to ask the user for the File name
//		System.out.println("File name: " + inputFile);

		try(Scanner fileScanner = new Scanner(inputFile)) { // try with resources
			while (fileScanner.hasNextLine()) { // while we still have content to read from the file
				String line = fileScanner.nextLine();
//				System.out.println("line contains: " + line);
				String rtn = line.substring(0, 9); // get rid of any extra characters that might be there

				if (checksumIsValid(rtn)){
					System.out.println(rtn + " :is valid");
				} else {
					System.out.println(rtn + " :NOT VALID");
				}
			}
		} catch (FileNotFoundException ex){
			System.out.println("File not found - please check your path");
		}

		System.out.println("Made it down past the catch block");
		

	}

	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 9000");
		System.out.println("******************");
		System.out.println();
	}

	
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);

		boolean isFileNameCorrect = false;
		File inputFile; // declare the File variable but don't instantiate it here.

		do {
			System.out.print("Please enter path to input file >>> ");
			String path = userInput.nextLine();

//			File inputFile = new File(path);
			inputFile = new File(path);  // instantiate the File variable here once we have the path name

			if (inputFile.exists() == false) { // checks for the existence of a file
				System.out.println(path + " does not exist");
//			System.exit(1); // Ends the program
			} else if (inputFile.isFile() == false) {  // maybe it's a folder!
				System.out.println(path + " is not a file");
//			System.exit(1); // Ends the program
			} else {
//				return inputFile;  -- this let's us keep File as declared in the do loop scope
				isFileNameCorrect = true;
			}
		} while (!isFileNameCorrect);
		return inputFile;
	}

	private static boolean checksumIsValid(String routingNumber) {
		int checksum = 0;
		for(int i = 0; i < 9; i++) {
			int digit = Integer.parseInt(routingNumber.substring(i, i+1));
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}
		return checksum % 10 == 0;
	}
}
