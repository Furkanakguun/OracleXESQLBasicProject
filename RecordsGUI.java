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

public class RecordsGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTable table;
	private RecordsDAO recordsDAO;
	private JTextField pSSNTextField;
	private JTextField docIDTextField;
	private JTextField nurseIDTextField;
	private JTextField roomNOTextField;
	private JTextField billNOTextField;

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
	public RecordsGUI() {
		setBackground(Color.LIGHT_GRAY);

		try {
			recordsDAO=new RecordsDAO();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		setTitle("Records");
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

		JLabel lblPatientName = new JLabel("Patient ID");
		GridBagConstraints gbc_lblPatientName = new GridBagConstraints();
		gbc_lblPatientName.anchor = GridBagConstraints.EAST;
		gbc_lblPatientName.insets = new Insets(0, 0, 0, 5);
		gbc_lblPatientName.gridx = 0;
		gbc_lblPatientName.gridy = 0;
		panel.add(lblPatientName, gbc_lblPatientName);

		pSSNTextField = new JTextField();
		GridBagConstraints gbc_bNumTextField = new GridBagConstraints();
		gbc_bNumTextField.insets = new Insets(0, 0, 0, 5);
		gbc_bNumTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_bNumTextField.gridx = 1;
		gbc_bNumTextField.gridy = 0;
		panel.add(pSSNTextField, gbc_bNumTextField);
		pSSNTextField.setColumns(10);

		JLabel lblBillTotal = new JLabel("Doctor ID");
		GridBagConstraints gbc_lblBillTotal = new GridBagConstraints();
		gbc_lblBillTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblBillTotal.gridx = 2;
		gbc_lblBillTotal.gridy = 0;
		panel.add(lblBillTotal, gbc_lblBillTotal);

		docIDTextField = new JTextField();
		GridBagConstraints gbc_totalTextField = new GridBagConstraints();
		gbc_totalTextField.insets = new Insets(0, 0, 0, 5);
		gbc_totalTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_totalTextField.gridx = 3;
		gbc_totalTextField.gridy = 0;
		panel.add(docIDTextField, gbc_totalTextField);
		docIDTextField.setColumns(10);

		JLabel lblDoctorCharge = new JLabel("Nurse ID");
		GridBagConstraints gbc_lblDoctorCharge = new GridBagConstraints();
		gbc_lblDoctorCharge.insets = new Insets(0, 0, 0, 5);
		gbc_lblDoctorCharge.gridx = 4;
		gbc_lblDoctorCharge.gridy = 0;
		panel.add(lblDoctorCharge, gbc_lblDoctorCharge);

		nurseIDTextField = new JTextField();
		GridBagConstraints gbc_dChTextField = new GridBagConstraints();
		gbc_dChTextField.insets = new Insets(0, 0, 0, 5);
		gbc_dChTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_dChTextField.gridx = 5;
		gbc_dChTextField.gridy = 0;
		panel.add(nurseIDTextField, gbc_dChTextField);
		nurseIDTextField.setColumns(10);

		JLabel lblNurseCharge = new JLabel("Room No");
		GridBagConstraints gbc_lblNurseCharge = new GridBagConstraints();
		gbc_lblNurseCharge.insets = new Insets(0, 0, 0, 5);
		gbc_lblNurseCharge.gridx = 6;
		gbc_lblNurseCharge.gridy = 0;
		panel.add(lblNurseCharge, gbc_lblNurseCharge);

		roomNOTextField = new JTextField();
		GridBagConstraints gbc_nChTextField = new GridBagConstraints();
		gbc_nChTextField.insets = new Insets(0, 0, 0, 5);
		gbc_nChTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nChTextField.gridx = 7;
		gbc_nChTextField.gridy = 0;
		panel.add(roomNOTextField, gbc_nChTextField);
		roomNOTextField.setColumns(10);

		JLabel lblRoomCharge = new JLabel("Bill No");
		GridBagConstraints gbc_lblRoomCharge = new GridBagConstraints();
		gbc_lblRoomCharge.insets = new Insets(0, 0, 0, 5);
		gbc_lblRoomCharge.gridx = 8;
		gbc_lblRoomCharge.gridy = 0;
		panel.add(lblRoomCharge, gbc_lblRoomCharge);

		billNOTextField = new JTextField();
		GridBagConstraints gbc_rChTextField = new GridBagConstraints();
		gbc_rChTextField.insets = new Insets(0, 0, 0, 5);
		gbc_rChTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_rChTextField.gridx = 9;
		gbc_rChTextField.gridy = 0;
		panel.add(billNOTextField, gbc_rChTextField);
		billNOTextField.setColumns(10);


		// **************************************************************************************
		// Search button actions

		JButton btnSearch = new JButton("Search");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 0, 5);
		gbc_btnSearch.gridx = 12;
		gbc_btnSearch.gridy = 0;
		panel.add(btnSearch, gbc_btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				{
					try {

						// Get the parameters from the input text fields

						String pSSN = pSSNTextField.getText();

						String docID = docIDTextField.getText();

						String nurseID = nurseIDTextField.getText();

						String roomNO = roomNOTextField.getText();

						String billNO = billNOTextField.getText();
						
						
						// Create an ArrayList

						List<Records> list = null;

						 {
							 if(pSSN != null && pSSN.trim().length() > 0) {
								 list = recordsDAO.searchpID(pSSN);
							 } else if(docID != null && docID.trim().length() > 0) {
								 list = recordsDAO.searchDID(docID);
							 } else if(nurseID != null && nurseID.trim().length() > 0) {
								 list = recordsDAO.searchnID(nurseID);
							 } else if(roomNO != null && roomNO.trim().length() > 0) {
								 list = recordsDAO.searchrNO(roomNO);
							 } else if(billNO != null && billNO.trim().length() > 0){
								 list = recordsDAO.searchbNo(billNO);
							 }else {
							list = recordsDAO.getAllRecords();
							 }
						}

						// Create the table view and update the main table

						RecordsTableModel model = new RecordsTableModel(list);

						table.setModel(model);

						return;

					} catch (Exception exc) {
						JOptionPane.showMessageDialog(RecordsGUI.this, "Error: " + exc, "Error",
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
			List<Records> b = recordsDAO.getAllRecords();

			// create the model and update the "table"
			RecordsTableModel view = new RecordsTableModel(b);

			table.setModel(view);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
}
