
public class HeapItem {
	
	private int name;
	private int priority;
	private int heapArrayIndex;
	private int handleArrayIndex;
	
	
	public int getHeapArrayIndex() {
		return heapArrayIndex;
	}
	public void setHeapArrayIndex(int heapArrayIndex) {
		this.heapArrayIndex = heapArrayIndex;
	}
	public int getHandleArrayIndex() {
		return handleArrayIndex;
	}
	public void setHandleArrayIndex(int handleArrayIndex) {
		this.handleArrayIndex = handleArrayIndex;
	}
	public void setName(int name) {
		this.name = name;
	}
	public int getName() {
		return name;
	}	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getPriority() {
		return priority;
	}
	
	public HeapItem()
	{
		name = -1;
		priority = -1;
		heapArrayIndex = -1;
		handleArrayIndex = -1;
		
	}
		
}
