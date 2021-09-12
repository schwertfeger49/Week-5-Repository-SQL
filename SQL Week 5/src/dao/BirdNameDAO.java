package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.BirdName;

public class BirdNameDAO {
	
	private Connection connection;
	private final String GET_BIRDNAMES_BY_BIRDTYPE_ID_QUERY = "SELECT * FROM birdname WHERE typeid = ?";
	private final String DELETE_BIRDNAMES_BY_BIRDTYPE_ID_QUERY = "DELETE FROM birdname WHERE typeid = ?";
	private final String CREATE_NEW_BIRDNAME_QUERY = "INSERT INTO birdname(name, typeid) VALUES(?, ?)";
	private final String DELETE_BIRDNAME_BY_ID_QUERY = "DELETE FROM birdname WHERE id = ?";
	
	public BirdNameDAO () {
		connection = DBConnection.getConnection();
	}

	public List<BirdName> getBirdNamesByBirdTypeId(int typeid) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_BIRDNAMES_BY_BIRDTYPE_ID_QUERY);
		ps.setInt(1, typeid);
		ResultSet rs = ps.executeQuery();
		List<BirdName> birdNames = new ArrayList<BirdName>();
		
		while (rs.next()) {
			birdNames.add(new BirdName(rs.getInt(1), rs.getString(2)));
		}
		return birdNames;
	}
	
	public void createBirdName(String name, int typeid) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_BIRDNAME_QUERY);
		ps.setString(1, name);
		ps.setInt(2, typeid);
		ps.executeUpdate();
	}
	
	public void deleteBirdNamesById(int birdTypeId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_BIRDNAMES_BY_BIRDTYPE_ID_QUERY);
		ps.setInt(1, birdTypeId);
		ps.executeUpdate();
	}
	
	public void deleteBirdNameById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_BIRDNAME_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

}
