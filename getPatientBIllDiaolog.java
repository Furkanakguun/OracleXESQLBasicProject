import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.print.Doc;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class getPatientBIllDiaolog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private int
	private BillGUI billGUI;
	private BillDAO billDAO;
	private Bill bill;
	private Patient patient;
	private PatientDAO patientDAO;
	private PatientGUI patientgui;
	private final JPanel contentPanel = new JPanel();
	private final JLabel lblNewLabel = new JLabel("Nurse fee");
	private final JLabel lblNewLabel_2 = new JLabel("Doctor fee");
	private final JLabel lblNewLabel_1 = new JLabel("Room fee");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			getPatientBIllDiaolog dialog = new getPatientBIllDiaolog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public getPatientBIllDiaolog(PatientGUI ispatientgui,PatientDAO ispatientdao,Patient ispatient) {
		this();
		this.patient=ispatient;
		this.patientDAO=ispatientdao;
		this.patientgui=ispatientgui;
	}

	/**
	 * Create the dialog.
	 */
	public getPatientBIllDiaolog() {
		setTitle("Assign Bill");
		setResizable(false);
		setBounds(200, 200, 550, 400);
		setLocation(getHeight() / 2, getWidth() / 2);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

		
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						AssignBill();
						
					}
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			contentPanel.add(lblNewLabel);
			{
				textField_1 = new JTextField();
				contentPanel.add(textField_1);
				textField_1.setColumns(10);
			}
			contentPanel.add(lblNewLabel_2);
			{
				textField_2 = new JTextField();
				contentPanel.add(textField_2);
				textField_2.setColumns(10);
			}
			contentPanel.add(lblNewLabel_1);
			{
				textField = new JTextField();
				contentPanel.add(textField);
				textField.setColumns(10);
			}
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(176)
						.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(188, Short.MAX_VALUE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(42)
						.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(42, Short.MAX_VALUE))
			);
			
						JLabel lblNewLabel_3 = new JLabel("Due Date");
						contentPanel.add(lblNewLabel_3);
			
						textField_3 = new JTextField();
						contentPanel.add(textField_3);
						textField_3.setColumns(10);
						
						JLabel lblNewLabel_4 = new JLabel("Bill Number");
						contentPanel.add(lblNewLabel_4);
						
						textField_4 = new JTextField();
						contentPanel.add(textField_4);
						textField_4.setColumns(10);
			panel.setLayout(gl_panel);
		}
	}

	protected void AssignBill() {
		
		String Nursefee = textField.getText();
		
		String Doctorfee = textField_1.getText();
		
		String Roomfee = textField_2.getText();
		
		String DueDate =textField_3.getText();
		
		String BillNo=textField_4.getText();
		
		float Total=0;
		
		
		if (Nursefee.equals("") && Doctorfee.equals("") && Roomfee.equals("") && DueDate.equals("") ) {
			setVisible(false);
			dispose();
			JOptionPane.showMessageDialog(billGUI, "Record is empty!", "Error", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		try {
			 Total = Float.parseFloat(Nursefee)+Float.parseFloat(Doctorfee)+Float.parseFloat(Roomfee);
			 
			System.out.println(Total+"test1");

		}catch (Exception e) {
			System.out.println("Please give numbers");
			JOptionPane.showMessageDialog(billGUI, "Please give Numbers", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		
		//Bill b = new Bill(BillNo, Total, Float.parseFloat(Doctorfee), Float.parseFloat(Nursefee), Float.parseFloat(Roomfee), DueDate);
		
		try {
			bill = new Bill(BillNo, Float.toString(Total), Doctorfee, Nursefee, Roomfee, DueDate,patient.getpSSN());
			billDAO=new BillDAO();
			billDAO.addRecord(bill);
			setVisible(false);
			dispose();
			JOptionPane.showMessageDialog(billGUI, "Record added succesfully.", "",
					JOptionPane.INFORMATION_MESSAGE);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(billGUI, "Error adding record: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
