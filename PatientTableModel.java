
import java.util.List;

import javax.swing.table.AbstractTableModel;

class PatientTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int OBJECT_COL = -1;
	private static final int SSN_COL = 0;
	private static final int FIRST_NAME_COL = 1;
	private static final int LAST_NAME_COL = 2;
	private static final int SEX_COL = 3;
	private static final int PHONE_NUMBER_COL = 4;
	private static final int ADDRESS_COL = 5;

	private String[] columnNames = { "SSN", "First Name", "Last Name", "Sex", "Phone Number", "Address" };
	private List<Patient> p;

	public PatientTableModel(List<Patient> p) {
		this.p = p;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return p.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Patient temp = p.get(row);

		switch (col) {
		case SSN_COL:
			return temp.getpSSN();
		case FIRST_NAME_COL:
			return temp.getpFirstName();
		case LAST_NAME_COL:
			return temp.getpLastName();
		case SEX_COL:
			return temp.getpSex();
		case PHONE_NUMBER_COL:
			return temp.getpPhoneNumber();
		case ADDRESS_COL:
			return temp.getpAddress();
		case OBJECT_COL:
			return temp;
		default:
			return temp;
		}
	}

	@Override
	public Class<? extends Object> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
