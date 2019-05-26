import java.util.*;
import java.sql.*;

public class RoomDAO {

	private Connection connect;

	public RoomDAO() throws Exception {

		// Our SQL connection info

		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "furkan";
		String password = "tedu";

		// Connect to the database

		connect = DriverManager.getConnection(dburl, user, password);

		System.out.println(
				"Connection statues: Successful." + "\nDatabase: " + dburl + "\nAccess granted to: Room Table.\n");

	}

	// **************************************************************************************
	// A method to add a record to the database

	public void addRecord(Room r) throws SQLException {

		// Initialize SQL statement

		PreparedStatement statement = null;

		try {
			// Prepare SQL statement

			statement = connect.prepareStatement("insert into room" + " (rNum, rType, rCPN)" + " values (?, ?, ?)");
			// ? i a placeholder
			// Set the parameters to the corresponding placeholder

			statement.setString(1, r.getrNum());
			statement.setString(2, r.getrType());
			statement.setString(3, r.getrCPN());

			// Execute SQL statement

			statement.executeUpdate();

		} finally {

			close(statement);
		}
	}

	// **************************************************************************************
	// A method to update a record in the database

	public void updateRecord(Room r) throws SQLException {

		// Initialize SQL statement

		PreparedStatement statement = null;

		try {

			// Prepare SQL statement

			statement = connect.prepareStatement("update room" + " set rNum=?, rType=?, rCPN=?" + " where rNum=?");
			// ? i a placeholder
			// Set the parameters to the corresponding placeholder

			statement.setString(1, r.getrNum());
			statement.setString(2, r.getrType());
			statement.setString(3, r.getrCPN());
			statement.setString(4, r.getrNum());

			// Execute SQL statement

			statement.executeUpdate();

		} finally {

			close(statement);
		}
	}
	//***************************************************************************************
	//A method to assign nurse to a room
	public void AssignNurse(Room r,String NurseID) throws SQLException {

		// Initialize SQL statement

		PreparedStatement statement = null;

		try {

			// Prepare SQL statement

			statement = connect.prepareStatement("update room" + 
			" set NURSE_ID=?" + 
			" where rNum=?");
			// ? i a placeholder
			// Set the parameters to the corresponding placeholder

			statement.setString(1,NurseID );
			statement.setString(2, r.getrNum());
			

			// Execute SQL statement

			statement.executeUpdate();

		} finally {

			close(statement);
		}
	}
	//**************************************************************************************
	// A method to Assign Patient to a room
	public void AssignPatient(Patient p,String  RoomNo) throws SQLException {

		// Initialize SQL statement

		PreparedStatement statement = null;

		try {

			// Prepare SQL statement

			statement = connect.prepareStatement("update room" + 
			" set PATIENT_ID=?" + 
			" where rNum=?");
			// ? i a placeholder
			// Set the parameters to the corresponding placeholder

			statement.setString(1,p.getpSSN() );
			statement.setString(2, RoomNo);
			

			// Execute SQL statement

			statement.executeUpdate();

		} finally {

			close(statement);
		}
	}
	
	// **************************************************************************************
	// A method to delete a record from the database

	public void deleteRecord(String rNum) throws SQLException {

		// Initialize SQL statement

		PreparedStatement statement = null;

		try {
			// Prepare SQL statement

			statement = connect.prepareStatement("delete from room where rNum=?"); // ? is a placeholder

			// Set a parameter to the corresponding placeholder

			statement.setString(1, rNum);

			// Execute SQL statement

			statement.executeUpdate();
		} finally {

			close(statement);
		}
	}

	// **************************************************************************************
	// A method to list all the records in the database

	public List<Room> getAllRecords() throws Exception {

		// Create an ArrayList to hold the records

		List<Room> list = new ArrayList<>();

		// Initialize SQL statement and a result set

		Statement statement = null;
		ResultSet result = null;

		try {

			// Prepare SQL statement in the result set

			statement = connect.createStatement();
			result = statement.executeQuery("select * from room order by rNum");

			// While we still have rows in the table

			while (result.next()) {

				// Take the corresponding row in the table and convert it to the record it holds

				Room temp = convertRowToRecord(result);

				// Then add it to the ArrayList

				list.add(temp);
			}

			// Return the list of records found and stored in the ArrayList

			return list;

		} finally {

			close(statement, result);
		}
	}

	// **************************************************************************************
	// A method to convert a row to the record it holds in the database

	private Room convertRowToRecord(ResultSet r) throws SQLException {

		String rNum = r.getString("rNum");
		String rType = r.getString("rType");
		String rCPN = r.getString("rCPN");
		String nurse_id = r.getString("nurse_id");
		String patient_id = r.getString("patient_id");

		Room temp = new Room(rNum, rType, rCPN, nurse_id,patient_id);

		return temp;
	}

	// **************************************************************************************
	// Search by room number

	public List<Room> searchNum(String rNum) throws Exception {

		List<Room> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			rNum += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("select * from room where rNum like ?  order by rNum");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, rNum);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {

				Room temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {

			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by room type

	public List<Room> searchType(String rType) throws Exception {

		List<Room> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			rType += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("select * from room where rType like ?  order by rNum");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, rType);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Room temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by room cost/night

	public List<Room> searchCPN(String rCPN) throws Exception {

		List<Room> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			rCPN += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("select * from room where rCPN like ?  order by rNum");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, rCPN);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Room temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}

	// **************************************************************************************

	private static void close(Connection connect, Statement statement, ResultSet result) throws SQLException {

		if (result != null) {
			result.close();
		}

		if (statement != null) {
			statement.close();
		}

		if (connect != null) {
			connect.close();
		}
	}

	private void close(Statement statement, ResultSet result) throws SQLException {

		close(null, statement, result);

	}

	private void close(PreparedStatement statement) throws SQLException {
		close(null, statement, null);
	}

}
