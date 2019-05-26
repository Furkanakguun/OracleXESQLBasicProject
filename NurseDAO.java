import java.util.*;
import java.sql.*;

public class NurseDAO {

	private Connection connect;

	public NurseDAO() throws Exception {

		// Our SQL connection info

		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "furkan";
		String password = "tedu";

		// Connect to the database

		connect = DriverManager.getConnection(dburl, user, password);

		System.out.println(
				"Connection statues: Successful." + "\nDatabase: " + dburl + "\nAccess granted to: Nurse Table.\n");

	}

	// **************************************************************************************
	// A method to add a record to the database

	public void addRecord(Nurse nurse) throws SQLException {

		// Initialize SQL statement

		PreparedStatement statement = null;

		try {
			// Prepare SQL statement

			statement = connect.prepareStatement("insert into nurse"
					+ " (nurID, nurFirstName, nurLastName, nurSex, nurPhoneNumber, nurAddress, nurDepartment)"
					+ " values (?, ?, ?, ?, ?, ?, ?)"); // ? is a placeholder

			// Set the parameters to the corresponding placeholder

			statement.setString(1, nurse.getNurID());
			statement.setString(2, nurse.getNurFirstName());
			statement.setString(3, nurse.getNurLastName());
			statement.setString(4, nurse.getNurSex());
			statement.setString(5, nurse.getNurPhoneNumber());
			statement.setString(6, nurse.getNurAddress());
			statement.setString(7, nurse.getNurDepartment());

			// Execute SQL statement

			statement.executeUpdate();

		} finally {

			close(statement);
		}
	}

	// **************************************************************************************
	// A method to update a record in the database

	public void updateRecord(Nurse nurse) throws SQLException {

		// Initialize SQL statement

		PreparedStatement statement = null;

		try {

			// Prepare SQL statement

			statement = connect.prepareStatement("update nurse"
					+ " set nurID=?, nurFirstName=?, nurLastName=?, nurSex=?, nurPhoneNumber=?, nurAddress=?, nurDepartment=?"
					+ " where nurID=?"); // ? is a placeholder

			// Set the parameters to the corresponding placeholder

			statement.setString(1, nurse.getNurID());
			statement.setString(2, nurse.getNurFirstName());
			statement.setString(3, nurse.getNurLastName());
			statement.setString(4, nurse.getNurSex());
			statement.setString(5, nurse.getNurPhoneNumber());
			statement.setString(6, nurse.getNurAddress());
			statement.setString(7, nurse.getNurDepartment());
			statement.setString(8, nurse.getNurID());

			// Execute SQL statement

			statement.executeUpdate();

		} finally {

			close(statement);
		}
	}

	// **************************************************************************************
	// A method to delete a record from the database

	public void deleteRecord(String ID) throws SQLException {

		// Initialize SQL statement

		PreparedStatement statement = null;

		try {
			// Prepare SQL statement

			statement = connect.prepareStatement("delete from nurse where nurID=?"); // ? is a placeholder

			// Set a parameter to the corresponding placeholder

			statement.setString(1, ID);

			// Execute SQL statement

			statement.executeUpdate();
		} finally {

			close(statement);
		}
	}

	// **************************************************************************************
	// A method to list all the records in the database

	public List<Nurse> getAllRecords() throws Exception {

		// Create an ArrayList to hold the records

		List<Nurse> list = new ArrayList<>();

		// Initialize SQL statement and a result set

		Statement statement = null;
		ResultSet result = null;

		try {

			// Prepare SQL statement in the result set

			statement = connect.createStatement();
			result = statement.executeQuery("select * from nurse order by nurFirstName");

			// While we still have rows in the table

			while (result.next()) {

				// Take the corresponding row in the table and convert it to the record it holds

				Nurse temp = convertRowToRecord(result);

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

	private Nurse convertRowToRecord(ResultSet result) throws SQLException {

		String nurID = result.getString("nurID");
		String nurFirstName = result.getString("nurFirstName");
		String nurLastName = result.getString("nurLastName");
		String nurSex = result.getString("nurSex");
		String nurPhoneNumber = result.getString("nurPhoneNumber");
		String nurAddress = result.getString("nurAddress");
		String nurDepartment = result.getString("nurDepartment");

		Nurse temp = new Nurse(nurID, nurFirstName, nurLastName, nurSex, nurPhoneNumber, nurAddress, nurDepartment);

		return temp;
	}

	// **************************************************************************************
	// Search by ID

	public List<Nurse> searchID(String ID) throws Exception {

		List<Nurse> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			ID += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("select * from nurse where nurID like ?  order by nurFirstName");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, ID);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {

				Nurse temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {

			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by first name

	public List<Nurse> searchFN(String firstName) throws Exception {

		List<Nurse> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			firstName += "%";

			// Prepare SQL statement

			statement = connect
					.prepareStatement("select * from nurse where nurFirstName like ?  order by nurFirstName");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, firstName);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Nurse temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by last name

	public List<Nurse> searchLN(String lastName) throws Exception {

		List<Nurse> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			lastName += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("select * from nurse where nurLastName like ?  order by nurFirstName");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, lastName);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Nurse temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by sex

	public List<Nurse> searchS(String sex) throws Exception {

		List<Nurse> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			sex += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("select * from nurse where nurSex like ?  order by nurFirstName");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, sex);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Nurse temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by phone number

	public List<Nurse> searchPN(String phoneNumber) throws Exception {

		List<Nurse> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			phoneNumber += "%";

			// Prepare SQL statement

			statement = connect
					.prepareStatement("select * from nurse where nurPhoneNumber like ?  order by nurFirstName");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, phoneNumber);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Nurse temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by address

	public List<Nurse> searchA(String address) throws Exception {

		List<Nurse> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			address += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("select * from nurse where nurAddress like ?  order by nurFirstName");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, address);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Nurse temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by department

	public List<Nurse> searchD(String department) throws Exception {

		List<Nurse> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			department += "%";

			// Prepare SQL statement

			statement = connect
					.prepareStatement("select * from nurse where docDepartment like ?  order by nurFirstName");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, department);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Nurse temp = convertRowToRecord(result);
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
