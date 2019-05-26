import java.util.*;
import java.sql.*;

public class DoctorDAO {

	private Connection connect;

	public DoctorDAO() throws Exception {

		// Our SQL connection info

		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "furkan";
		String password = "tedu";
		// Connect to the database

		connect = DriverManager.getConnection(dburl, user, password);

		System.out.println(
				"Connection statues: Successful." + "\nDatabase: " + dburl + "\nAccess granted to: Doctor Table.\n");

	}

	// **************************************************************************************
	// A method to add a record to the database

	public void addRecord(Doctor doctor) throws SQLException {

		// Initialize SQL statement

		PreparedStatement statement = null;

		try {
			// Prepare SQL statement

			statement = connect.prepareStatement("insert into DOCTOR"
					+ " (docID, docFirstName, docLastName, docSex, docPhoneNumber, docAddress, docDepartment)"
					+ " values (?, ?, ?, ?, ?, ?, ?)"); // ? is a placeholder

			// Set the parameters to the corresponding placeholder

			statement.setString(1, doctor.getDocID());
			statement.setString(2, doctor.getDocFirstName());
			statement.setString(3, doctor.getDocLastName());
			statement.setString(4, doctor.getDocSex());
			statement.setString(5, doctor.getDocPhoneNumber());
			statement.setString(6, doctor.getDocAddress());
			statement.setString(7, doctor.getDocDepartment());

			// Execute SQL statement

			statement.executeUpdate();

		} finally {

			close(statement);
		}
	}

	// **************************************************************************************
	// A method to update a record in the database

	public void updateRecord(Doctor doctor) throws SQLException {

		// Initialize SQL statement

		PreparedStatement statement = null;

		try {

			// Prepare SQL statement

			statement = connect.prepareStatement("update doctor"
					+ " set docID=?, docFirstName=?, docLastName=?, docSex=?, docPhoneNumber=?, docAddress=?, docDepartment=?"
					+ " where docID=?"); // ? is a placeholder

			// Set the parameters to the corresponding placeholder

			statement.setString(1, doctor.getDocID());
			statement.setString(2, doctor.getDocFirstName());
			statement.setString(3, doctor.getDocLastName());
			statement.setString(4, doctor.getDocSex());
			statement.setString(5, doctor.getDocPhoneNumber());
			statement.setString(6, doctor.getDocAddress());
			statement.setString(7, doctor.getDocDepartment());
			statement.setString(8, doctor.getDocID());


			// Execute SQL statement

			statement.executeUpdate();

		} finally {

			close(statement);
		}
	}
	//Assign doctor to patient
	public void AssingPatient(Patient patient , String DoctorID) throws SQLException {

		// Initialize SQL statement

		PreparedStatement statement = null;

		try {

			// Prepare SQL statement

			statement = connect.prepareStatement("update doctor"
					+ " set pID=?"
					+ " where docID=?"); // ? is a placeholder

			// Set the parameters to the corresponding placeholder

			statement.setString(1, patient.getpSSN());
			statement.setString(2, DoctorID);
			
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

			statement = connect.prepareStatement("delete from doctor where docID=?"); // ? is a placeholder

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

	public List<Doctor> getAllDoctors() throws Exception {

		// Create an ArrayList to hold the records

		List<Doctor> list = new ArrayList<>();

		// Initialize SQL statement and a result set

		Statement statement = null;
		ResultSet result = null;

		try {

			// Prepare SQL statement in the result set

			statement = connect.createStatement();
			result = statement.executeQuery("select * from doctor order by docFirstName");

			// While we still have rows in the table

			while (result.next()) {

				// Take the corresponding row in the table and convert it to the record it holds

				Doctor temp = convertRowToRecord(result);

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

	private Doctor convertRowToRecord(ResultSet result) throws SQLException {

		String docID = result.getString("docID");
		String docFirstName = result.getString("docFirstName");
		String docLastName = result.getString("docLastName");
		String docSex = result.getString("docSex");
		String docPhoneNumber = result.getString("docPhoneNumber");
		String docAddress = result.getString("docAddress");
		String docDepartment = result.getString("docDepartment");
		String pID = result.getString("pID");

		Doctor temp = new Doctor(docID, docFirstName, docLastName, docSex, docPhoneNumber, docAddress, docDepartment,pID);

		return temp;
	}

	// **************************************************************************************
	// Search by ID

	public List<Doctor> searchID(String docID) throws Exception {

		List<Doctor> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			docID += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("select * from doctor where docID like ?  order by docFirstName");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, docID);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {

				Doctor temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {

			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by first name

	public List<Doctor> searchFN(String docFirstName) throws Exception {

		List<Doctor> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			docFirstName += "%";

			// Prepare SQL statement

			statement = connect
					.prepareStatement("select * from doctor where docFirstName like ?  order by docFirstName");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, docFirstName);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Doctor temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by last name

	public List<Doctor> searchLN(String docLastName) throws Exception {

		List<Doctor> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			docLastName += "%";

			// Prepare SQL statement

			statement = connect
					.prepareStatement("select * from doctor where docLastName like ?  order by docFirstName");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, docLastName);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Doctor temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by sex

	public List<Doctor> searchS(String docSex) throws Exception {

		List<Doctor> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			docSex += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("select * from doctor where docSex like ?  order by docFirstName");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, docSex);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Doctor temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by phone number

	public List<Doctor> searchPN(String docPhoneNumber) throws Exception {

		List<Doctor> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			docPhoneNumber += "%";

			// Prepare SQL statement

			statement = connect
					.prepareStatement("select * from doctor where docPhoneNumber like ?  order by docFirstName");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, docPhoneNumber);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Doctor temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by address

	public List<Doctor> searchA(String docAddress) throws Exception {

		List<Doctor> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			docAddress += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("select * from doctor where docAddress like ?  order by docFirstName");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, docAddress);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Doctor temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by department

	public List<Doctor> searchD(String docDepartment) throws Exception {

		List<Doctor> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			docDepartment += "%";

			// Prepare SQL statement

			statement = connect
					.prepareStatement("select * from doctor where docDepartment like ?  order by docFirstName");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, docDepartment);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Doctor temp = convertRowToRecord(result);
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
