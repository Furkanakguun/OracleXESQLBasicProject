import java.util.*;
import java.sql.*;

public class BillDAO {

	private Connection connect;

	public BillDAO() throws Exception {

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
	// A method to add a record to the database

	public void addRecord(Bill b) throws SQLException {

		// Initialize SQL statement

		PreparedStatement statement = null;

		try {
			// Prepare SQL statement

			statement = connect.prepareStatement(
					"insert into bill" + " (bNum, total, dCh, nCh, rCh, dueDate ,pID)" + " values (?, ?, ?, ?, ?, ?, ?)");
			// ? i a placeholder
			// Set the parameters to the corresponding placeholder

			statement.setString(1, b.getbNum());
			statement.setString(2, b.getTotal());
			statement.setString(3, b.getdCh());
			statement.setString(4, b.getnCh());
			statement.setString(5, b.getrCh());
			statement.setString(6, b.getDueDate());
			statement.setString(7, b.getPatientID());

			// Execute SQL statement

			statement.executeUpdate();

		} finally {

			close(statement);
		}
	}

	// **************************************************************************************
	// A method to update a record in the database

	public void updateRecord(Bill b) throws SQLException {

		// Initialize SQL statement

		PreparedStatement statement = null;

		try {

			// Prepare SQL statement

			statement = connect.prepareStatement(
					"update bill" + " set bNum=?, total=?, dCh=?, nCh=?, rCh=?, dueDate=?, pID" + " where bNum=?");
			// ? i a placeholder
			// Set the parameters to the corresponding placeholder

			statement.setString(1, b.getbNum());
			statement.setString(2, b.getbNum());
			statement.setString(3, b.getdCh());
			statement.setString(4, b.getnCh());
			statement.setString(5, b.getrCh());
			statement.setString(6, b.getDueDate());
			statement.setString(7, b.getPatientID());
			statement.setString(8, b.getbNum());
			// Execute SQL statement

			statement.executeUpdate();

		} finally {

			close(statement);
		}
	}

	// **************************************************************************************
	// A method to delete a record from the database

	public void deleteRecord(String bNum) throws SQLException {

		// Initialize SQL statement

		PreparedStatement statement = null;

		try {
			// Prepare SQL statement

			statement = connect.prepareStatement("delete from bill where bNum=?"); // ? is a placeholder

			// Set a parameter to the corresponding placeholder

			statement.setString(1, bNum);

			// Execute SQL statement

			statement.executeUpdate();
		} finally {

			close(statement);
		}
	}

	// **************************************************************************************
	// A method to list all the records in the database

	public List<Bill> getAllRecords() throws Exception {

		// Create an ArrayList to hold the records

		List<Bill> list = new ArrayList<>();

		// Initialize SQL statement and a result set

		Statement statement = null;
		ResultSet result = null;

		try {

			// Prepare SQL statement in the result set

			statement = connect.createStatement();
			result = statement.executeQuery("select * from bill order by bNum");

			// While we still have rows in the table

			while (result.next()) {

				// Take the corresponding row in the table and convert it to the record it holds

				Bill temp = convertRowToRecord(result);

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

	private Bill convertRowToRecord(ResultSet b) throws SQLException {

		String bNum = b.getString("bNum");
		String total = b.getString("total");
		String dCh = b.getString("dCh");
		String nCh = b.getString("nCh");
		String rCh = b.getString("rCh");
		String dueDate = b.getString("dueDate");
		String PID = b.getString("pID");

		Bill temp = new Bill(bNum, total, dCh, nCh, rCh, dueDate,PID);

		return temp;
	}

	// **************************************************************************************
	// Search by bill number

	public List<Bill> searchbNum(String bNum) throws Exception {

		List<Bill> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			bNum += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("select * from bill where bNum like ?  order by bNum");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, bNum);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {

				Bill temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {

			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by bill total

	public List<Bill> searchT(String t) throws Exception {

		List<Bill> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			t += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("select * from bill where total like ?  order by bNum");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, t);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {

				Bill temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {

			close(statement, result);
		}
	}
	// **************************************************************************************
	// Search by doctor charge

	public List<Bill> searchdCh(String dCh) throws Exception {

		List<Bill> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			dCh += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("select * from bill where dCh like ?  order by bNum");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, dCh);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Bill temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by nurse charge

	public List<Bill> searchnCh(String nCh) throws Exception {

		List<Bill> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			nCh += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("select * from bill where nCh like ?  order by bNum");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, nCh);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Bill temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}
	// **************************************************************************************
	// Search by room charge

	public List<Bill> searchrCh(String rCh) throws Exception {

		List<Bill> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			rCh += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("select * from bill where rCh like ?  order by bNum");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, rCh);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Bill temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}

	// **************************************************************************************
	// Search by bill due date

	public List<Bill> searchDueDate(String d) throws Exception {

		List<Bill> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			d += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("select * from bill where dueDate like ?  order by bNum");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, d);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Bill temp = convertRowToRecord(result);
				list.add(temp);
			}

			return list;

		} finally {
			close(statement, result);
		}
	}////////////**************************\\\\\\\\\\\\\\\\\\\\\\
	//search pSSN
	public List<Bill> searchpSSN(String pSSN) throws Exception {

		List<Bill> list = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			pSSN += "%";

			// Prepare SQL statement

			statement = connect.prepareStatement("select * from bill where pID like ?  order by bNum");

			// Set a parameter to the corresponding placeholder

			statement.setString(1, pSSN);

			// Execute SQL statement

			result = statement.executeQuery();

			while (result.next()) {
				Bill temp = convertRowToRecord(result);
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
