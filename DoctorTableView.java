
import java.util.List;

import javax.swing.table.AbstractTableModel;

class DoctorTableView extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int OBJECT_COL = -1;
	private static final int ID_COL = 0;
	private static final int FIRST_NAME_COL = 1;
	private static final int LAST_NAME_COL = 2;
	private static final int SEX_COL = 3;
	private static final int PHONE_NUMBER_COL = 4;
	private static final int ADDRESS_COL = 5;
	private static final int DEPARTMENT_COL = 6;
	private static final int PATIENT_SSN_COL = 7;

	

	private String[] columnNames = { "ID", "First Name", "Last Name", "Sex", "Phone Number", "Address", "Department", "Patient SSN" };
	private List<Doctor> doctors;

	public DoctorTableView(List<Doctor> docs) {
		doctors = docs;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return doctors.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Doctor temp = doctors.get(row);

		switch (col) {
		case ID_COL:
			return temp.getDocID();
		case FIRST_NAME_COL:
			return temp.getDocFirstName();
		case LAST_NAME_COL:
			return temp.getDocLastName();
		case SEX_COL:
			return temp.getDocSex();
		case PHONE_NUMBER_COL:
			return temp.getDocPhoneNumber();
		case ADDRESS_COL:
			return temp.getDocAddress();
		case DEPARTMENT_COL:
			return temp.getDocDepartment();
		case PATIENT_SSN_COL:
			return temp.getPatientSSN();
		case OBJECT_COL:
			return temp;
		default:
			return temp;
		}
	}

//	@Override
//	public Class<? extends Object> getColumnClass(int c) {
//		return getValueAt(0, c).getClass();
//	}
}
