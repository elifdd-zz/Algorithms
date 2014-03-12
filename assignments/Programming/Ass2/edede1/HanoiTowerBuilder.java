/*
 * Elif Dede
 * CS575
 * Project 2 - towers of hanoi
 * */

public class HanoiTowerBuilder {

	public static void main(String[] args) {
		
		int numOfDisks = Integer.parseInt(args[0]);
		String outputFile = args[1];
		
		OutputFileWriter fw = new OutputFileWriter(outputFile);
		
		Towers t = new Towers(numOfDisks);
		//t.Hanoi(numOfDisks, 'S', 'I', 'D');
		
		t.runHanoiGetExecTime(numOfDisks, 'S', 'I', 'D');
		t.createOutputContents();
		
		fw.writeFile(t.getOutput());
		
		//System.out.println("Number of calls: " + t.getCount());
	

	}

}
