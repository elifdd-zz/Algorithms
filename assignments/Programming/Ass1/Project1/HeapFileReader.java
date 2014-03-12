/*
 * Elif Dede
 * CS575
 * Project 1 - extended heap
 * */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;


public class HeapFileReader {
	private String inputFile;
	private File fin;
	private Vector<String> lines;
	private Vector<Operation> operations;
	private BufferedReader in; 
	public Vector<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Vector<Operation> operations) {
		this.operations = operations;
	}

	public HeapFileReader(String inFileName)
	{
		lines = new Vector<String>();
		operations = new Vector<Operation>();
		inputFile=inFileName;
		fin = new File(inputFile);
		try {
			in = new BufferedReader(new FileReader(fin));
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find the input file");
			System.exit(1);
		}		
	}

	public void ReadFile()
	{
		String line;
		try {
			while(( line = in.readLine()) != null)
			{
				lines.add(line);
				System.out.println(lines.lastElement());
			}
		} catch (IOException e) {
			System.out.println("Reading File Failed");
			System.exit(1);
		}
		
		closeFile();
	}

	public void parseOperation(String operation)
	{
		Operation op = new Operation();
		String operName = null;
		int frstOp=0, scndOp=0;
		int k = 0;
		int i = 1;
		int size;
		
		while(operation.charAt(i)!=':')
		{
			i++;
		}
		
		String cleaned  = operation.substring(i+2);
		System.out.println(cleaned);

		if(cleaned.startsWith("insert"))
		{
			k = i+2;
			while(operation.charAt(k)!=' ')
			{
				k++;
			}
			operName=operation.substring(i+2, k);
			i = k+1;
			while(operation.charAt(i)!=' ')
			{
				i++;
			}
			frstOp = Integer.parseInt(operation.substring(k+1, i));
			scndOp = Integer.parseInt(operation.substring(i+1));
		}

		else if(cleaned.startsWith("print"))
		{
			System.out.println("Print Operation");
			operName = "print";
			frstOp = -1;
			scndOp = -1;
		}

		else if(cleaned.startsWith("find"))
		{
			System.out.println("Find Operation");
			operName = "find";
			i = 0;
			while(cleaned.charAt(i)!=' ')
			{
				i++;
			}
			frstOp = Integer.parseInt(cleaned.substring(i+1));
			scndOp = -1;
			//System.out.println(frstOp);
		}

		else if(cleaned.startsWith("deleteMin"))
		{
			System.out.println("Delete Operation");
			operName = "deleteMin";
			frstOp = -1;
			scndOp = -1;
		}

		else if(cleaned.startsWith("change"))
		{
			System.out.println("Change Priorty Operation");
			operName = "change";
			i = 0;
			while(cleaned.charAt(i)!=' ')
			{
				i++;
			}
			//i = 0;
			cleaned = cleaned.substring(i+1);
			while(cleaned.charAt(i+1)!=' ')
			{
				i++;
			}
			
			cleaned = cleaned.substring(i+2);
			i = 0;
			while(cleaned.charAt(i)!=' ')
			{
				i++;
			}
			frstOp = Integer.parseInt(cleaned.substring(0, i));
			System.out.println(cleaned);
			
			scndOp = Integer.parseInt(cleaned.substring(i+1));
		}
		else
		{
			size= Integer.parseInt(cleaned);
			System.out.println("Array size: " + size);
			operName = "Size";
			frstOp = size;
			scndOp = -1;
			
		}
		
		op.setOName(operName);
		op.setFstOperand(frstOp);
		op.setScndOperand(scndOp);
		
		operations.add(op);
		printOperation(op);
	}


	public void parseLine()
	{
		for(int i = 0; i<lines.size(); i++)
		{

			parseOperation(lines.get(i));
			//	printOperation(operations.get(i));
		}
	}

	public void printOperation(Operation o)
	{
		System.out.println("Name: " + o.getOName());
		System.out.println("1st: " + o.getFstOperand());
		System.out.println("2nd: " + o.getScndOperand());
	}
	
	public void closeFile()
	{
		try {
			in.close();
		} catch (IOException e) {
			System.out.println("Closing Buffered Reader Failed");
			System.exit(1);
		}
	}



}
