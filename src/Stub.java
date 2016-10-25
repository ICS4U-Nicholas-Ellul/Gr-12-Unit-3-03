/****************************************************************************
 *
 * Created by: Nicholas Ellul
 * Created on: Oct 2016
 * This program creates a list of 250 values. The list is then sorted and the 
 * user can search for a number in the list or add to the list.
 ****************************************************************************/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Stub {
	
	private static ArrayList<Integer> total = new ArrayList<Integer>();
	
	public static void printList(ArrayList<Integer> listOfInt){
		// Prints list of numbers in the array
				
		System.out.println("\n *********************************************"
					+ "*******************************");
	    for (Integer integer : listOfInt) {

			System.out.println(integer);
			
		} 
	    
		System.out.println("*********************************************"
					+ "*******************************");
	}
	
	
	public static  ArrayList<Integer> addValue(int value,
			ArrayList<Integer> sortedList){
		
		//Adds value into a sorted list
	
		
		int startingListSize = sortedList.size();
		
		for(int counter = 0 ; counter < startingListSize;
				counter ++){
			
			if(sortedList.get(counter) > value){
				
				sortedList.add(counter, value);
				break;
				
			}
		
		}
		
		if(startingListSize == sortedList.size()){
			sortedList.add(value);
		}
		
		printList(sortedList);
		return sortedList;
	}
	
	
	public static ArrayList<Integer> bubbleSort(
			ArrayList<Integer> passedList){
		
		//Sorts list from lowest to highest.
		
		// input
		int currentNumber;
		int nextNumber;
		
		// process
		for(int counter = 0; counter < passedList.size() - 1; counter++){
			
			for(int innerCounter = 0; innerCounter < passedList.size() - 1; 
					innerCounter++){
				
				currentNumber = passedList.get(innerCounter);
				nextNumber = passedList.get(innerCounter + 1);
			
				if(currentNumber > nextNumber ){
				
					Collections.swap(passedList, innerCounter ,
							innerCounter + 1);
					
				}
			}
		}
		
		// output 
		
		return passedList;
	}
	
	
	public static int binarySearch(ArrayList<Integer> a, int target) {
		
	    return binarySearch(a, 0, a.size()-1, target);
	    
	}

	public static int binarySearch(ArrayList<Integer> a, int start, int end, int target) {
	    
		int middle = (start + end) / 2;
	    
		if(end < start) {
	        
			return -1;
	        
	    } 

	    if(target==a.get(middle)) {
	        
	    	return middle + 1;
	        
	    } else if(target<a.get(middle)) {
	    
	    	return binarySearch(a, start, middle - 1, target);
	    	
	    } else {
	        
	    	return binarySearch(a, middle + 1, end, target);
	    }
	}
	
	
	public static int checkForInt(String message){
		// gets the user to input an integer
		// continues to ask until a valid input is given
		
		@SuppressWarnings("resource")
		
		// input
		Scanner methodReader = new Scanner(System.in);
		
		boolean valid = false;
		int userInput = 0;
		
		// process
		while(valid == false){
			try {
				
				System.out.println(message);
				userInput = Integer.parseInt(methodReader.nextLine());
				valid = true;
			
			} 
			
			catch (NumberFormatException e) {
				
				System.err.println("Invalid input. Please enter integer.");
		    
			}
		}
		
		// output
		return userInput;
		
	}
	
	
	public static void main(String[] args) {
		
		//variables
		ArrayList<Integer> valueList = new ArrayList<Integer>();
		Scanner reader = new Scanner(System.in);
		
		int maxRange = 500;
		int minRange = -500;
		int intUserInput = 0;
		final int ELEMENTS_IN_ARRAY = 10;
		
		String strUserInput = "";
		
		//initializing
		
		System.out.println("*Generating List* \n");

	printList(valueList);
	///	for(int counter = 0; counter < ELEMENTS_IN_ARRAY; counter ++ ){
			
		///valueList.add(ThreadLocalRandom.current().nextInt(minRange,
	//				maxRange + 1));
	//		
	//		System.out.println(valueList.get(counter));
	//		
	//	}
	//	
		System.out.println();
		
		System.out.println("*Sorting List* \n");
	
		
		valueList = bubbleSort(valueList);
			printList(valueList);
		// User actions
		System.out.println("Enter 'search' to find the order of a number in "
				+ "the list.");
		
		System.out.println("Enter 'add' to add a number to the list.");
		System.out.println("Enter 'view' to view list");
		System.out.println("Enter 'done' to exit program");
		
		// loops until user is done
		for(;;){
			
			System.out.println("\n What would you like to do? "
					+ "(search / add / view / done)");	
			
			strUserInput = reader.nextLine();
			
			// Binary Search
			if(strUserInput.equals("search")){
				
				intUserInput = checkForInt("\n What number would you like to "
						+ "find the order of.");	
				
				System.out.println(binarySearch(valueList,intUserInput));
				
			}
			
			// Add to list
			else if(strUserInput.equals("add")){
				
				intUserInput = checkForInt("\n What number would you like to "
						+ "add to the list");
				
				valueList = addValue(intUserInput, valueList);
				
			}
			
			else if(strUserInput.equals("view")){
				// print list to screen 
				
				printList(valueList);
				
			}
			// End program
			else if(strUserInput.equals("done")){
				
				System.out.println("Done.");
				break;
				
			}
			
			// Error
			else{
				
				System.err.println("Invalid input.");
				
			}				
		}
	} 
}
