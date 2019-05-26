
import java.util.List;

import javax.swing.table.AbstractTableModel;

class BillTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int OBJECT_COL = -1;
	private static final int B_NUM_COL = 0;
	private static final int TOTAL_COL = 1;
	private static final int D_CH_COL = 2;
	private static final int N_CH_COL = 3;
	private static final int R_CH_COL = 4;
	private static final int DUE_DATE_COL = 5;
	private static final int P_ID_COL = 6;


	private String[] columnNames = { "Bill No.", "Bill Total", "Doctor Charge", "Nurse Charge", "Room Charge", "Due Date","Patient SSN" };
	private List<Bill> b;

	public BillTableModel(List<Bill> b) {
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

		Bill temp = b.get(row);

		switch (col) {
		case B_NUM_COL:
			return temp.getbNum();
		case TOTAL_COL:
			return temp.getTotal();
		case D_CH_COL:
			return temp.getdCh();
		case N_CH_COL:
			return temp.getnCh();
		case R_CH_COL:
			return temp.getrCh();
		case DUE_DATE_COL:
			return temp.getDueDate();
		case P_ID_COL:
			return temp.getPatientID();
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
