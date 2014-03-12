/*
 * Elif Dede
 * CS575
 * Project 1 - extended heap
 * */
public class OperationExecuter {
	private HeapFileReader hfr;
	private Heap extenedHeap;
	private HeapOutputFileWriter hfw;
	
	public OperationExecuter(String inputFile, String outputFile)
	{
		hfr = new HeapFileReader(inputFile);
		hfw = new HeapOutputFileWriter(outputFile);
	}
	
	public void createOperationList()
	{
		hfr.ReadFile();
		hfr.parseLine();
	}
	
	public void executeOperation()
	{
		for(int i=0;i<hfr.getOperations().size();i++)
		{
			if(hfr.getOperations().get(i).getOName().equalsIgnoreCase("size"))
			{
				System.out.println("Heap size: " + hfr.getOperations().get(i).getFstOperand());
				extenedHeap = new Heap(hfr.getOperations().get(i).getFstOperand());
			}
			else if(hfr.getOperations().get(i).getOName().equalsIgnoreCase("insert"))
			{
				System.out.println("inserted " + hfr.getOperations().get(i).getFstOperand()+ " with priority "
											+ hfr.getOperations().get(i).getScndOperand());
				
				extenedHeap.insert(hfr.getOperations().get(i).getFstOperand(), 
						hfr.getOperations().get(i).getScndOperand());		
			}
			
			else if(hfr.getOperations().get(i).getOName().equalsIgnoreCase("print"))
			{
				System.out.println("print extended heap");
				extenedHeap.printHeapDetail();
			}
			
			else if(hfr.getOperations().get(i).getOName().equalsIgnoreCase("find"))
			{
				//System.out.println(hfr.getOperations().get(i).getFstOperand()+ " is not in the extened heap");
				System.out.println("find "+ hfr.getOperations().get(i).getFstOperand()); 
				extenedHeap.find(hfr.getOperations().get(i).getFstOperand());
					
			}
			
			else if(hfr.getOperations().get(i).getOName().equalsIgnoreCase("deleteMin"))
			{
				//System.out.println("deleted");
				extenedHeap.deleteMin();
			}
			else if(hfr.getOperations().get(i).getOName().equalsIgnoreCase("change"))
			{
				System.out.println("!!!!!!!!!!!!!!!!!Changing!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				//System.out.println("changed priority of "+ hfr.getOperations().get(i).getFstOperand() + " with "+ hfr.getOperations().get(i).getScndOperand());
				extenedHeap.changePriority(hfr.getOperations().get(i).getFstOperand(), hfr.getOperations().get(i).getScndOperand());
			}
			else
			{
				System.out.println("Invalid operation");
			}
			//extenedHeap.printHandleItems();
		}
		
		extenedHeap.printOutputLines();
		
		//hfw.setLines(extenedHeap.getOutputLines());
		hfw.writeFile(extenedHeap.getOutputLines());
		
	}
	

}
