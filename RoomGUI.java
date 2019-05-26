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

public class RoomGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField rNumTextField;
	private JTextField rTypeTextField;
	private JTextField rCPNTextField;

	private JTable table;
	private RoomDAO roomDAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomGUI frame = new RoomGUI();
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
	public RoomGUI() {
		setBackground(Color.LIGHT_GRAY);

		// Create the DAO

		try {
			roomDAO = new RoomDAO();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
		}

		setTitle("Rooms");
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
		gbl_panel.columnWidths = new int[] { 14, 130, 68, 130, 66, 130, 30, 30, 92, 130, 51, 130, 74, 30, 30, 30, 30,
				30, 30, 30, 30, 30, 30, 30, 0 };
		gbl_panel.rowHeights = new int[] { 30, 5 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		// *********************************************************

		JLabel lblrNum = new JLabel("Room Number");
		GridBagConstraints gbc_lblrNum = new GridBagConstraints();
		gbc_lblrNum.anchor = GridBagConstraints.WEST;
		gbc_lblrNum.insets = new Insets(0, 0, 0, 5);
		gbc_lblrNum.gridx = 0;
		gbc_lblrNum.gridy = 0;
		panel.add(lblrNum, gbc_lblrNum);

		rNumTextField = new JTextField();
		GridBagConstraints gbc_rNumTextField = new GridBagConstraints();
		gbc_rNumTextField.anchor = GridBagConstraints.WEST;
		gbc_rNumTextField.insets = new Insets(0, 0, 0, 5);
		gbc_rNumTextField.gridx = 1;
		gbc_rNumTextField.gridy = 0;
		panel.add(rNumTextField, gbc_rNumTextField);
		rNumTextField.setColumns(10);

		// *********************************************************

		JLabel lblrType = new JLabel("Room Type");
		GridBagConstraints gbc_lblrType = new GridBagConstraints();
		gbc_lblrType.anchor = GridBagConstraints.WEST;
		gbc_lblrType.insets = new Insets(0, 0, 0, 5);
		gbc_lblrType.gridx = 2;
		gbc_lblrType.gridy = 0;
		panel.add(lblrType, gbc_lblrType);

		rTypeTextField = new JTextField();
		GridBagConstraints gbc_rTypeTextField = new GridBagConstraints();
		gbc_rTypeTextField.anchor = GridBagConstraints.WEST;
		gbc_rTypeTextField.insets = new Insets(0, 0, 0, 5);
		gbc_rTypeTextField.gridx = 3;
		gbc_rTypeTextField.gridy = 0;
		panel.add(rTypeTextField, gbc_rTypeTextField);
		rTypeTextField.setColumns(10);

		// *********************************************************

		JLabel lblrCPN = new JLabel("Cost/Night");
		GridBagConstraints gbc_lblrCPN = new GridBagConstraints();
		gbc_lblrCPN.anchor = GridBagConstraints.WEST;
		gbc_lblrCPN.insets = new Insets(0, 0, 0, 5);
		gbc_lblrCPN.gridx = 4;
		gbc_lblrCPN.gridy = 0;
		panel.add(lblrCPN, gbc_lblrCPN);

		rCPNTextField = new JTextField();
		GridBagConstraints gbc_rCPNTextField = new GridBagConstraints();
		gbc_rCPNTextField.anchor = GridBagConstraints.WEST;
		gbc_rCPNTextField.insets = new Insets(0, 0, 0, 5);
		gbc_rCPNTextField.gridx = 5;
		gbc_rCPNTextField.gridy = 0;
		panel.add(rCPNTextField, gbc_rCPNTextField);
		rCPNTextField.setColumns(10);

		// **************************************************************************************
		// Search button actions

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				{
					try {

						// Get the parameters from the input text fields

						String rNum = rNumTextField.getText();

						String rType = rTypeTextField.getText();

						String rCPN = rCPNTextField.getText();

						// Create an ArrayList

						List<Room> list = null;

						// Call DAO and get all doctors with the given parameters

						if (rNum != null && rNum.trim().length() > 0) {

							list = roomDAO.searchNum(rNum);

						} else if (rType != null && rType.trim().length() > 0) {

							list = roomDAO.searchType(rType);

						} else if (rCPN != null && rCPN.trim().length() > 0) {

							list = roomDAO.searchCPN(rCPN);

						} else {

							list = roomDAO.getAllRecords();
						}

						// Create the table view and update the main table

						RoomTableModel model = new RoomTableModel(list);

						table.setModel(model);

						return;

					} catch (Exception exc) {
						JOptionPane.showMessageDialog(RoomGUI.this, "Error: " + exc, "Error",
								JOptionPane.ERROR_MESSAGE);
					}

					// **************************************************************************************
				}
			}
		}); // End of search button

		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 0, 5);
		gbc_btnSearch.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnSearch.gridx = 6;
		gbc_btnSearch.gridy = 0;
		panel.add(btnSearch, gbc_btnSearch);

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
				30, 30 };
		gbl_panel_1.rowHeights = new int[] { 29, 5 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		// **************************************************************************************
		// Add button actions

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
					// Create dialog

					AddRoomDialog dialog = new AddRoomDialog(RoomGUI.this, roomDAO);

					// Show dialog

					dialog.setVisible(true);
				}
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.gridx = 23;
		gbc_btnAdd.gridy = 0;
		panel_1.add(btnAdd, gbc_btnAdd);

		// **************************************************************************************
		// Update button actions

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Get the selected row

				int row = table.getSelectedRow();

				// Check whether a row has been selected or not

				if (row < 0) {
					JOptionPane.showMessageDialog(RoomGUI.this, "No record selected", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Get the selected record

				Room temp = (Room) table.getValueAt(row, RoomTableModel.OBJECT_COL);

				// Create dialog

				AddRoomDialog dialog = new AddRoomDialog(RoomGUI.this, roomDAO, temp, true);

				// show dialog

				dialog.setVisible(true);

			}
		});
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnUpdate.insets = new Insets(0, 0, 0, 5);
		gbc_btnUpdate.gridx = 24;
		gbc_btnUpdate.gridy = 0;
		panel_1.add(btnUpdate, gbc_btnUpdate);
		//***************************************************************
		//Add Nurse Button Actions
		JButton btnAssign = new JButton("Assign Nurse");
		btnAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Get the selected row

				int row = table.getSelectedRow();

				// Check whether a row has been selected or not

				if (row < 0) {
					JOptionPane.showMessageDialog(RoomGUI.this, "No record selected", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Get the selected record

				Room temp = (Room) table.getValueAt(row, RoomTableModel.OBJECT_COL);

				// Create dialog

				getNurseDiolog dialog = new getNurseDiolog(RoomGUI.this,roomDAO,temp);

				// show dialog

				dialog.setVisible(true);

			}
		});
		GridBagConstraints gbc_btnAssign = new GridBagConstraints();
		gbc_btnAssign.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAssign.insets = new Insets(0, 0, 0, 5);
		gbc_btnAssign.gridx = 26;
		gbc_btnAssign.gridy = 0;
		panel_1.add(btnAssign, gbc_btnAssign);
		

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
							JOptionPane.showMessageDialog(RoomGUI.this, "No record selected.", "Error",
									JOptionPane.ERROR_MESSAGE);
							return;
						}

						// Prompt the user to confirm the action

						int response = JOptionPane.showConfirmDialog(RoomGUI.this, "Delete this record?", "",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

						if (response != JOptionPane.YES_OPTION) {
							return;
						}

						// Get the selected record

						Room temp = (Room) table.getValueAt(row, RoomTableModel.OBJECT_COL);

						// Delete the selected record

						roomDAO.deleteRecord(temp.getrNum());

						// Refresh GUI

						refreshView();

						// Show success message

						JOptionPane.showMessageDialog(RoomGUI.this, "Record deleted succesfully.", "",
								JOptionPane.INFORMATION_MESSAGE);

					} catch (Exception exc) {
						JOptionPane.showMessageDialog(RoomGUI.this, "Error deleting record: " + exc.getMessage(),
								"Error", JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
		gbc_btnDelete.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnDelete.gridx = 25;
		gbc_btnDelete.gridy = 0;
		panel_1.add(btnDelete, gbc_btnDelete);

		JButton btnMainMenu = new JButton("Main Menu");
		GridBagConstraints gbc_btnMainMenu = new GridBagConstraints();
		gbc_btnMainMenu.gridx = 45;
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
			List<Room> r = roomDAO.getAllRecords();

			// create the model and update the "table"
			RoomTableModel view = new RoomTableModel(r);

			table.setModel(view);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
}
