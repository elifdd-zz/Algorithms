/*
 * Elif Dede
 * CS575
 * Project 2 - towers of hanoi
 * */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;


public class OutputFileWriter {
	private String outputFile;
	private File fout;
	private BufferedWriter out;

	public OutputFileWriter(String filename)
	{
		outputFile = filename;
		fout = new File(outputFile);
		try {
			out = new BufferedWriter(new FileWriter(fout));
		} catch (IOException e) {
			System.out.println("Cannot find the output file");
			System.exit(1);
		} 
	}


	public void writeFile(Vector<String> lines)
	{

		System.out.println("******Writing ouput file**********");
		for(int i = 0; i<lines.size(); i++)
		{
			try {
				out.write(lines.get(i));
				out.newLine();
			} catch (IOException e) {
				System.out.println("Writing file failed");
				System.exit(1);
			}
		}

		try {
			if (out != null) {
				out.flush();
				out.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}



}