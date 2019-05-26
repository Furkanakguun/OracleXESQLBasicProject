import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class getRoomDiolog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private PatientGUI patientGUI;
	private RoomDAO roomDAO;
	private RoomGUI roomGUI;
	private Patient patient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			getRoomDiolog dialog = new getRoomDiolog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public getRoomDiolog(PatientGUI patientgui,Patient ispatient) {
		this();
		this.patientGUI=patientgui;
		this.patient=ispatient;
	}

	/**
	 * Create the dialog.
	 */
	public getRoomDiolog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblNewLabel = new JLabel("Room No");
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
					public void actionPerformed(ActionEvent e) {
						String RoomNo = textField.getText();
						if(RoomNo.equals("")) {
							JOptionPane.showMessageDialog(patientGUI, "Record is empty!", "Error", JOptionPane.INFORMATION_MESSAGE);
						}
						try {
							AssingRoomToPatient(RoomNo);
							JOptionPane.showMessageDialog(patientGUI, "Room assigned succesfully.", "",
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
			}
		}
	}
	public void AssingRoomToPatient(String patientID) {
		String PatientID = textField.getText();
		try {
			roomDAO = new RoomDAO();
			roomDAO.AssignPatient(patient, PatientID);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
