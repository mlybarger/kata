package org.montyhall.kata;

public class Door {
	
	private boolean prize = false;
	private String name = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPrize() {
		return prize;
	}

	public void setPrize(boolean prize) {
		this.prize = prize;
	}

}
