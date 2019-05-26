import java.util.*;
import java.sql.*;

public class PatientDAO {

	private Connection connect;

	public PatientDAO() throws Exception {

		// Our SQL connection info

		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "furkan";
		String password = "tedu";

		// Connect to the database

		connect = DriverManager.getConnection(dburl, user, password);

		System.out.println(
				"Connection statues: Successful." + "\nDatabase: " + dburl + "\nAccess granted to: Patient Table.\n");

	}

	// **************************************************************************************
	// A method to add a record to the database

	public void addRecord(Patient patient) throws SQLException {

		// Initialize SQL statement

		PreparedStatement statement = null;

		try {
			// Prepare SQL statement

			statement = connect.prepareStatement("insert into patient"
					+ " (pSSN, pFirstName, pLastName, pSex, pPhoneNumber, pAddress)" + " values (?, ?, ?, ?, ?, ?)");
			// ? i a placeholder
			// Set the parameters to the corresponding placeholder
			
			statement.setString(1, patient.getpSSN());
			statement.setString(2, patient.getpFirstName());
			statement.setString(3, patient.getpLastName());
			statement.setString(4, patient.getpSex());
			statement.setString(5, patient.getpPhoneNumber());
			statement.setString(6, patient.getpAddress());

			// Execute SQL statement

			statement.executeUpdate();

		} finally {

			close(statement);
		}
	}

	// **************************************************************************************
	// A method to update a record in the database

	public void updateRecord(Patient patient) throws SQLException {

		// Initialize SQL statement

		PreparedStatement statement = null;

		try {

			// Prepare SQL statement

			statement = connect.prepareStatement("update patient"
					+ " set pSSN=?, pFirstName=?, pLastName=?, pSex=?, pPhoneNumber=?, pAddress=?" + " where pSSN=?");
			// ? i a placeholder
			// Set the parameters to the corresponding placeholder

			statement.setString(1, patient.getpSSN());
			statement.setString(2, patient.getpFirstName());
			statement.setString(3, patient.getpLastName());
			statement.setString(4, patient.getpSex());
			statement.setString(5, patient.getpPhoneNumber());
			statement.setString(6, patient.getpAddress());
			statement.setString(7, patient.getpSSN());

			// Execute SQL statement

			statement.executeUpdate();

		} finally {

			close(statement);
		}
	}
	
	

	// **************************************************************************************
	// A method to delete a record from the database

	public void deleteRecord(String SSN) throws SQLException {

		// Initialize SQL statement

		PreparedStatement statement = null;

		try {
			// Prepare SQL statement

			statement = connect.prepareStatement("delete from patient where pSSN=?"); // ? is a placeholder

			// Set a parameter to the corresponding placeholder

			statement.setString(1, SSN);

			// Execute SQL statement

			statement.executeUpdate();
		} finally {

			close(statement);
		}
	}

	// **************************************************************************************
	// A method to list all the records in the database

	public List<Patient> getAllRecords() throws Exception {

		// Create an ArrayList to hold the records

		List<Patient> list = new ArrayList<>();

		// Initialize SQL statement and a result set

		Statement statement = null;
		ResultSet result = null;

		try {

			// Prepare SQL statement in the result set

			statement = connect.createStatement();
			result = statement.executeQuery("select * from patient order by pFirstName");

			// While we still have rows in the table

			while (result.next()) {

				// Take the corresponding row in the table and convert it to the record it holds

				Patient temp = convertRowToRecord(result);

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

	private Patient convertRowToRecord(ResultSet result) throws SQLException {

		String pSSN = result.getString("pSSN");
		String pFirstName = result.getString("pFirstName");
		String pLastName = result.getString("pLastName");
		String pSex = result.getString("pSex");
		String pPhoneNumber = result.getString("pPhoneNumber");
		String pAddress = result.getString("pAddress");

		Patient temp = new Patient(pSSN, pFirstName, pLastName, pSex, pPhoneNumber, pAddress);

		return temp;
	}

	// **************************************************************************************
	// Search by ID

	public List<Patient> searchSSN(String SSN) throws Exception {

		List<Patient> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			SSN += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("select * from patient where pSSN like ?  order by pFirstName");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, SSN);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {

				Patient temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {

			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by first name

	public List<Patient> searchFN(String firstName) throws Exception {

		List<Patient> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			firstName += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("select * from patient where pFirstName like ?  order by pFirstName");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, firstName);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Patient temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by last name

	public List<Patient> searchLN(String lastName) throws Exception {

		List<Patient> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			lastName += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("select * from patient where pLastName like ?  order by pFirstName");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, lastName);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Patient temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by sex

	public List<Patient> searchS(String sex) throws Exception {

		List<Patient> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			sex += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("select * from patient where pSex like ?  order by pFirstName");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, sex);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Patient temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by phone number

	public List<Patient> searchPN(String phoneNumber) throws Exception {

		List<Patient> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			phoneNumber += "%";

			// Prepare SQL statement

			statement = connect
					.prepareStatement("select * from patient where pPhoneNumber like ?  order by pFirstName");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, phoneNumber);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Patient temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by address

	public List<Patient> searchA(String address) throws Exception {

		List<Patient> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			address += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("select * from patient where pAddress like ?  order by pFirstName");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, address);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Patient temp = convertRowToRecord(result);
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
