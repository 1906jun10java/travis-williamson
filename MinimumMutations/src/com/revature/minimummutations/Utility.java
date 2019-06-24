package com.revature.minimummutations;
import java.util.ArrayList;

public class Utility {

	// Constructors
	
	// Instance Variables
	private ArrayList<String> geneBank = new ArrayList<String>();
	private String startingGene = new String();
	private String endingGene = new String();
	
	// Getters & Setters
	
	public ArrayList<String> getGeneBank() {
		return geneBank;
	}
	public void setGeneBank(ArrayList<String> geneBank) {
		this.geneBank = geneBank;
	}
	public String getStartingGene() {
		return startingGene;
	}
	public void setStartingGene(String startingGene) {
		this.startingGene = startingGene;
	}
	public String getEndingGene() {
		return endingGene;
	}
	public void setEndingGene(String endingGene) {
		this.endingGene = endingGene;
	}
	
	// Methods
	
	public boolean isValid(String endingGene, ArrayList<String> geneBank) {
		boolean isValid = false;
		
		if (geneBank.contains(endingGene)) {
			//System.out.println("The ending gene mutation is valid");
			isValid = true;
		}
		
		//System.out.println("The ending gene mutation is not valid");
		return isValid;
	}
	
	public int minimumNumMutations(String startingGene, String endingGene, ArrayList<String> geneBank) {
		setStartingGene(startingGene);
		setEndingGene(endingGene);
		setGeneBank(geneBank);
		
		int numOfMutations = 0;
		
		if(isValid(endingGene, geneBank)) {
			char[] startingGeneCharArray = startingGene.toCharArray();
			char[] endingGeneCharArray = endingGene.toCharArray();
			
			for(int i = 0; i < startingGeneCharArray.length; i++) {
				if(startingGeneCharArray[i] != endingGeneCharArray[i]) {
					numOfMutations++;
				}
			}
		}
		else {
			System.out.println("The ending gene mutation is not valid, so the minimum number of mutations is -1.");
			numOfMutations = -1;
			return numOfMutations;
		}
		
		return numOfMutations;
	}
	
	
}
