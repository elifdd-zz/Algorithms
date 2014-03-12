/*
 * Elif Dede
 * CS575
 * Project 1 - extended heap
 * */

import java.util.Vector;


public class Heap {
	
	private Vector<HeapItem> items;
	private Vector<HandleItem> handleNodes;
	private int heapSize;
	private int cSize;
	
	private Vector<String> outputLines;
	
	public Vector<String> getOutputLines() {
		return outputLines;
	}

	public void setOutputLines(Vector<String> outputLines) {
		this.outputLines = outputLines;
	}

	public Heap(int size)
	{
		heapSize = size;
		items = new Vector<HeapItem>(heapSize);
		handleNodes = new Vector<HandleItem>(heapSize+1);
		cSize=0;
		outputLines = new Vector<String>();
	}
	
	public boolean insert(int name, int priority)
	{
		outputLines.add("insert "+ name + " "+ priority);                           //add output list
		if(find(name)!=-1)
		{
			System.out.println(name + " is already in the extened heap");
			outputLines.add(name + " is already in the extened heap");     // add output list
			
			return false;
		}
		
		HeapItem item = new HeapItem();
		item.setName(name);
		item.setPriority(priority);
		
		cSize = items.size();
			
		if(cSize==heapSize)
		{
			System.out.println("Heap is full");
			outputLines.add("the extened heap is full");                           //add output list
			return false;
		}
		
		else
		{
			items.add(item);		
			cSize = items.size();
			items.lastElement().setHeapArrayIndex(cSize-1);
			//items.add(item);		
			//cSize = items.size();
			System.out.println("Current size: " +cSize);
			int index = siftUp(cSize-1);
			System.out.println("Index: " +index);
			
			outputLines.add("inserted " +name + " with priority " + priority);      ////add output list
			
			printHeap();
			return true;
		}		
		
	}
	
	public int siftUp(int index)
	{
		
		System.out.println("Index2: " +index);
		int parent = (index-1)/2;
		
		System.out.println("parent: " +parent);
		
		HeapItem bottom = items.get(index);
		System.out.println("Bottom: " +bottom.getName() +", "+  bottom.getPriority());
		
		System.out.println("Parent priority: " + items.get(parent).getPriority());
		System.out.println("Bottom priority: " + bottom.getPriority());
		
		while(index>0 && items.get(parent).getPriority() > bottom.getPriority())
		{
			System.out.println("in while");
			items.set(index, items.get(parent));
			
			//System.out.println("Node :" +items.get(index).getName()+ " index :" + index);
			
			setHandleNode(items.get(index).getName(), index);
			index = parent;
			parent = (parent-1) / 2;
			//setHandleNode(items.get(parent).getName(), index);
		}
		
		items.set(index,bottom);
		System.out.println("Node :" +items.get(index).getName() + " index :" + index);
		setHandleNode(items.get(index).getName(), index);
		//setHandleNode(items.get(index).getName(), index);
		
		return index;
	}
	
	public int setHandleNode(int itemName, int index)
	{
	
		System.out.println("params: "+ itemName+ " "+ index);

		for(int i=0; i<heapSize+1; i++)
		{	
			if(handleNodes.size() >i )
			{
				if(handleNodes.get(i).getItemName()==itemName)
				{
				handleNodes.get(i).setIndex(index); 
				return 1;
				}
			}
			
			if(itemName == i)
			{
				System.out.println("params2: " +itemName);
				HandleItem handle = new HandleItem();
				handle.setItemName(i);
				handle.setIndex(index);
				
					handleNodes.add(handle);

				printHandleNode(handle);
				
		//		System.out.println("Handle node name: " +handleNodes.get(i-1).getItemName() +
		//							" index: "+ handleNodes.get(i-1).getIndex());
				
				
			}
		}
		return 2;
		
	}
	public void printHandleNode(HandleItem item)
	{
		//System.out.println("Printing handle");
		
		System.out.println("Name: " + item.getItemName());
		System.out.println("Index: " + item.getIndex());
	//	System.out.println("2nd: " + o.getScndOperand());
	}

	public void printHandleItems()
	{
		for(int i =0; i<handleNodes.size();i++)
		{
			printHandleNode(handleNodes.get(i));
			
		}
	}
	
	public int deleteMin()
	{
		outputLines.add("deleteMin");             //add output
		System.out.println("*********************delete***********************");
		int last=0;
		if(items.size()==0)
		{
			System.out.println("delete failed since the extened heap is empty");
			outputLines.add("delete failed since the extened heap is empty");     //add output
			return -1;
		}
		HeapItem root = items.get(0);
		for(int i=0;i<handleNodes.size()-1;i++)
		{ 
			last=Math.max(handleNodes.get(i).getIndex(),handleNodes.get(i+1).getIndex());
		}
		
		System.out.println("Last index: " + last);
		
		items.set(0, items.get(last));
		items.remove(items.size()-1);
		printHeap();
	
		siftDown(0);
		printHeap();
		
		System.out.println("+++++++++updating handle+++++++++++++");
		upDateHandle();
		
		outputLines.add("deleted "+ root.getName() + " with the priority " + root.getPriority() );
		return root.getName();
	}
	
	public void printHeapNode(HeapItem item)
	{
		System.out.println("Heap Node Name: " + item.getName());
		System.out.println("Heap Node Priority: " + item.getPriority());
	//	System.out.println("2nd: " + o.getScndOperand());
	}
	
	public void siftDown(int index)
	{
		int smallerChild;
		HeapItem top = items.get(index);
		while(index < (items.size()-1)/2)
		{
			int leftChild = 2*index+1;
			int rightChild = leftChild+1;
			System.out.println("Left Child----------->   " +leftChild);
			System.out.println("Right Child---------->   " +rightChild);
			
			if(rightChild<items.size() && 
					items.get(leftChild).getPriority() < items.get(rightChild).getPriority())
				smallerChild = leftChild;
		
			else
				smallerChild = rightChild;
			
			System.out.println("Smaller Child---------->    " + smallerChild);
			
			if(top.getPriority()<items.get(smallerChild).getPriority())
				break;
			
			items.set(index, items.get(smallerChild));
			//setHandleNode(items.get(index).getName(), index);
			index = smallerChild;
			
			items.set(index, top);
			//setHandleNode(items.get(index).getName(), index);
		}
	}
	
	public void printHeap()
	{
		for(int i =0; i<items.size();i++)
		{
			printHeapNode(items.get(i));
			
		}
	}
	

	public void upDateHandleNode(HeapItem item)
	{	
		HandleItem h = new HandleItem();
		
		int index = items.indexOf(item);
		h.setIndex(index);
		h.setItemName(item.getName());
		
		handleNodes.add(h);
	}
	
	public void upDateHandle()
	{
		handleNodes.clear();
		for(int i=0;i<items.size(); i++)
		{
			upDateHandleNode(items.get(i));
		}
		
		printHandleItems();
	}
	
	public int find(int itemName)
	{
		outputLines.add("find "+ itemName);           //add output
		System.out.println("******************find***********************");
		int priority = -1;
		int index = -1;
		
		for(int i=0; i<handleNodes.size(); i++)
		{
			if(handleNodes.get(i).getItemName() == itemName)
			{
				index = handleNodes.get(i).getIndex();
			}
		}
		
		if(index<0)
		{
			System.out.println(itemName + " is not in the extended heap");
			outputLines.add(itemName + " is not in the extended heap");                      //add output
		}
		else
		{
			priority = items.get(index).getPriority();
			System.out.println(itemName + " has the priority " + priority);
			outputLines.add(itemName + " has the priority " + priority);                        //add output 
		}
		
		
		return index;
	}
	
	public int changePriority(int name, int newPriority)
	{
		System.out.println("*****************Change priority*************");
		outputLines.add("change priority "+ name + " " + newPriority);
		int index = this.find(name);
		if(index==-1)
			return -1;
		
		int oldValue = items.get(index).getPriority();
		
		System.out.println("OLD PRIORITY:          "+  oldValue);
		
		items.get(index).setPriority(newPriority);
		
		System.out.println("NEW PRIORITY:          "+  items.get(index).getPriority());
		
		outputLines.add("changed priority of " +name+ " to " + newPriority);
		if(oldValue>newPriority)
			this.siftUp(index);
		else if(oldValue<newPriority)
			this.siftDown(index);
		
		this.printHeap();
		this.upDateHandle();
		
		return 1;
		//this.printHandleItems();		
		
	}

	public void printHeapDetail()
	{
		outputLines.add("print extended heap");
		for(int i = 0; i<items.size();i++)
		{
			System.out.println("node " + i +" = " + items.get(i).getName() + " " +items.get(i).getPriority());
			outputLines.add("node " + i +" = " + items.get(i).getName() + " " +items.get(i).getPriority());
		}
	}
	
	public void printOutputLines()
	{
		System.out.println("**********printing output file contents**********");
		for(int i=0;i<outputLines.size();i++)
			System.out.println(outputLines.get(i));
	}

}