package entity;

import java.util.List;

public class BirdType {

	private int birdTypeID;
	private String birdType;
	private List<BirdName> birdNames;
	
	public BirdType(int birdTypeID, String birdType, List<BirdName> birdNames) {
		this.setBirdTypeID(birdTypeID);
		this.setBirdType(birdType);
		this.setBirdNames(birdNames);
	}

	public int getBirdTypeID() {
		return birdTypeID;
	}

	public void setBirdTypeID(int birdTypeID) {
		this.birdTypeID = birdTypeID;
	}

	public String getBirdType() {
		return birdType;
	}

	public void setBirdType(String birdType) {
		this.birdType = birdType;
	}

	public List<BirdName> getBirdNames() {
		return birdNames;
	}

	public void setBirdNames(List<BirdName> birdNames) {
		this.birdNames = birdNames;
	}
}
