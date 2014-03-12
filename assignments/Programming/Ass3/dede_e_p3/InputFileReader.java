/*
 * Elif Dede
 * CS575
 * Project 3 - weighted median
 * */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class InputFileReader {
	private String inputFile;
	private Vector<Node> nodes;
	private File fin;
	private BufferedReader in;	
	private Vector<String> lines;
	
	
	public InputFileReader(String inFileName)
	{
		lines = new Vector<String>();
		nodes = new Vector<Node>();
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
				//System.out.println(lines.lastElement());
			}
		} catch (IOException e) {
			System.out.println("Reading File Failed");
			System.exit(1);
		}
		
		closeFile();
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
	
	public Node parseLine(String line)
	{
		Node node = new Node();
		int key, weight;
		String[] s;
		
		s = line.split(",");
		key = Integer.parseInt(s[0]);
		weight = Integer.parseInt(s[1]);
		
		node.setKey(key);
		node.setWeight(weight);
		
		return node;
	}
	
	public Vector<Node> parseFile()
	{
		for(int i=0; i<lines.size();i++)
		{	
			nodes.add(this.parseLine(lines.get(i)));
		}	
		
		return nodes;
	}
	

}
