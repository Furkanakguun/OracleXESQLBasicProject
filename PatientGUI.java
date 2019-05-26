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

public class PatientGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField ssnTextField;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField sexTextField;
	private JTextField phoneNumberTextField;
	private JTextField addressTextField;

	private JTable table;
	private PatientDAO patientDAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientGUI frame = new PatientGUI();
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
	public PatientGUI() {
		setBackground(Color.LIGHT_GRAY);

		// Create the DAO

		try {
			patientDAO = new PatientDAO();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
		}

		setTitle("Patients");
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
		gbl_panel.columnWidths = new int[] { 14, 130, 68, 130, 66, 130, 22, 130, 92, 130, 51, 130, 74, 30, 30, 30, 30,
				30, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 30, 5 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		// *********************************************************

		JLabel lblSSN = new JLabel("SSN");
		GridBagConstraints gbc_lblSSN = new GridBagConstraints();
		gbc_lblSSN.anchor = GridBagConstraints.WEST;
		gbc_lblSSN.insets = new Insets(0, 0, 0, 5);
		gbc_lblSSN.gridx = 0;
		gbc_lblSSN.gridy = 0;
		panel.add(lblSSN, gbc_lblSSN);

		ssnTextField = new JTextField();
		GridBagConstraints gbc_ssnTextField = new GridBagConstraints();
		gbc_ssnTextField.anchor = GridBagConstraints.WEST;
		gbc_ssnTextField.insets = new Insets(0, 0, 0, 5);
		gbc_ssnTextField.gridx = 1;
		gbc_ssnTextField.gridy = 0;
		panel.add(ssnTextField, gbc_ssnTextField);
		ssnTextField.setColumns(10);

		// *********************************************************

		JLabel lblFirstName = new JLabel("First Name");
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.WEST;
		gbc_lblFirstName.insets = new Insets(0, 0, 0, 5);
		gbc_lblFirstName.gridx = 2;
		gbc_lblFirstName.gridy = 0;
		panel.add(lblFirstName, gbc_lblFirstName);

		firstNameTextField = new JTextField();
		GridBagConstraints gbc_firstNameTextField = new GridBagConstraints();
		gbc_firstNameTextField.anchor = GridBagConstraints.WEST;
		gbc_firstNameTextField.insets = new Insets(0, 0, 0, 5);
		gbc_firstNameTextField.gridx = 3;
		gbc_firstNameTextField.gridy = 0;
		panel.add(firstNameTextField, gbc_firstNameTextField);
		firstNameTextField.setColumns(10);

		// *********************************************************

		JLabel lblLastName = new JLabel("Last Name");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.WEST;
		gbc_lblLastName.insets = new Insets(0, 0, 0, 5);
		gbc_lblLastName.gridx = 4;
		gbc_lblLastName.gridy = 0;
		panel.add(lblLastName, gbc_lblLastName);

		lastNameTextField = new JTextField();
		GridBagConstraints gbc_lastNameTextField = new GridBagConstraints();
		gbc_lastNameTextField.anchor = GridBagConstraints.WEST;
		gbc_lastNameTextField.insets = new Insets(0, 0, 0, 5);
		gbc_lastNameTextField.gridx = 5;
		gbc_lastNameTextField.gridy = 0;
		panel.add(lastNameTextField, gbc_lastNameTextField);
		lastNameTextField.setColumns(10);

		// *********************************************************

		JLabel lblSex = new JLabel("Sex");
		GridBagConstraints gbc_lblSex = new GridBagConstraints();
		gbc_lblSex.anchor = GridBagConstraints.WEST;
		gbc_lblSex.insets = new Insets(0, 0, 0, 5);
		gbc_lblSex.gridx = 6;
		gbc_lblSex.gridy = 0;
		panel.add(lblSex, gbc_lblSex);

		sexTextField = new JTextField();
		GridBagConstraints gbc_sexTextField = new GridBagConstraints();
		gbc_sexTextField.anchor = GridBagConstraints.WEST;
		gbc_sexTextField.insets = new Insets(0, 0, 0, 5);
		gbc_sexTextField.gridx = 7;
		gbc_sexTextField.gridy = 0;
		panel.add(sexTextField, gbc_sexTextField);
		sexTextField.setColumns(10);

		// *********************************************************

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
		gbc_lblPhoneNumber.anchor = GridBagConstraints.WEST;
		gbc_lblPhoneNumber.insets = new Insets(0, 0, 0, 5);
		gbc_lblPhoneNumber.gridx = 8;
		gbc_lblPhoneNumber.gridy = 0;
		panel.add(lblPhoneNumber, gbc_lblPhoneNumber);

		phoneNumberTextField = new JTextField();
		GridBagConstraints gbc_phoneNumberTextField = new GridBagConstraints();
		gbc_phoneNumberTextField.anchor = GridBagConstraints.WEST;
		gbc_phoneNumberTextField.insets = new Insets(0, 0, 0, 5);
		gbc_phoneNumberTextField.gridx = 9;
		gbc_phoneNumberTextField.gridy = 0;
		panel.add(phoneNumberTextField, gbc_phoneNumberTextField);
		phoneNumberTextField.setColumns(10);

		// *********************************************************

		JLabel lblAddress = new JLabel("Address");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.WEST;
		gbc_lblAddress.insets = new Insets(0, 0, 0, 5);
		gbc_lblAddress.gridx = 10;
		gbc_lblAddress.gridy = 0;
		panel.add(lblAddress, gbc_lblAddress);

		addressTextField = new JTextField();
		GridBagConstraints gbc_addressTextField = new GridBagConstraints();
		gbc_addressTextField.anchor = GridBagConstraints.WEST;
		gbc_addressTextField.insets = new Insets(0, 0, 0, 5);
		gbc_addressTextField.gridx = 11;
		gbc_addressTextField.gridy = 0;
		panel.add(addressTextField, gbc_addressTextField);
		addressTextField.setColumns(10);

		// *********************************************************

		JButton btnSearch = new JButton("Search");

		// **************************************************************************************
		// Search button actions

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				{
					try {

						// Get the parameters from the input text fields

						String ssn = ssnTextField.getText();

						String firstName = firstNameTextField.getText();

						String lastName = lastNameTextField.getText();

						String sex = sexTextField.getText();

						String phoneNumber = phoneNumberTextField.getText();

						String address = addressTextField.getText();

						// Create an ArrayList

						List<Patient> list = null;

						// Call DAO and get all doctors with the given parameters

						if (ssn != null && ssn.trim().length() > 0) {

							if (firstName != null && firstName.trim().length() > 0) {

								list = patientDAO.searchFN(firstName);

							} else {
								list = patientDAO.searchSSN(ssn);
							}

						} else if (firstName != null && firstName.trim().length() > 0) {

							list = patientDAO.searchFN(firstName);

						} else if (lastName != null && lastName.trim().length() > 0) {

							list = patientDAO.searchLN(lastName);

						} else if (sex != null && sex.trim().length() > 0) {

							list = patientDAO.searchS(sex);

						} else if (phoneNumber != null && phoneNumber.trim().length() > 0) {

							list = patientDAO.searchPN(phoneNumber);

						} else if (address != null && address.trim().length() > 0) {

							list = patientDAO.searchA(address);

						} else {

							list = patientDAO.getAllRecords();
						}

						// Create the table view and update the main table

						PatientTableModel model = new PatientTableModel(list);

						table.setModel(model);

						return;

					} catch (Exception exc) {
						JOptionPane.showMessageDialog(PatientGUI.this, "Error: " + exc, "Error",
								JOptionPane.ERROR_MESSAGE);
					}

					// **************************************************************************************
				}
			}
		}); // End of search button

		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 0, 5);
		gbc_btnSearch.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSearch.gridx = 12;
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
		gbl_panel_1.columnWidths = new int[] {30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		gbl_panel_1.rowHeights = new int[] {29, 5};
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

							AddPatientDialog dialog = new AddPatientDialog(PatientGUI.this, patientDAO);

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
				
				//*******************************************************************
				// Assign Bill button actions
				
				JButton btnAssign_Bill = new JButton("Assing Bill");
				btnAssign_Bill.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						{
							// Get the selected row

							int row = table.getSelectedRow();

							// Check whether a row has been selected or not

							if (row < 0) {
								JOptionPane.showMessageDialog(PatientGUI.this, "No record selected", "Error",
										JOptionPane.ERROR_MESSAGE);
								return;
							}

							// Get the selected record

							Patient temp = (Patient) table.getValueAt(row, PatientTableModel.OBJECT_COL);

							// Create dialog

							getPatientBIllDiaolog dialog = new getPatientBIllDiaolog(PatientGUI.this,patientDAO,temp);

							// show dialog

							dialog.setVisible(true);
						}
					}
				});
				
				GridBagConstraints gbc_btnAssignBill = new GridBagConstraints();
				gbc_btnAssignBill.anchor = GridBagConstraints.NORTHWEST;
				gbc_btnAssignBill.insets = new Insets(0, 0, 0, 5);
				gbc_btnAssignBill.gridx = 26;
				gbc_btnAssignBill.gridy = 0;
				panel_1.add(btnAssign_Bill, gbc_btnAssignBill);
				
				//***************************************************************
				//AssignDoctor Actions
				JButton btnAssign_Doctor = new JButton("Assing Doctor");
				btnAssign_Doctor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						{
							// Get the selected row

							int row = table.getSelectedRow();

							// Check whether a row has been selected or not

							if (row < 0) {
								JOptionPane.showMessageDialog(PatientGUI.this, "No record selected", "Error",
										JOptionPane.ERROR_MESSAGE);
								return;
							}

							// Get the selected record

							Patient temp = (Patient) table.getValueAt(row, PatientTableModel.OBJECT_COL);

							// Create dialog

							getPatietnDialog doctor = new getPatietnDialog(PatientGUI.this,patientDAO,temp);

							// show dialog

							doctor.setVisible(true);
						}
					}
				});
				
				GridBagConstraints gbc_btnAssignDoctor = new GridBagConstraints();
				gbc_btnAssignDoctor.anchor = GridBagConstraints.NORTHWEST;
				gbc_btnAssignDoctor.insets = new Insets(0, 0, 0, 5);
				gbc_btnAssignDoctor.gridx = 27;
				gbc_btnAssignDoctor.gridy = 0;
				panel_1.add(btnAssign_Doctor, gbc_btnAssignDoctor);
				//**************************************************************************************
				//Assign Room button actions
				JButton btnAssign_Room = new JButton("Assing Room");
				btnAssign_Room.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						{
							// Get the selected row

							int row = table.getSelectedRow();

							// Check whether a row has been selected or not

							if (row < 0) {
								JOptionPane.showMessageDialog(PatientGUI.this, "No record selected", "Error",
										JOptionPane.ERROR_MESSAGE);
								return;
							}

							// Get the selected record

							Patient temp = (Patient) table.getValueAt(row, PatientTableModel.OBJECT_COL);

							// Create dialog

							getRoomDiolog doctor = new getRoomDiolog(PatientGUI.this,temp);

							// show dialog

							doctor.setVisible(true);
						}
					}
				});
				
				GridBagConstraints gbc_btnAssignRoom = new GridBagConstraints();
				gbc_btnAssignRoom.anchor = GridBagConstraints.NORTHWEST;
				gbc_btnAssignRoom.insets = new Insets(0, 0, 0, 5);
				gbc_btnAssignRoom.gridx = 28;
				gbc_btnAssignRoom.gridy = 0;
				panel_1.add(btnAssign_Room, gbc_btnAssignRoom);
		
		
				// **************************************************************************************
				// Update button actions
		
				JButton btnUpdate = new JButton("Update");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						// Get the selected row

						int row = table.getSelectedRow();

						// Check whether a row has been selected or not

						if (row < 0) {
							JOptionPane.showMessageDialog(PatientGUI.this, "No record selected", "Error",
									JOptionPane.ERROR_MESSAGE);
							return;
						}

						// Get the selected record

						Patient temp = (Patient) table.getValueAt(row, PatientTableModel.OBJECT_COL);

						// Create dialog

						AddPatientDialog dialog = new AddPatientDialog(PatientGUI.this, patientDAO, temp, true);

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
									JOptionPane.showMessageDialog(PatientGUI.this, "No record selected.", "Error",
											JOptionPane.ERROR_MESSAGE);
									return;
								}

								// Prompt the user to confirm the action

								int response = JOptionPane.showConfirmDialog(PatientGUI.this, "Delete this record?", "",
										JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

								if (response != JOptionPane.YES_OPTION) {
									return;
								}

								// Get the selected record

								Patient temp = (Patient) table.getValueAt(row, PatientTableModel.OBJECT_COL);

								// Delete the selected record

								patientDAO.deleteRecord(temp.getpSSN());

								// Refresh GUI

								refreshView();

								// Show success message

								JOptionPane.showMessageDialog(PatientGUI.this, "Record deleted succesfully.", "",
										JOptionPane.INFORMATION_MESSAGE);

							} catch (Exception exc) {
								JOptionPane.showMessageDialog(PatientGUI.this, "Error deleting record: " + exc.getMessage(),
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
		gbc_btnMainMenu.gridx = 41;
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
			List<Patient> p = patientDAO.getAllRecords();

			// create the model and update the "table"
			PatientTableModel view = new PatientTableModel(p);

			table.setModel(view);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
}
