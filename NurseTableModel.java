import java.util.List;

import javax.swing.table.AbstractTableModel;

class NurseTableModel extends AbstractTableModel {

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

	private String[] columnNames = { "ID", "First Name", "Last Name", "Sex", "Phone Number", "Address", "Department" };
	private List<Nurse> nurses;

	public NurseTableModel(List<Nurse> nurs) {
		nurses = nurs;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return nurses.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Nurse temp = nurses.get(row);

		switch (col) {
		case ID_COL:
			return temp.getNurID();
		case FIRST_NAME_COL:
			return temp.getNurFirstName();
		case LAST_NAME_COL:
			return temp.getNurLastName();
		case SEX_COL:
			return temp.getNurSex();
		case PHONE_NUMBER_COL:
			return temp.getNurPhoneNumber();
		case ADDRESS_COL:
			return temp.getNurAddress();
		case DEPARTMENT_COL:
			return temp.getNurDepartment();
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
