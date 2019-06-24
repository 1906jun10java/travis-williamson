package com.revature.minimummutations;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		Utility minimumMutationChecker = new Utility();
		
		// First attempt - hardcoding
		String startingGene = "AACCGGTT";
		//String startingGene = "AAACGGTA";
		String endingGene = "AAACGGTA";
		ArrayList<String> geneBank = new ArrayList<String>();
		geneBank.add("AACCGGTA");
		geneBank.add("AACCGCTA");
		geneBank.add("AAACGGTA");
		
		System.out.println("The minimum number of mutations for the gene " + startingGene + " to become " + endingGene + " is: " + minimumMutationChecker.minimumNumMutations(startingGene, endingGene, geneBank));
	}
}
