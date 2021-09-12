package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.BirdType;

public class BirdTypeDAO {
	
	private Connection connection;
	private BirdNameDAO birdNameDAO;
	private final String GET_BIRDTYPES_QUERY = "SELECT * FROM birdtype";
	private final String GET_BIRDTYPES_BY_ID_QUERY = "SELECT * FROM birdtype WHERE id = ?";
	private final String CREATE_NEW_BIRDTYPE_QUERY = "INSERT INTO birdtype(type) VALUES(?)";
	private final String DELETE_BIRDTYPE_BY_ID_QUERY = "DELETE FROM birdtype WHERE id = ?";
	
	public BirdTypeDAO() {
		connection = DBConnection.getConnection();
		birdNameDAO = new BirdNameDAO();
	}
	
	public List<BirdType> getBirdTypes() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_BIRDTYPES_QUERY).executeQuery();
		List<BirdType> birdTypes = new ArrayList<BirdType>();
		
		while (rs.next()) {
			birdTypes.add(populateBirdType(rs.getInt(1), rs.getString(2)));
		}
		
		return birdTypes;
	}
	
	public BirdType getBirdTypeByID(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_BIRDTYPES_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateBirdType(rs.getInt(1), rs.getString(2));
		
	}
	
	public void createBirdType(String birdType) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_BIRDTYPE_QUERY);
		ps.setString(1, birdType);
		ps.executeUpdate();
	}
	
	public void deleteBirdType(int id) throws SQLException {
		birdNameDAO.deleteBirdNamesById(id);
		PreparedStatement ps = connection.prepareStatement(DELETE_BIRDTYPE_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	private BirdType populateBirdType(int id, String type) throws SQLException {
		return new BirdType(id, type, birdNameDAO.getBirdNamesByBirdTypeId(id));
	}

}
