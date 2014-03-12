/*
 * Elif Dede
 * CS575
 * Project 2 - towers of hanoi
 * */
import java.math.BigInteger;
import java.util.Vector;


public class Towers {
	
	private int numOfDisks;
	private BigInteger count;
	private static boolean print;
	private long time;
	
	private Vector<String> output;

	public Towers(int i)
	{
		count = BigInteger.valueOf(0);
		output = new Vector<String>();
		this.numOfDisks = i;
		if(numOfDisks > 5)
			print = false;
		else
			print = true;
	}
	
	public BigInteger Hanoi(int nDisks, char start, char spare, char dest)//(int nDisks, char start, char dest, char spare)
	{
		count = count.add(BigInteger.valueOf(1));//++;//.add(BigInteger.ONE);
	/*	if(nDisks==0)
		{
			if( print)
			{
				//System.out.println("Disk " + 1 + ": Move from " + start + " to " + dest);
				//output.add("Disk " + 1 + ": Move from " + start + " to " + dest);			
			}
		}*/
		if(nDisks>0)//else
		{
			Hanoi(nDisks-1, start, dest, spare);
			if(print)
			{
				System.out.println("Disk " + nDisks + ": Move from " + start + " to " + dest);
				output.add("Disk " + nDisks + ": Move from " + start + " to " + dest);
			}
			Hanoi(nDisks-1, spare, start, dest);
			
		}
		return count;		
	}
	
	public void createOutputContents()
	{
		output.add("The current number of disks is " + numOfDisks);
		output.add("The number of recursive calls was " + this.count + " and the time was " +this.time);
	}

	public Vector<String> getOutput() {
		return output;
	}

	public void setOutput(Vector<String> output) {
		this.output = output;
	}
	
	public void runHanoiGetExecTime(int nDisks, char start, char spare, char dest)
	{
		long startTime = System.currentTimeMillis();
		this.Hanoi(nDisks, start, spare, dest);
		long endTime = System.currentTimeMillis();

		time = endTime-startTime;
		
		System.out.println("Time elapsed is: " + time );
		System.out.println("Number of calls is: " + count);
	}
	

}
