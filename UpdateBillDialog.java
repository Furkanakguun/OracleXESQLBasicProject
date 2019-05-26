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

public class UpdateBillDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField bNumTextField;
	private JTextField dChTextField;
	private JTextField rChTextField;
	private JTextField dueDateTextField;

	private BillDAO billDAO;

	private BillGUI billGUI;

	private Bill previousBill = null;

	public UpdateBillDialog(BillGUI billgui, BillDAO billdao, Bill prev) {
		this();
		billDAO = billdao;
		billGUI = billgui;

		previousBill = prev;

		populateGui(prev);
	}

	private void populateGui(Bill b) {

		bNumTextField.setText(b.getbNum());
		dChTextField.setText(b.getdCh());
		rChTextField.setText(b.getrCh());
		dueDateTextField.setText(b.getDueDate());
	}

	public UpdateBillDialog(BillGUI billgui, BillDAO billdao) {
		this(billgui, billdao, null);
	}

	/**
	 * Create the dialog.
	 */
	public UpdateBillDialog() {
		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("Update Bill Record");
		setBounds(600, 400, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 92, 340, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 26, 26, 26, 26, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		// *********************************************************

		{
			JLabel lblbNum = new JLabel("Bill Number");
			GridBagConstraints gbc_lblbNum = new GridBagConstraints();
			gbc_lblbNum.anchor = GridBagConstraints.EAST;
			gbc_lblbNum.insets = new Insets(0, 0, 5, 5);
			gbc_lblbNum.gridx = 0;
			gbc_lblbNum.gridy = 2;
			contentPanel.add(lblbNum, gbc_lblbNum);
		}
		{
			bNumTextField = new JTextField();
			GridBagConstraints gbc_bNumTextField = new GridBagConstraints();
			gbc_bNumTextField.anchor = GridBagConstraints.NORTH;
			gbc_bNumTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_bNumTextField.insets = new Insets(0, 0, 5, 0);
			gbc_bNumTextField.gridx = 1;
			gbc_bNumTextField.gridy = 2;
			contentPanel.add(bNumTextField, gbc_bNumTextField);
			bNumTextField.setColumns(10);
		}

		// *********************************************************

		{
			JLabel lbldCh = new JLabel("Doctor Charge");
			GridBagConstraints gbc_lbldCh = new GridBagConstraints();
			gbc_lbldCh.anchor = GridBagConstraints.EAST;
			gbc_lbldCh.insets = new Insets(0, 0, 5, 5);
			gbc_lbldCh.gridx = 0;
			gbc_lbldCh.gridy = 3;
			contentPanel.add(lbldCh, gbc_lbldCh);
		}
		{
			dChTextField = new JTextField();
			GridBagConstraints gbc_dChTextField = new GridBagConstraints();
			gbc_dChTextField.anchor = GridBagConstraints.NORTH;
			gbc_dChTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_dChTextField.insets = new Insets(0, 0, 5, 0);
			gbc_dChTextField.gridx = 1;
			gbc_dChTextField.gridy = 3;
			contentPanel.add(dChTextField, gbc_dChTextField);
			dChTextField.setColumns(10);
		}

		// *********************************************************

		{
			JLabel lblrCh = new JLabel("Room Charge");
			GridBagConstraints gbc_lblrCh = new GridBagConstraints();
			gbc_lblrCh.anchor = GridBagConstraints.EAST;
			gbc_lblrCh.insets = new Insets(0, 0, 5, 5);
			gbc_lblrCh.gridx = 0;
			gbc_lblrCh.gridy = 4;
			contentPanel.add(lblrCh, gbc_lblrCh);
		}
		{
			rChTextField = new JTextField();
			GridBagConstraints gbc_rChTextField = new GridBagConstraints();
			gbc_rChTextField.anchor = GridBagConstraints.NORTH;
			gbc_rChTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_rChTextField.insets = new Insets(0, 0, 5, 0);
			gbc_rChTextField.gridx = 1;
			gbc_rChTextField.gridy = 4;
			contentPanel.add(rChTextField, gbc_rChTextField);
			rChTextField.setColumns(10);
		}

		// *********************************************************

		{
			JLabel lblDueDate = new JLabel("Due Date");
			GridBagConstraints gbc_lblDueDate = new GridBagConstraints();
			gbc_lblDueDate.anchor = GridBagConstraints.EAST;
			gbc_lblDueDate.insets = new Insets(0, 0, 5, 5);
			gbc_lblDueDate.gridx = 0;
			gbc_lblDueDate.gridy = 5;
			contentPanel.add(lblDueDate, gbc_lblDueDate);
		}
		{
			rChTextField = new JTextField();
			GridBagConstraints gbc_rChTextField = new GridBagConstraints();
			gbc_rChTextField.anchor = GridBagConstraints.NORTH;
			gbc_rChTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_rChTextField.insets = new Insets(0, 0, 5, 0);
			gbc_rChTextField.gridx = 1;
			gbc_rChTextField.gridy = 5;
			contentPanel.add(rChTextField, gbc_rChTextField);
			rChTextField.setColumns(10);
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

		String bNum = bNumTextField.getText();

		String dCh = dChTextField.getText();

		String rCh = rChTextField.getText();

		String dueDate = dueDateTextField.getText();

		Bill temp = null;

		if (bNum.equals("") && dCh.equals("") && rCh.equals("") && dueDate.equals("")) {
			setVisible(false);
			dispose();
			JOptionPane.showMessageDialog(billGUI, "Record is empty!", "Error", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		temp = previousBill;

		temp.setbNum(bNum);
		temp.setdCh(dCh);
		temp.setrCh(rCh);
		temp.setDueDate(dueDate);

		try {

			// Save to the database after updating

			billDAO.updateRecord(temp);

			// Close dialog

			setVisible(false);
			dispose();

			// Refresh GUI list

			billGUI.refreshView();

			// Show success message

			JOptionPane.showMessageDialog(billGUI, "Record updated succesfully.", "", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception exc) {
			JOptionPane.showMessageDialog(billGUI, "Error updating record: " + exc.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}
}
