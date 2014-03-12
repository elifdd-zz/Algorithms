/*
 * Elif Dede
 * CS575
 * Project 1 - extended heap
 * */
public class Operation {
	private String oName;
	private int fstOperand;
	private int scndOperand;
	
	public Operation()
	{
		oName = null;
		fstOperand = -1;
		scndOperand = -1;
	}

	public String getOName() {
		return oName;
	}

	public void setOName(String name) {
		oName = name;
	}

	public int getFstOperand() {
		return fstOperand;
	}

	public void setFstOperand(int fstOperand) {
		this.fstOperand = fstOperand;
	}

	public int getScndOperand() {
		return scndOperand;
	}

	public void setScndOperand(int scndOperand) {
		this.scndOperand = scndOperand;
	}
	

}
