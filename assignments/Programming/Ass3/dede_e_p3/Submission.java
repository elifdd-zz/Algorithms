/*
 * Elif Dede
 * CS575
 * Project 3 - weighted median
 * */

public class Submission {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String filename = args[0];
		
		InputFileReader input = new InputFileReader(filename);
		input.ReadFile();
		
		WeightedMedianComputer comp = new WeightedMedianComputer(input);
		//comp.printNodes();
		comp.findWeightedMed();//.weightedMedian(nodes, 0)
		//comp.printNodes();
		

	}

}
