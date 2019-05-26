import java.util.*;
import java.sql.*;

public class RecordsDAO {

	private Connection connect;

	public RecordsDAO() throws Exception {

		// Our SQL connection info

		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "furkan";
		String password = "tedu";

		// Connect to the database

		connect = DriverManager.getConnection(dburl, user, password);

		System.out.println(
				"Connection statues: Successful." + "\nDatabase: " + dburl + "\nAccess granted to: Bills Table.\n");

	}

	// **************************************************************************************
	// A method to list all the records in the database

	public  List<Records> getAllRecords() throws Exception {

		// Create an ArrayList to hold the records

		List<Records> list = new ArrayList<>();

		// Initialize SQL statement and a result set

		Statement statement = null;
		ResultSet result = null;

		try {

			// Prepare SQL statement in the result set

			statement = connect.createStatement();
			result = statement.executeQuery("SELECT p.PSSN , d.DOCID  ,n.NURID,r.RNUM, b.BNUM   \r\n" + 
					"FROM PATIENT p , DOCTOR d , BILL b, NURSE n, ROOM r\r\n" + 
					"WHERE p.pSSN = d.PID and p.PSSN = b.PID and r.PATIENT_ID = p.PSSN and r.NURSE_ID = n.NURID");

			// While we still have rows in the table

			while (result.next()) {

				// Take the corresponding row in the table and convert it to the record it holds

				Records temp = convertRowToRecord(result);

				// Then add it to the ArrayList

				list.add(temp);
			}

			// Return the list of records found and stored in the ArrayList

			return list;

		} finally {

			close(statement, result);
		}
	}
	public List<Records> searchpID(String pID) throws Exception {

		List<Records> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			pID += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("SELECT p.PSSN , d.DOCID  ,n.NURID,r.RNUM, b.BNUM   \r\n" + 
					"FROM PATIENT p , DOCTOR d , BILL b, NURSE n, ROOM r\r\n" + 
					"WHERE p.pSSN = d.PID and p.PSSN = b.PID and r.PATIENT_ID = p.PSSN and r.NURSE_ID = n.NURID and p.pSSN like ?");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, pID);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {

				Records temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {

			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by doctor ID

	public List<Records> searchDID(String docID) throws Exception {

		List<Records> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			docID += "%";

			// Prepare SQL statement

			statement = connect
					.prepareStatement("SELECT p.PSSN , d.DOCID  ,n.NURID,r.RNUM, b.BNUM   \r\n" + 
							"FROM PATIENT p , DOCTOR d , BILL b, NURSE n, ROOM r\r\n" + 
							"WHERE p.pSSN = d.PID and p.PSSN = b.PID and r.PATIENT_ID = p.PSSN and r.NURSE_ID = n.NURID and d.DOCID like ?");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, docID);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Records temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by nurseID

	public List<Records> searchnID(String nID) throws Exception {

		List<Records> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			nID += "%";

			// Prepare SQL statement

			statement = connect
					.prepareStatement("SELECT p.PSSN , d.DOCID  ,n.NURID,r.RNUM, b.BNUM   \r\n" + 
							"FROM PATIENT p , DOCTOR d , BILL b, NURSE n, ROOM r\r\n" + 
							"WHERE p.pSSN = d.PID and p.PSSN = b.PID and r.PATIENT_ID = p.PSSN and r.NURSE_ID = n.NURID and n.NURID like ?");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, nID);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Records temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by billNo

	public List<Records> searchbNo(String bNO) throws Exception {

		List<Records> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			bNO += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("SELECT p.PSSN , d.DOCID  ,n.NURID,r.RNUM, b.BNUM   \r\n" + 
					"FROM PATIENT p , DOCTOR d , BILL b, NURSE n, ROOM r\r\n" + 
					"WHERE p.pSSN = d.PID and p.PSSN = b.PID and r.PATIENT_ID = p.PSSN and r.NURSE_ID = n.NURID and b.BNUM like ?");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, bNO);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Records temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by roomNO

	public List<Records> searchrNO(String rNO) throws Exception {

		List<Records> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			rNO += "%";

			// Prepare SQL statement

			statement = connect
					.prepareStatement("SELECT p.PSSN , d.DOCID  ,n.NURID,r.RNUM, b.BNUM   \r\n" + 
							"FROM PATIENT p , DOCTOR d , BILL b, NURSE n, ROOM r\r\n" + 
							"WHERE p.pSSN = d.PID and p.PSSN = b.PID and r.PATIENT_ID = p.PSSN and r.NURSE_ID = n.NURID and r.RNUM like ?");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, rNO);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Records temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}

	
	// **************************************************************************************


	// **************************************************************************************
	// A method to convert a row to the record it holds in the database

	private Records convertRowToRecord(ResultSet b) throws SQLException {

		String pSSN = b.getString("pSSN");
		String docID = b.getString("DOCID");
		String nurseID = b.getString("NURID");
		String roomNO = b.getString("RNUM");
		String billNO = b.getString("BNUM");

		Records temp = new Records(pSSN, docID, nurseID, roomNO, billNO);

		return temp;
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
