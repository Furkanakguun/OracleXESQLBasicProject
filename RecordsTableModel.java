
import java.util.List;

import javax.swing.table.AbstractTableModel;

class RecordsTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int OBJECT_COL = -1;
	private static final int P_ID_COL = 0;
	private static final int DOC_ID_COL = 1;
	private static final int NUR_ID_COL = 2;
	private static final int ROOM_ID_COL = 3;
	private static final int BILL_NO__COL = 4;

	private String[] columnNames = { "Patient ID.", "Doc ID", "Nurse ID", "Bill No", "Room No"};	
	private List<Records> b;

	public RecordsTableModel(List<Records> b) {
		this.b = b;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return b.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Records temp = b.get(row);

		switch (col) {
		case P_ID_COL:
			return temp.getPatientID();
		case DOC_ID_COL:
			return temp.getDoctorID();
		case NUR_ID_COL:
			return temp.getNurseID();
		case ROOM_ID_COL:
			return temp.getRoomNo();
		case BILL_NO__COL:
			return temp.getBillNum();
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
