
import java.util.List;

import javax.swing.table.AbstractTableModel;

class RoomTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int OBJECT_COL = -1;
	private static final int R_NUM_COL = 0;
	private static final int R_TYPE_COL = 1;
	private static final int R_CPN_COL = 2;
	private static final int R_NURID_COL = 3;
	private static final int R_PAATIENT_ID = 4;

	

	
	private String[] columnNames = { "Room No.", "Room Type", "Cost/Night", "Nurse ID","Patient ID" };
	private List<Room> r;

	public RoomTableModel(List<Room> r) {
		this.r = r;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return r.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Room temp = r.get(row);

		switch (col) {
		case R_NUM_COL:
			return temp.getrNum();
		case R_TYPE_COL:
			return temp.getrType();
		case R_CPN_COL:
			return temp.getrCPN();
		case R_NURID_COL:
			return temp.getNurseID();
		case R_PAATIENT_ID:
			return temp.getPatientID();
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
