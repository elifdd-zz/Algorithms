
public class HandleItem {

	private int itemName;
	private int index;
	
	public int getItemName() {
		return itemName;
	}
	public void setItemName(int place) {
		this.itemName = place;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public HandleItem()
	{
		itemName = -1;
		index = -1;	
	}
}
