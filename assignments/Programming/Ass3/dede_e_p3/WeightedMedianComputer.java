/*
 * Elif Dede
 * CS575
 * Project 3 - weighted median
 * */

import java.util.Random;
import java.util.Vector;

public class WeightedMedianComputer {
	private Vector<Node> nodes;
	private float W;
	private float H;
	private int regMed;
	//private int regMedInd;
	float wB, wC;

	public WeightedMedianComputer(InputFileReader in)
	{
		nodes =  in.parseFile();
		W = getSumOfTheWeights(this.nodes);
		H=W/2;
	}
	
	public float getSumOfTheWeights(Vector<Node> nodes)
	{
		float sum=0;
		for(int i =0; i<nodes.size();i++)
			sum +=nodes.get(i).getWeight();
		return sum; 
	}
	
	public void setRegMedian()
	{
		int i = (int)Math.ceil((double)this.nodes.size()/2);
		this.regMed = randomized_select(this.nodes, 0, this.nodes.size()-1, i).getKey();
		//nodes.indexOf(o)
		System.out.println("Regular Median Key: " + regMed);
	}
	
	public void printNodes()
	{
		for (Node node : nodes) {
			System.out.println(node.getKey()+ " , "+ node.getWeight());		
		}
	}
	
	public void findWeightedMed()
	{
		setRegMedian();
		
		//System.out.println("Regular Median: "+ m + " stored at the index: " + regMedInd);

		Node w = calcWeightedMed(nodes, 0);//weightedMedian(nodes, 0);
		int weMedInd = nodes.indexOf(w);
				
		System.out.println("Weighted Median Key: " + w.getKey() + " at index: "+ weMedInd );
		
	}
	
	public Node calcWeightedMed(Vector<Node> wnodes, int t)
	{
		wB =0;
		wC=0;
		Node mN = calculateRegularMedian(wnodes);
		int regMedInd = nodes.indexOf(mN);
		
		int m = mN.getKey(); //find regular med;
		
		System.out.println("Regular Median: "+ m + " stored at the index: " + regMedInd);
			
		Vector<Node> B = new Vector<Node>(); //elements less than med
		Vector<Node> C = new Vector<Node>(); //elements greater or equal
		
		if(wnodes.size()==1)
			return wnodes.get(0);
		
		for(int i = 0; i<wnodes.size();i++)
		{
			if(wnodes.get(i).getKey() < m)
			{
				wB+=wnodes.get(i).getWeight();
				B.add(wnodes.get(i));
			}	
			
			else if(wnodes.get(i).getKey() > m)
			{
				wC+=wnodes.get(i).getWeight();
				C.add(wnodes.get(i));
			}
		}
		
		System.out.println("Sum Left: " + wB);
		System.out.println("Sum Right: "+ wC);
		System.out.println("Sum Half: "+ H);
		
		if((wB<H)&&(wC<=H))
		{
			return mN;
		}
		
		else if(wB>=H)
		{
			return calcWeightedMed(B, t);
		}
		
		else if(wC>H)
		{
			return calcWeightedMed(C, (int)wB);
		}
		
		else
		{
			System.out.println("ERROR");
			return null;
		}
			
	}
		
	public Node calculateRegularMedian(Vector<Node> rnodes)
	{
		int i = rnodes.size()/2;//(int)Math.ceil((double)rnodes.size()/2);
		Node med = randomized_select(rnodes, 0, rnodes.size()-1, i);
		return med;
	}
	
	public Node randomized_select(Vector<Node> rnodes, int p, int r, int i)
	{
		if(p>=r)
			return rnodes.get(p);//.getKey();
		int q = randomized_partition(rnodes, p, r);
		int k = q-p+1;
		
		if(i<=k)
			return randomized_select(rnodes, p, q, i);
		else
			return randomized_select(rnodes, q+1, r, i-k);
	}
	
	public int randomized_partition(Vector<Node> rnodes, int p, int r)
	{
		int i = new Random().nextInt(Math.abs(r-p)+1) +p; //get random
		Node temp = rnodes.get(i); //swap
		rnodes.set(i,rnodes.get(r));
		rnodes.set(r, temp);
		return partition(rnodes,p,r);
	}
	
	
	public int partition(Vector<Node> rnodes, int p, int r)
	{
		int x = rnodes.get(p).getKey();
		int i = p-1;
		int j = r+1;
		
		while(true)
		{
			do
			{
				j=j-1;
			}while(rnodes.get(j).getKey()> x);

			do
			{
				i= i+1;
			}while(rnodes.get(i).getKey()< x);
				
			if(i<j)
			{
				Node temp = rnodes.get(i); //swap
				rnodes.set(i,rnodes.get(j));
				rnodes.set(j, temp);		
			}
			
			else 
				return j;
		}		
	}
}
