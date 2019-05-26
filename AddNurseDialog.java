
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class AddNurseDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField idTextField;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField sexTextField;
	private JTextField phoneNumberTextField;
	private JTextField addressTextField;
	private JTextField departmentTextField;

	private NurseDAO nurseDAO;

	private NurseGUI nurseGUI;

	private Nurse previousNurse = null;
	private boolean updateMode = false;

	public AddNurseDialog(NurseGUI nursegui, NurseDAO nursedao, Nurse prevNur, boolean updatemode) {
		this();
		nurseDAO = nursedao;
		nurseGUI = nursegui;

		previousNurse = prevNur;

		updateMode = updatemode;

		if (updateMode) {
			setTitle("Update Nurse Record");

			populateGui(prevNur);
		}
	}

	private void populateGui(Nurse nurs) {

		idTextField.setText(nurs.getNurID());
		firstNameTextField.setText(nurs.getNurFirstName());
		lastNameTextField.setText(nurs.getNurLastName());
		sexTextField.setText(nurs.getNurSex());
		phoneNumberTextField.setText(nurs.getNurPhoneNumber());
		addressTextField.setText(nurs.getNurAddress());
		departmentTextField.setText(nurs.getNurDepartment());
	}

	public AddNurseDialog(NurseGUI nursegui, NurseDAO nursedao) {
		this(nursegui, nursedao, null, false);
	}

	/**
	 * Create the dialog.
	 */
	public AddNurseDialog() {
		setResizable(false);
		setBackground(Color.LIGHT_GRAY);
		setTitle("Add Nurse Record");
		setBounds(600, 400, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 92, 340, 0 };
		gbl_contentPanel.rowHeights = new int[] { 26, 26, 26, 26, 26, 26, 26, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		// *********************************************************

		{
			JLabel lblId = new JLabel("ID");
			GridBagConstraints gbc_lblId = new GridBagConstraints();
			gbc_lblId.anchor = GridBagConstraints.EAST;
			gbc_lblId.insets = new Insets(0, 0, 5, 5);
			gbc_lblId.gridx = 0;
			gbc_lblId.gridy = 0;
			contentPanel.add(lblId, gbc_lblId);
		}
		{
			idTextField = new JTextField();
			GridBagConstraints gbc_idTextField = new GridBagConstraints();
			gbc_idTextField.anchor = GridBagConstraints.NORTH;
			gbc_idTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_idTextField.insets = new Insets(0, 0, 5, 0);
			gbc_idTextField.gridx = 1;
			gbc_idTextField.gridy = 0;
			contentPanel.add(idTextField, gbc_idTextField);
			idTextField.setColumns(10);
		}

		// *********************************************************

		{
			JLabel lblFirstName = new JLabel("First Name");
			GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
			gbc_lblFirstName.anchor = GridBagConstraints.EAST;
			gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
			gbc_lblFirstName.gridx = 0;
			gbc_lblFirstName.gridy = 1;
			contentPanel.add(lblFirstName, gbc_lblFirstName);
		}
		{
			firstNameTextField = new JTextField();
			GridBagConstraints gbc_firstNameTextField = new GridBagConstraints();
			gbc_firstNameTextField.anchor = GridBagConstraints.NORTH;
			gbc_firstNameTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_firstNameTextField.insets = new Insets(0, 0, 5, 0);
			gbc_firstNameTextField.gridx = 1;
			gbc_firstNameTextField.gridy = 1;
			contentPanel.add(firstNameTextField, gbc_firstNameTextField);
			firstNameTextField.setColumns(10);
		}

		// *********************************************************

		{
			JLabel lblLastName = new JLabel("Last Name");
			GridBagConstraints gbc_lblLastName = new GridBagConstraints();
			gbc_lblLastName.anchor = GridBagConstraints.EAST;
			gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
			gbc_lblLastName.gridx = 0;
			gbc_lblLastName.gridy = 2;
			contentPanel.add(lblLastName, gbc_lblLastName);
		}
		{
			lastNameTextField = new JTextField();
			GridBagConstraints gbc_lastNameTextField = new GridBagConstraints();
			gbc_lastNameTextField.anchor = GridBagConstraints.NORTH;
			gbc_lastNameTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_lastNameTextField.insets = new Insets(0, 0, 5, 0);
			gbc_lastNameTextField.gridx = 1;
			gbc_lastNameTextField.gridy = 2;
			contentPanel.add(lastNameTextField, gbc_lastNameTextField);
			lastNameTextField.setColumns(10);
		}

		// *********************************************************

		{
			JLabel lblSex = new JLabel("Sex");
			GridBagConstraints gbc_lblSex = new GridBagConstraints();
			gbc_lblSex.anchor = GridBagConstraints.EAST;
			gbc_lblSex.insets = new Insets(0, 0, 5, 5);
			gbc_lblSex.gridx = 0;
			gbc_lblSex.gridy = 3;
			contentPanel.add(lblSex, gbc_lblSex);
		}
		{
			sexTextField = new JTextField();
			GridBagConstraints gbc_sexTextField = new GridBagConstraints();
			gbc_sexTextField.anchor = GridBagConstraints.NORTH;
			gbc_sexTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_sexTextField.insets = new Insets(0, 0, 5, 0);
			gbc_sexTextField.gridx = 1;
			gbc_sexTextField.gridy = 3;
			contentPanel.add(sexTextField, gbc_sexTextField);
			sexTextField.setColumns(10);
		}

		// *********************************************************

		{
			JLabel lblPhoneNumber = new JLabel("Phone Number");
			GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
			gbc_lblPhoneNumber.anchor = GridBagConstraints.EAST;
			gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 5);
			gbc_lblPhoneNumber.gridx = 0;
			gbc_lblPhoneNumber.gridy = 4;
			contentPanel.add(lblPhoneNumber, gbc_lblPhoneNumber);
		}
		{
			phoneNumberTextField = new JTextField();
			GridBagConstraints gbc_phoneNumberTextField = new GridBagConstraints();
			gbc_phoneNumberTextField.anchor = GridBagConstraints.NORTH;
			gbc_phoneNumberTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_phoneNumberTextField.insets = new Insets(0, 0, 5, 0);
			gbc_phoneNumberTextField.gridx = 1;
			gbc_phoneNumberTextField.gridy = 4;
			contentPanel.add(phoneNumberTextField, gbc_phoneNumberTextField);
			phoneNumberTextField.setColumns(10);
		}

		// *********************************************************

		{
			JLabel lblAddress = new JLabel("Address");
			GridBagConstraints gbc_lblAddress = new GridBagConstraints();
			gbc_lblAddress.anchor = GridBagConstraints.EAST;
			gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
			gbc_lblAddress.gridx = 0;
			gbc_lblAddress.gridy = 5;
			contentPanel.add(lblAddress, gbc_lblAddress);
		}
		{
			addressTextField = new JTextField();
			GridBagConstraints gbc_addressTextField = new GridBagConstraints();
			gbc_addressTextField.anchor = GridBagConstraints.NORTH;
			gbc_addressTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_addressTextField.insets = new Insets(0, 0, 5, 0);
			gbc_addressTextField.gridx = 1;
			gbc_addressTextField.gridy = 5;
			contentPanel.add(addressTextField, gbc_addressTextField);
			addressTextField.setColumns(10);
		}

		// *********************************************************

		{
			JLabel lblDepartment = new JLabel("Department");
			GridBagConstraints gbc_lblDepartment = new GridBagConstraints();
			gbc_lblDepartment.anchor = GridBagConstraints.EAST;
			gbc_lblDepartment.insets = new Insets(0, 0, 0, 5);
			gbc_lblDepartment.gridx = 0;
			gbc_lblDepartment.gridy = 6;
			contentPanel.add(lblDepartment, gbc_lblDepartment);
		}
		{
			departmentTextField = new JTextField();
			GridBagConstraints gbc_departmentTextField = new GridBagConstraints();
			gbc_departmentTextField.anchor = GridBagConstraints.NORTH;
			gbc_departmentTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_departmentTextField.gridx = 1;
			gbc_departmentTextField.gridy = 6;
			contentPanel.add(departmentTextField, gbc_departmentTextField);
			departmentTextField.setColumns(10);
		}

		// *********************************************************

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						saveRecord();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}

			// *********************************************************

			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void saveRecord() {

		// Get the record info from GUI

		String id = idTextField.getText();

		String firstName = firstNameTextField.getText();

		String lastName = lastNameTextField.getText();

		String sex = sexTextField.getText();

		String phoneNumber = phoneNumberTextField.getText();

		String address = addressTextField.getText();

		String department = departmentTextField.getText();

		Nurse temp = null;

		if (id.equals("") && firstName.equals("") && lastName.equals("") && sex.equals("") && phoneNumber.equals("")
				&& address.equals("") && department.equals("")) {
			setVisible(false);
			dispose();
			JOptionPane.showMessageDialog(nurseGUI, "Record is empty!", "Error", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		if (updateMode) {

			temp = previousNurse;

			temp.setNurID(id);
			temp.setNurFirstName(firstName);
			temp.setNurLastName(lastName);
			temp.setNurSex(sex);
			temp.setNurPhoneNumber(phoneNumber);
			temp.setNurAddress(address);
			temp.setNurDepartment(department);

		} else {
			temp = new Nurse(id, firstName, lastName, sex, phoneNumber, address, department);
		}

		try {

			// Save to the database after updating

			if (updateMode) {
				nurseDAO.updateRecord(temp);
			} else {
				nurseDAO.addRecord(temp);
			}

			// Close dialog

			setVisible(false);
			dispose();

			// Refresh GUI list

			nurseGUI.refreshView();

			// Show success message

			if (updateMode) {
				JOptionPane.showMessageDialog(nurseGUI, "Record updated succesfully.", "",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(nurseGUI, "Record added succesfully.", "",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(nurseGUI, "Error adding record: " + exc.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}
}
