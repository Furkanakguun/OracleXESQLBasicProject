import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
//Assing DOCTOR to PATIENT
public class getPatietnDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private PatientDAO patientDAO;
	private PatientGUI patientGUI;
	private DoctorDAO doctordao;
	private DoctorGUI doctorgui;
	private Patient patient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			getPatietnDialog dialog = new getPatietnDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public getPatietnDialog(PatientGUI patientgui,PatientDAO patientdao,Patient ispatient) {
		this();
		this.patientGUI=patientgui;
		this.patientDAO=patientdao;
		this.patient=ispatient;
		
	}

	/**
	 * Create the dialog.
	 */
	public getPatietnDialog() {
		setResizable(false);
		setBounds(100, 100, 450, 300);
		setBackground(Color.BLUE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		//***************************************************//
		
		{
			JLabel lblNewLabel = new JLabel("Doctor ID");
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			contentPanel.add(textField);
			textField.setColumns(10);
		}
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
					public void actionPerformed(ActionEvent arg0) {
						String DoctorID = textField.getText();
						if(DoctorID.equals("")) {
							JOptionPane.showMessageDialog(patientGUI, "Record is empty!", "Error", JOptionPane.INFORMATION_MESSAGE);
						}
						try {
							AssignDoctorToPatient(DoctorID);
							JOptionPane.showMessageDialog(patientGUI, "Doctor assigned succesfully.", "",
									JOptionPane.INFORMATION_MESSAGE);
							setVisible(false);
							dispose();
							patientGUI.refreshView();

						}catch (Exception ee) {
							JOptionPane.showMessageDialog(patientGUI, "Error assignin record: " + ee.getMessage(), "Error",
									JOptionPane.ERROR_MESSAGE);	
							ee.printStackTrace();
							}
						
					}
				});
				
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
			}
		}
	}
	public void AssignDoctorToPatient(String doctorID) {
		
		String DoctorID = textField.getText();
		
		try {
			try {
				doctordao = new DoctorDAO();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			doctordao.AssingPatient(patient, DoctorID);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
