import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import java.util.List;

public class BillGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTable table;
	private BillDAO billDAO;
	private JTextField bNumTextField;
	private JTextField totalTextField;
	private JTextField dChTextField;
	private JTextField nChTextField;
	private JTextField rChTextField;
	private JTextField dueDateTextField;
	private JTextField PatientSSNTextField;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillGUI frame = new BillGUI();
					frame.setMinimumSize(new Dimension(1680, 1030));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BillGUI() {
		setBackground(Color.LIGHT_GRAY);

		// Create the DAO

		try {
			billDAO = new BillDAO();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
		}

		setTitle("Bills");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1650, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 60, 130, 60, 130, 60, 130, 60, 130, 60, 130, 60, 130, 30, 30, 30, 30, 30,
				30, 30, 30, 30, 30 };
		gbl_panel.rowHeights = new int[] { 30 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0 };
		gbl_panel.rowWeights = new double[] { 0.0 };
		panel.setLayout(gbl_panel);

		JLabel lblBillNo = new JLabel("Bill No.");
		GridBagConstraints gbc_lblBillNo = new GridBagConstraints();
		gbc_lblBillNo.anchor = GridBagConstraints.EAST;
		gbc_lblBillNo.insets = new Insets(0, 0, 0, 5);
		gbc_lblBillNo.gridx = 0;
		gbc_lblBillNo.gridy = 0;
		panel.add(lblBillNo, gbc_lblBillNo);

		bNumTextField = new JTextField();
		GridBagConstraints gbc_bNumTextField = new GridBagConstraints();
		gbc_bNumTextField.insets = new Insets(0, 0, 0, 5);
		gbc_bNumTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_bNumTextField.gridx = 1;
		gbc_bNumTextField.gridy = 0;
		panel.add(bNumTextField, gbc_bNumTextField);
		bNumTextField.setColumns(10);

		JLabel lblBillTotal = new JLabel("Bill Total");
		GridBagConstraints gbc_lblBillTotal = new GridBagConstraints();
		gbc_lblBillTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblBillTotal.gridx = 2;
		gbc_lblBillTotal.gridy = 0;
		panel.add(lblBillTotal, gbc_lblBillTotal);

		totalTextField = new JTextField();
		GridBagConstraints gbc_totalTextField = new GridBagConstraints();
		gbc_totalTextField.insets = new Insets(0, 0, 0, 5);
		gbc_totalTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_totalTextField.gridx = 3;
		gbc_totalTextField.gridy = 0;
		panel.add(totalTextField, gbc_totalTextField);
		totalTextField.setColumns(10);

		JLabel lblDoctorCharge = new JLabel("Doctor Charge");
		GridBagConstraints gbc_lblDoctorCharge = new GridBagConstraints();
		gbc_lblDoctorCharge.insets = new Insets(0, 0, 0, 5);
		gbc_lblDoctorCharge.gridx = 4;
		gbc_lblDoctorCharge.gridy = 0;
		panel.add(lblDoctorCharge, gbc_lblDoctorCharge);

		dChTextField = new JTextField();
		GridBagConstraints gbc_dChTextField = new GridBagConstraints();
		gbc_dChTextField.insets = new Insets(0, 0, 0, 5);
		gbc_dChTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_dChTextField.gridx = 5;
		gbc_dChTextField.gridy = 0;
		panel.add(dChTextField, gbc_dChTextField);
		dChTextField.setColumns(10);

		JLabel lblNurseCharge = new JLabel("Nurse Charge");
		GridBagConstraints gbc_lblNurseCharge = new GridBagConstraints();
		gbc_lblNurseCharge.insets = new Insets(0, 0, 0, 5);
		gbc_lblNurseCharge.gridx = 6;
		gbc_lblNurseCharge.gridy = 0;
		panel.add(lblNurseCharge, gbc_lblNurseCharge);

		nChTextField = new JTextField();
		GridBagConstraints gbc_nChTextField = new GridBagConstraints();
		gbc_nChTextField.insets = new Insets(0, 0, 0, 5);
		gbc_nChTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nChTextField.gridx = 7;
		gbc_nChTextField.gridy = 0;
		panel.add(nChTextField, gbc_nChTextField);
		nChTextField.setColumns(10);

		JLabel lblRoomCharge = new JLabel("Room Charge");
		GridBagConstraints gbc_lblRoomCharge = new GridBagConstraints();
		gbc_lblRoomCharge.insets = new Insets(0, 0, 0, 5);
		gbc_lblRoomCharge.gridx = 8;
		gbc_lblRoomCharge.gridy = 0;
		panel.add(lblRoomCharge, gbc_lblRoomCharge);

		rChTextField = new JTextField();
		GridBagConstraints gbc_rChTextField = new GridBagConstraints();
		gbc_rChTextField.insets = new Insets(0, 0, 0, 5);
		gbc_rChTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_rChTextField.gridx = 9;
		gbc_rChTextField.gridy = 0;
		panel.add(rChTextField, gbc_rChTextField);
		rChTextField.setColumns(10);

		JLabel lblDueDate = new JLabel("Due Date");
		GridBagConstraints gbc_lblDueDate = new GridBagConstraints();
		gbc_lblDueDate.insets = new Insets(0, 0, 0, 5);
		gbc_lblDueDate.gridx = 10;
		gbc_lblDueDate.gridy = 0;
		panel.add(lblDueDate, gbc_lblDueDate);
		
		dueDateTextField = new JTextField();
		GridBagConstraints gbc_dueDateTextField = new GridBagConstraints();
		gbc_dueDateTextField.insets = new Insets(0, 0, 0, 5);
		gbc_dueDateTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_dueDateTextField.gridx = 11;
		gbc_dueDateTextField.gridy = 0;
		panel.add(dueDateTextField, gbc_dueDateTextField);
		dueDateTextField.setColumns(10);
		//*******************************************************
		JLabel lblPatientSSN = new JLabel("Patient SSN");
		GridBagConstraints gbc_PatientSSN = new GridBagConstraints();
		gbc_PatientSSN.insets = new Insets(0, 0, 0, 5);
		gbc_PatientSSN.gridx = 12;
		gbc_PatientSSN.gridy = 0;
		panel.add(lblPatientSSN, gbc_PatientSSN);
		
		PatientSSNTextField = new JTextField();
		GridBagConstraints gbc_duePatientSSNTextField = new GridBagConstraints();
		gbc_duePatientSSNTextField.insets = new Insets(0, 0, 0, 5);
		gbc_duePatientSSNTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_duePatientSSNTextField.gridx = 13;
		gbc_duePatientSSNTextField.gridy = 0;
		gbc_duePatientSSNTextField.gridwidth=3;
		panel.add(PatientSSNTextField, gbc_duePatientSSNTextField);
		PatientSSNTextField.setColumns(10);

		// **************************************************************************************
		// Search button actions

		JButton btnSearch = new JButton("Search");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 0, 5);
		gbc_btnSearch.gridx = 17;
		gbc_btnSearch.gridy = 0;
		panel.add(btnSearch, gbc_btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				{
					try {

						// Get the parameters from the input text fields

						String bNum = bNumTextField.getText();

						String total = totalTextField.getText();

						String dCh = dChTextField.getText();

						String rCh = rChTextField.getText();
						
						String nCh =nChTextField.getText();

						String dueDate = dueDateTextField.getText();
						
						String pSSN = PatientSSNTextField.getText();
						
						
						// Create an ArrayList

						List<Bill> list = null;

						// Call DAO and get all doctors with the given parameters

						if (bNum != null && bNum.trim().length() > 0) {

							list = billDAO.searchbNum(bNum);

						} else if (total != null && total.trim().length() > 0) {

							list = billDAO.searchT(total);

						} else if (dCh != null && dCh.trim().length() > 0) {

							list = billDAO.searchdCh(dCh);

						} else if (nCh != null && nCh.trim().length() > 0) {

							list = billDAO.searchdCh(nCh);

						} else if (rCh != null && rCh.trim().length() > 0) {

							list = billDAO.searchrCh(rCh);

						} else if (dueDate != null && dueDate.trim().length() > 0) {

							list = billDAO.searchDueDate(dueDate);

						} else if (pSSN != null && pSSN.trim().length() > 0) {

							list = billDAO.searchpSSN(pSSN);
						} else {

							list = billDAO.getAllRecords();
							System.out.println("ELSE CHECK");
						}

						// Create the table view and update the main table

						BillTableModel model = new BillTableModel(list);
						

						table.setModel(model);
						
						return;

					} catch (Exception exc) {
						JOptionPane.showMessageDialog(BillGUI.this, "Error: " + exc, "Error",
								JOptionPane.ERROR_MESSAGE);
					}

					// **************************************************************************************
				}
			}
		}); // End of search button

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30,
				30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30,
				30, 30, 0 };
		gbl_panel_1.rowHeights = new int[] { 29, 5 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		// **************************************************************************************
		// Delete button actions

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
					try {

						// Get the selected row

						int row = table.getSelectedRow();

						// Check whether a row has been selected or not

						if (row < 0) {
							JOptionPane.showMessageDialog(BillGUI.this, "No record selected.", "Error",
									JOptionPane.ERROR_MESSAGE);
							return;
						}

						// Prompt the user to confirm the action

						int response = JOptionPane.showConfirmDialog(BillGUI.this, "Delete this record?", "",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

						if (response != JOptionPane.YES_OPTION) {
							return;
						}

						// Get the selected record

						Bill temp = (Bill) table.getValueAt(row, BillTableModel.OBJECT_COL);

						// Delete the selected record

						billDAO.deleteRecord(temp.getbNum());

						// Refresh GUI

						refreshView();

						// Show success message

						JOptionPane.showMessageDialog(BillGUI.this, "Record deleted succesfully.", "",
								JOptionPane.INFORMATION_MESSAGE);

					} catch (Exception exc) {
						JOptionPane.showMessageDialog(BillGUI.this, "Error deleting record: " + exc.getMessage(),
								"Error", JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});

		// **************************************************************************************
		// Update button actions

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Get the selected row

				int row = table.getSelectedRow();

				// Check whether a row has been selected or not

				if (row < 0) {
					JOptionPane.showMessageDialog(BillGUI.this, "No record selected", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Get the selected record

				Bill temp = (Bill) table.getValueAt(row, RoomTableModel.OBJECT_COL);

				// Create dialog

				UpdateBillDialog dialog = new UpdateBillDialog(BillGUI.this, billDAO, temp);

				// show dialog

				dialog.setVisible(true);

			}
		});
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnUpdate.insets = new Insets(0, 0, 0, 5);
		gbc_btnUpdate.gridx = 23;
		gbc_btnUpdate.gridy = 0;
		panel_1.add(btnUpdate, gbc_btnUpdate);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
		gbc_btnDelete.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnDelete.gridx = 24;
		gbc_btnDelete.gridy = 0;
		panel_1.add(btnDelete, gbc_btnDelete);
		
				JButton btnMainMenu = new JButton("Main Menu");
				GridBagConstraints gbc_btnMainMenu = new GridBagConstraints();
				gbc_btnMainMenu.gridx = 46;
				gbc_btnMainMenu.gridy = 0;
				panel_1.add(btnMainMenu, gbc_btnMainMenu);
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MainMenu x = new MainMenu();
				setVisible(false);
				dispose();
				x.setVisible(true);
			}
		});
	}

	// **************************************************************************************
	// A method to refresh the table view

	public void refreshView() {

		try {
			List<Bill> b = billDAO.getAllRecords();

			// create the model and update the "table"
			BillTableModel view = new BillTableModel(b);

			table.setModel(view);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
}
