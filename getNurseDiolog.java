import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class getNurseDiolog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private RoomGUI RoomGUI;
	private RoomDAO RoomDAO;
	private Room Room;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			getNurseDiolog dialog = new getNurseDiolog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public getNurseDiolog(RoomGUI roomGUI, RoomDAO roomDAO, Room room) {
		this();
		this.RoomGUI = roomGUI;
		this.RoomDAO = roomDAO;
		this.Room = room;
	}

	/**
	 * Create the dialog.
	 */
	public getNurseDiolog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			{
				JLabel lblNewLabel = new JLabel("Nurse ID");
				contentPanel.add(lblNewLabel);
				textField = new JTextField();
				contentPanel.add(textField);
				textField.setColumns(10);
			}

			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String NurseID = textField.getText();
						if (NurseID.equals("")) {
							JOptionPane.showMessageDialog(RoomGUI, "Record is empty!", "Error",
									JOptionPane.INFORMATION_MESSAGE);
						}
						try {
							AssignNurse(NurseID);
							System.out.println("Nurse id assigned");
							setVisible(false);
							dispose();
							RoomGUI.refreshView();
							JOptionPane.showMessageDialog(RoomGUI, "Nurse assigned succesfully.", "",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (Exception ee) {
							JOptionPane.showMessageDialog(RoomGUI, "Error assignin record: Nurse with ID does not exist " + ee.getMessage(), "Nurse with ID does not exist",
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

	public void AssignNurse(String nurseID) {
		String NurseID = textField.getText();
		try {
			RoomDAO = new RoomDAO();
			RoomDAO.AssignNurse(Room, NurseID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
