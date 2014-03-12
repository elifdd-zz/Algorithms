/*
 * Elif Dede
 * CS575
 * Project 1 - extended heap
 * */

public class HeapRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String infilename =  args[0]; // ;"input.txt";
		String outfilename = args[1]; //"output.txt";
		
		
		System.out.println(infilename +"    " + outfilename);
		
		OperationExecuter exec = new OperationExecuter(infilename, outfilename);
		exec.createOperationList();
		exec.executeOperation();
		
		
		}
}
