package com.revature.minimummutations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Driver {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		/*
		// First attempt - hardcoding
		 * 
		String startGene = "AACCGGTT";
		//String startGene = "AAACGGTA";
		String endGene = "AAACGGTA";
		ArrayList<String> geneBank = new ArrayList<String>();
		geneBank.add("AACCGGTA");
		geneBank.add("AACCGCTA");
		geneBank.add("AAACGGTA");
		*/
		
		// Second attempt - reading input from a file
		
		/*
		 * Here is where I created the text file:
		 * 
		// Creating objects to be written to a file
		
		String sGene = "AACCGGTT";
		String eGene = "AAACGGTA";
		ArrayList<String> gBank = new ArrayList<String>();
		gBank.add("AACCGGTA");
		gBank.add("AACCGCTA");
		gBank.add("AAACGGTA");
		
		// Writing objects to a file
		ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream("MinimumMutations.txt"));
		objectOutput.writeObject(sGene);
		objectOutput.writeObject(eGene);
		objectOutput.writeObject(gBank);
		*/
		
		// Reading file and creating objects from it
		ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream("MinimumMutations.txt"));
		
		String startGene = (String) objectInput.readObject();
		String endGene = (String) objectInput.readObject();
		ArrayList<String> geneBank = (ArrayList<String>) objectInput.readObject();
	    
		/*
		// Checking to see if it read the file and created objects correctly
	    System.out.println(startGene);
	    System.out.println(endGene);
	    System.out.println(geneBank);
	    */
	    
	    // Creating a Utility object and running the minimumNumMutations() method on it
		// using the object created from reading the file
		
		Utility minimumMutationChecker = new Utility();
		
		System.out.println("The minimum number of mutations for the gene " + startGene + " to become " + endGene + " is: " + minimumMutationChecker.minimumNumMutations(startGene, endGene, geneBank));
	}
}
