package haus;

public class Tier {
	
	private String name;
	private int alter;
	
	public Tier(String name, int alter) {
		this.name = name;
		this.alter = alter;
	}
	
	public int getAlter() {
		return this.alter;
	}
	
	public void setAlter(int alter) {
		this.alter = alter;
	}
	
	public String getName() {
		return this.name;
	}

}
