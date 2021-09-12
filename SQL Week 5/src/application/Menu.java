package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.BirdNameDAO;
import dao.BirdTypeDAO;
import entity.BirdName;
import entity.BirdType;

public class Menu {
	
	private BirdTypeDAO birdTypeDAO = new BirdTypeDAO();
	private BirdNameDAO birdNameDAO = new BirdNameDAO();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Bird Types",
			"Display a Bird Type",
			"Create a Bird Type",
			"Delete a Bird Type",
			"Create a Bird Name",
			"Delete a Bird Name"
			);
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			try {
				if (selection.equals("1")) {
					displayBirdTypes();
				} else if (selection.equals("2")) {
					displayBirdType();
				} else if (selection.equals("3")) {
					createBirdType();
				} else if (selection.equals("4")) {
					deleteBirdType();
				} else if (selection.equals("5")) {
					createBirdName();
				} else if (selection.equals("6")) {
					deleteBirdName();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			System.out.println("Press enter to continue...");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}

	private void printMenu() {
		System.out.println("Select an Option:\n------------------------------");
		for(int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displayBirdTypes() throws SQLException {
		List<BirdType> birdTypes = birdTypeDAO.getBirdTypes();
		for (BirdType birdType : birdTypes) {
			System.out.println(birdType.getBirdTypeID() + ": " + birdType.getBirdType());
		}
	}
	
	private void displayBirdType() throws SQLException {
		System.out.print("Enter BirdType id: ");
		int id = Integer.parseInt(scanner.nextLine());
		BirdType birdType = birdTypeDAO.getBirdTypeByID(id);
		System.out.println(birdType.getBirdTypeID() + ": " + birdType.getBirdType());
		for (BirdName birdName : birdType.getBirdNames()) {
			System.out.println("\tBirdTypeID: " + birdName.getBirdNameID() + " - Bird Name: " + birdName.getBirdName());
			
		}
	}
	
	private void createBirdType() throws SQLException {
		System.out.print("Enter new Bird Type:");
		String birdType = scanner.nextLine();
		birdTypeDAO.createBirdType(birdType);
	}
	
	private void deleteBirdType() throws SQLException {
		System.out.print("Enter Bird Type ID to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		birdTypeDAO.deleteBirdType(id);
	}
	
	private void createBirdName() throws SQLException {
		System.out.print("Enter new Bird Name:");
		String name = scanner.nextLine();
		System.out.print("Enter Bird Type ID for new Bird Name:");
		int typeid = Integer.parseInt(scanner.nextLine());
		birdNameDAO.createBirdName(name, typeid);
	}
	
	private void deleteBirdName() throws SQLException {
		System.out.println("Enter Bird Name to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		birdNameDAO.deleteBirdNameById(id);
	}
	
}
