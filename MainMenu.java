import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class MainMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setMinimumSize(new Dimension(600, 500));
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
	public MainMenu() {
		setResizable(false);
		setTitle("Main Menu");
		setBackground(Color.LIGHT_GRAY);
		setCursor(new Cursor(HAND_CURSOR));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 700, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 30, 30, 30, 0, 30, 30, 30, 30, 30, 30, 30, 30, 30, 0, 30, 0, 0, 30, 30, 30,
				30, 30, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblAhmadAmireh = new JLabel("HOSPITAL X");
		lblAhmadAmireh.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		GridBagConstraints gbc_lblAhmadAmireh = new GridBagConstraints();
		gbc_lblAhmadAmireh.gridwidth = 5;
		gbc_lblAhmadAmireh.insets = new Insets(0, 0, 5, 0);
		gbc_lblAhmadAmireh.gridx = 17;
		gbc_lblAhmadAmireh.gridy = 0;
//		panel.add(this);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 13;
		gbc_panel_1.gridwidth = 10;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 3;
		gbc_panel_1.gridy = 1;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 47, 170, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 169, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel_1 = new JLabel("Furkan Akgun");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		

		JTextPane txtpnTeduHospital = new JTextPane();
		txtpnTeduHospital.setEditable(false);
		txtpnTeduHospital.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		txtpnTeduHospital.setBackground(Color.LIGHT_GRAY);
		txtpnTeduHospital.setText("\nX HOSPITAL");
		GridBagConstraints gbc_txtpnTeduHospital = new GridBagConstraints();
		gbc_txtpnTeduHospital.gridwidth = 3;
		gbc_txtpnTeduHospital.insets = new Insets(0, 0, 5, 0);
		gbc_txtpnTeduHospital.fill = GridBagConstraints.BOTH;
		gbc_txtpnTeduHospital.gridx = 0;
		gbc_txtpnTeduHospital.gridy = 1;
		panel_1.add(txtpnTeduHospital, gbc_txtpnTeduHospital);

		JTextPane txtpnTeduHospitalEstablished = new JTextPane();
		txtpnTeduHospitalEstablished.setBackground(Color.LIGHT_GRAY);
		txtpnTeduHospitalEstablished.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		txtpnTeduHospitalEstablished.setText(
				"\n\nAddress:   xxxx xxxxx Street No: 50 \n\t06420, XXX-xxxx \n\tXXXX / XXX\n\nE-mail:\thastane@xxx.com\n\nPhone:\t+90 (312) 112 00 00 \n\nFax:\t+90 (312) 112 00 00");
		txtpnTeduHospitalEstablished.setEditable(false);
		GridBagConstraints gbc_txtpnTeduHospitalEstablished = new GridBagConstraints();
		gbc_txtpnTeduHospitalEstablished.insets = new Insets(0, 0, 5, 0);
		gbc_txtpnTeduHospitalEstablished.gridheight = 7;
		gbc_txtpnTeduHospitalEstablished.gridwidth = 3;
		gbc_txtpnTeduHospitalEstablished.fill = GridBagConstraints.BOTH;
		gbc_txtpnTeduHospitalEstablished.gridx = 0;
		gbc_txtpnTeduHospitalEstablished.gridy = 2;
		panel_1.add(txtpnTeduHospitalEstablished, gbc_txtpnTeduHospitalEstablished);

		JLabel lblToday = new JLabel("Today:");
		GridBagConstraints gbc_lblToday = new GridBagConstraints();
		gbc_lblToday.anchor = GridBagConstraints.EAST;
		gbc_lblToday.insets = new Insets(0, 0, 5, 5);
		gbc_lblToday.gridx = 0;
		gbc_lblToday.gridy = 9;
		panel_1.add(lblToday, gbc_lblToday);

		String x = LocalDate.now().getDayOfWeek().name();
		String today = x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase();
		
		LocalDate localDate = LocalDate.now();
		
		JLabel lblt = new JLabel(today + ", " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(localDate));
		lblt.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblt = new GridBagConstraints();
		gbc_lblt.anchor = GridBagConstraints.WEST;
		gbc_lblt.insets = new Insets(0, 0, 5, 5);
		gbc_lblt.gridx = 1;
		gbc_lblt.gridy = 9;
		panel_1.add(lblt, gbc_lblt);
		
		JLabel lblTime = new JLabel("Time:");
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblTime.gridx = 0;
		gbc_lblTime.gridy = 11;
		panel_1.add(lblTime, gbc_lblTime);
		
		JLabel lblTt = new JLabel("");
		GridBagConstraints gbc_lblTt = new GridBagConstraints();
		gbc_lblTt.anchor = GridBagConstraints.WEST;
		gbc_lblTt.insets = new Insets(0, 0, 5, 5);
		gbc_lblTt.gridx = 1;
		gbc_lblTt.gridy = 11;
		panel_1.add(lblTt, gbc_lblTt);

		ActionListener currentTime = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Date d = new Date();
				DateFormat df = new SimpleDateFormat("hh:mm:ss a");
				String t = df.format(d);
				lblTt.setText(t);

			}
		};
		Timer timer = new Timer(1000, currentTime);
		timer.setInitialDelay(0);
		timer.start();

		JButton btnDoctors = new JButton("Doctors");
		btnDoctors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DoctorGUI x = new DoctorGUI();
				x.setMinimumSize(new Dimension(1680, 1030));

				// Open the DoctorGUI
				x.setVisible(true);

				// Close the TEDUHospitalGUI
				setVisible(false);

			}
		});

		JSeparator separator_6 = new JSeparator();
		GridBagConstraints gbc_separator_6 = new GridBagConstraints();
		gbc_separator_6.insets = new Insets(0, 0, 20, 5);
		gbc_separator_6.gridx = 14;
		gbc_separator_6.gridy = 3;
		panel.add(separator_6, gbc_separator_6);

		JLabel lblSignedInAt = new JLabel("Signed in at:");
		GridBagConstraints gbc_lblSignedInAt = new GridBagConstraints();
		gbc_lblSignedInAt.anchor = GridBagConstraints.EAST;
		gbc_lblSignedInAt.insets = new Insets(0, 0, 5, 5);
		gbc_lblSignedInAt.gridx = 14;
		gbc_lblSignedInAt.gridy = 4;
		panel.add(lblSignedInAt, gbc_lblSignedInAt);

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");

		JLabel lbltime = new JLabel(sdf.format(cal.getTime()));
		GridBagConstraints gbc_lbltime = new GridBagConstraints();
		gbc_lbltime.anchor = GridBagConstraints.WEST;
		gbc_lbltime.gridwidth = 3;
		gbc_lbltime.insets = new Insets(0, 0, 5, 5);
		gbc_lbltime.gridx = 15;
		gbc_lbltime.gridy = 4;
		panel.add(lbltime, gbc_lbltime);

		JSeparator separator_7 = new JSeparator();
		GridBagConstraints gbc_separator_7 = new GridBagConstraints();
		gbc_separator_7.insets = new Insets(0, 0, 5, 5);
		gbc_separator_7.gridx = 16;
		gbc_separator_7.gridy = 5;
		panel.add(separator_7, gbc_separator_7);

		JSeparator separator_4 = new JSeparator();
		GridBagConstraints gbc_separator_4 = new GridBagConstraints();
		gbc_separator_4.insets = new Insets(0, 0, 5, 30);
		gbc_separator_4.gridx = 13;
		gbc_separator_4.gridy = 6;
		panel.add(separator_4, gbc_separator_4);
		btnDoctors.setMinimumSize(new Dimension(95, 30));
		GridBagConstraints gbc_btnDoctors = new GridBagConstraints();
		gbc_btnDoctors.ipady = 50;
		gbc_btnDoctors.ipadx = 50;
		gbc_btnDoctors.insets = new Insets(0, 0, 5, 5);
		gbc_btnDoctors.gridx = 14;
		gbc_btnDoctors.gridy = 6;
		panel.add(btnDoctors, gbc_btnDoctors);

		JButton btnNurses = new JButton("Nurses");
		btnNurses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				NurseGUI x = new NurseGUI();
				x.setMinimumSize(new Dimension(1680, 1030));

				// Open the DoctorGUI
				x.setVisible(true);

				// Close the TEDUHospitalGUI
				setVisible(false);

			}
		});

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 30);
		gbc_separator.gridx = 15;
		gbc_separator.gridy = 6;
		panel.add(separator, gbc_separator);
		btnNurses.setMinimumSize(new Dimension(95, 30));
		GridBagConstraints gbc_btnNurses = new GridBagConstraints();
		gbc_btnNurses.ipady = 50;
		gbc_btnNurses.ipadx = 50;
		gbc_btnNurses.insets = new Insets(0, 0, 5, 5);
		gbc_btnNurses.gridx = 17;
		gbc_btnNurses.gridy = 6;
		panel.add(btnNurses, gbc_btnNurses);

		JButton btnRooms = new JButton("Rooms");
		btnRooms.setMinimumSize(new Dimension(95, 30));
		btnRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RoomGUI x = new RoomGUI();
				x.setMinimumSize(new Dimension(1680, 1030));

				// Open the PatientGUI
				x.setVisible(true);

				// Close the TEDUHospitalGUI
				setVisible(false);

			}
		});

		JButton btnPatients = new JButton("Patients");
		btnPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PatientGUI x = new PatientGUI();
				x.setMinimumSize(new Dimension(1680, 1030));

				// Open the PatientGUI
				x.setVisible(true);

				// Close the TEDUHospitalGUI
				setVisible(false);

			}
		});

		JSeparator separator_3 = new JSeparator();
		GridBagConstraints gbc_separator_3 = new GridBagConstraints();
		gbc_separator_3.insets = new Insets(0, 0, 20, 5);
		gbc_separator_3.gridx = 14;
		gbc_separator_3.gridy = 7;
		panel.add(separator_3, gbc_separator_3);
		btnPatients.setMinimumSize(new Dimension(95, 30));
		GridBagConstraints gbc_btnPatients = new GridBagConstraints();
		gbc_btnPatients.ipadx = 50;
		gbc_btnPatients.ipady = 50;
		gbc_btnPatients.insets = new Insets(0, 0, 5, 5);
		gbc_btnPatients.gridx = 14;
		gbc_btnPatients.gridy = 8;
		panel.add(btnPatients, gbc_btnPatients);
		GridBagConstraints gbc_btnRooms = new GridBagConstraints();
		gbc_btnRooms.ipady = 50;
		gbc_btnRooms.ipadx = 50;
		gbc_btnRooms.insets = new Insets(0, 0, 5, 5);
		gbc_btnRooms.gridx = 17;
		gbc_btnRooms.gridy = 8;
		panel.add(btnRooms, gbc_btnRooms);

		JButton btnRecords = new JButton("Records");
		btnRecords.setMinimumSize(new Dimension(95, 30));
		btnRecords.addActionListener(new ActionListener() {
			//It should change with users GUI
				public void actionPerformed(ActionEvent e) {

					RecordsGUI x = new RecordsGUI();
					x.setMinimumSize(new Dimension(1680, 1030));

					// Open the PatientGUI
					x.setVisible(true);

					// Close the TEDUHospitalGUI
					setVisible(false);

				}
			});

		JButton btnBills = new JButton("Bills");
		btnBills.setMinimumSize(new Dimension(95, 30));
		btnBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BillGUI x = new BillGUI();
				x.setMinimumSize(new Dimension(1680, 1030));

				// Open the PatientGUI
				x.setVisible(true);

				// Close the TEDUHospitalGUI
				setVisible(false);

			}
		});

		JSeparator separator_2 = new JSeparator();
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.insets = new Insets(0, 0, 20, 5);
		gbc_separator_2.gridx = 14;
		gbc_separator_2.gridy = 9;
		panel.add(separator_2, gbc_separator_2);
		GridBagConstraints gbc_btnBills = new GridBagConstraints();
		gbc_btnBills.anchor = GridBagConstraints.NORTH;
		gbc_btnBills.ipady = 50;
		gbc_btnBills.ipadx = 50;
		gbc_btnBills.insets = new Insets(0, 0, 5, 5);
		gbc_btnBills.gridx = 14;
		gbc_btnBills.gridy = 10;
		panel.add(btnBills, gbc_btnBills);
		GridBagConstraints gbc_btnRecords = new GridBagConstraints();
		gbc_btnRecords.ipady = 50;
		gbc_btnRecords.ipadx = 50;
		gbc_btnRecords.insets = new Insets(0, 0, 5, 5);
		gbc_btnRecords.gridx = 17;
		gbc_btnRecords.gridy = 10;
		panel.add(btnRecords, gbc_btnRecords);

		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 20, 5);
		gbc_separator_1.gridx = 14;
		gbc_separator_1.gridy = 11;
		panel.add(separator_1, gbc_separator_1);

		JButton btnUsers = new JButton("Users");
		btnUsers.setMinimumSize(new Dimension(95, 30));
		GridBagConstraints gbc_btnUsers = new GridBagConstraints();
		gbc_btnUsers.ipadx = 50;
		gbc_btnUsers.ipady = 50;
		gbc_btnUsers.insets = new Insets(0, 0, 5, 5);
		gbc_btnUsers.gridx = 14;
		gbc_btnUsers.gridy = 12;
		panel.add(btnUsers, gbc_btnUsers);
		

		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setMinimumSize(new Dimension(95, 30));
		GridBagConstraints gbc_btnSignOut = new GridBagConstraints();
		gbc_btnSignOut.ipady = 50;
		gbc_btnSignOut.ipadx = 50;
		gbc_btnSignOut.insets = new Insets(0, 0, 5, 5);
		gbc_btnSignOut.gridx = 17;
		gbc_btnSignOut.gridy = 12;
		panel.add(btnSignOut, gbc_btnSignOut);
		btnSignOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});

		JSeparator separator_5 = new JSeparator();
		GridBagConstraints gbc_separator_5 = new GridBagConstraints();
		gbc_separator_5.insets = new Insets(0, 0, 30, 5);
		gbc_separator_5.gridx = 14;
		gbc_separator_5.gridy = 13;
		panel.add(separator_5, gbc_separator_5);

		JLabel lblNewLabel = new JLabel("Copyright © 2019 X Hospital. All Rights Reserved.");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 16;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 14;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel2 = new JLabel("XXXX");
		GridBagConstraints gbc_lblNewLabel2 = new GridBagConstraints();
		gbc_lblNewLabel2.gridwidth = 16;
		gbc_lblNewLabel2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel2.gridx = 3;
		gbc_lblNewLabel2.gridy = 15;
		panel.add(lblNewLabel2, gbc_lblNewLabel2);
	}

}
