package entity;

public class BirdName {

	private int birdNameID;
	private String birdName;
	
	public BirdName(int birdNameID, String birdName) {
		this.setBirdNameID(birdNameID);
		this.setBirdName(birdName);
	}

	public int getBirdNameID() {
		return birdNameID;
	}

	public void setBirdNameID(int birdNameID) {
		this.birdNameID = birdNameID;
	}

	public String getBirdName() {
		return birdName;
	}

	public void setBirdName(String birdName) {
		this.birdName = birdName;
	}
}
