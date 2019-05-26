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

public class AddRoomDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField rNumTextField;
	private JTextField rTpeTextField;
	private JTextField rCPNTextField;

	private RoomDAO roomDAO;

	private RoomGUI roomGUI;

	private Room previousRoom = null;
	private boolean updateMode = false;

	public AddRoomDialog(RoomGUI roomgui, RoomDAO roomdao, Room prev, boolean updatemode) {
		this();
		roomDAO = roomdao;
		roomGUI = roomgui;

		previousRoom = prev;

		updateMode = updatemode;

		if (updateMode) {
			setTitle("Update Room Record");

			populateGui(prev);
		}
	}

	private void populateGui(Room r) {

		rNumTextField.setText(r.getrNum());
		rTpeTextField.setText(r.getrType());
		rCPNTextField.setText(r.getrCPN());
	}

	public AddRoomDialog(RoomGUI roomgui, RoomDAO roomdao) {
		this(roomgui, roomdao, null, false);
	}

	/**
	 * Create the dialog.
	 */
	public AddRoomDialog() {
		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("Add Patient Record");
		setBounds(600, 400, 450, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 92, 340, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		// *********************************************************

		{
			JLabel lblRnum = new JLabel("Room Number");
			GridBagConstraints gbc_lblRnum = new GridBagConstraints();
			gbc_lblRnum.anchor = GridBagConstraints.EAST;
			gbc_lblRnum.insets = new Insets(0, 0, 5, 5);
			gbc_lblRnum.gridx = 0;
			gbc_lblRnum.gridy = 1;
			contentPanel.add(lblRnum, gbc_lblRnum);
		}
		{
			rNumTextField = new JTextField();
			GridBagConstraints gbc_rNumTextField = new GridBagConstraints();
			gbc_rNumTextField.anchor = GridBagConstraints.NORTH;
			gbc_rNumTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_rNumTextField.insets = new Insets(0, 0, 5, 0);
			gbc_rNumTextField.gridx = 1;
			gbc_rNumTextField.gridy = 1;
			contentPanel.add(rNumTextField, gbc_rNumTextField);
			rNumTextField.setColumns(10);
		}

		// *********************************************************

		{
			JLabel lblrType = new JLabel("Room Type");
			GridBagConstraints gbc_lblrType = new GridBagConstraints();
			gbc_lblrType.anchor = GridBagConstraints.EAST;
			gbc_lblrType.insets = new Insets(0, 0, 5, 5);
			gbc_lblrType.gridx = 0;
			gbc_lblrType.gridy = 2;
			contentPanel.add(lblrType, gbc_lblrType);
		}
		{
			rTpeTextField = new JTextField();
			GridBagConstraints gbc_rTypeTextField = new GridBagConstraints();
			gbc_rTypeTextField.anchor = GridBagConstraints.NORTH;
			gbc_rTypeTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_rTypeTextField.insets = new Insets(0, 0, 5, 0);
			gbc_rTypeTextField.gridx = 1;
			gbc_rTypeTextField.gridy = 2;
			contentPanel.add(rTpeTextField, gbc_rTypeTextField);
			rTpeTextField.setColumns(10);
		}

		// *********************************************************

		{
			JLabel lblrCPN = new JLabel("Cost/Night");
			GridBagConstraints gbc_lblrCPN = new GridBagConstraints();
			gbc_lblrCPN.anchor = GridBagConstraints.EAST;
			gbc_lblrCPN.insets = new Insets(0, 0, 0, 5);
			gbc_lblrCPN.gridx = 0;
			gbc_lblrCPN.gridy = 3;
			contentPanel.add(lblrCPN, gbc_lblrCPN);
		}
		{
			rCPNTextField = new JTextField();
			GridBagConstraints gbc_rCPNTextField = new GridBagConstraints();
			gbc_rCPNTextField.anchor = GridBagConstraints.NORTH;
			gbc_rCPNTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_rCPNTextField.gridx = 1;
			gbc_rCPNTextField.gridy = 3;
			contentPanel.add(rCPNTextField, gbc_rCPNTextField);
			rCPNTextField.setColumns(10);
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

		String rNum = rNumTextField.getText();

		String rType = rTpeTextField.getText();

		String rCPN = rCPNTextField.getText();
		
		StringBuilder sb = new StringBuilder(rCPN);
		
		if (!sb.toString().startsWith("$")) {
			sb.insert(0, "$");
		}

		Room temp = null;

		if (rNum.equals("") && rType.equals("") && rCPN.equals("")) {
			setVisible(false);
			dispose();
			JOptionPane.showMessageDialog(roomGUI, "Record is empty!", "Error", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		if (updateMode) {

			temp = previousRoom;

			temp.setrNum(rNum);
			temp.setrType(rType);
			temp.setrCPN(sb.toString());

		} else {
			temp = new Room(rNum, rType, sb.toString(),null,null);
		}

		try {

			// Save to the database after updating

			if (updateMode) {
				roomDAO.updateRecord(temp);
			} else {
				roomDAO.addRecord(temp);
			}

			// Close dialog

			setVisible(false);
			dispose();

			// Refresh GUI list

			roomGUI.refreshView();

			// Show success message

			if (updateMode) {
				JOptionPane.showMessageDialog(roomGUI, "Record updated succesfully.", "",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(roomGUI, "Record added succesfully.", "",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(roomGUI, "Error adding record: " + exc.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}
}
