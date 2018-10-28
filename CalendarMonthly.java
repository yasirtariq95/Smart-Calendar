import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class CalendarMonthly {
	DefaultTableModel model;
	Calendar cal = new GregorianCalendar();
	JLabel monthLabel;
	JButton[] dayButton = new JButton[49];
	JPanel p1 = new JPanel(new GridLayout(7, 7));
	int month = Calendar.getInstance().get(Calendar.MONTH);
	int year = Calendar.getInstance().get(Calendar.YEAR);
	private JFrame frame;

	
	/**
	 * Launch the application.
	 */
	public static void CalendarMonthly() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarMonthly window = new CalendarMonthly();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the application.
	 */
	public CalendarMonthly() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 255));
		frame.getContentPane().setFont(new Font("Berlin Sans FB", Font.PLAIN, 11));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Personal Calendar");
		frame.setSize(1000,700);
		frame.setVisible(true);

		String [] columns = {"Sunday","Monday","Tueday","Wednesday","Thursday","Friday","Saturday"};
		model = new DefaultTableModel(null,columns);
		frame.getContentPane().setLayout(null);

		monthLabel = new JLabel();
		monthLabel.setBounds(338, 56, 283, 27);
		monthLabel.setBackground(Color.BLACK);
		monthLabel.setForeground(Color.BLACK);
		frame.getContentPane().add(monthLabel);
		monthLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		monthLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel p1 = new JPanel(new GridLayout(7, 7));
		p1.setBounds(94, 121, 788, 350);
		frame.getContentPane().add(p1);

		for(int x = 0; x < dayButton.length; x++){

			dayButton[x] = new JButton();

			dayButton[x].setFocusPainted(false);
			dayButton[x].setBackground(Color.white);

			if(x < 7)
			{
				dayButton[x].setText(columns[x]);
				dayButton[x].setBackground(Color.LIGHT_GRAY);
			}

			p1.add(dayButton[x]);
		}

		JButton prevMonth = new JButton("<<");
		prevMonth.setBounds(59, 58, 56, 29);
		frame.getContentPane().add(prevMonth);
		prevMonth.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		prevMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cal.add(Calendar.MONTH, -1);
				month--;
				updateMonth();
			}
		});

		JButton nextMonth = new JButton(">>");
		nextMonth.setBounds(848, 58, 66, 29);
		frame.getContentPane().add(nextMonth);
		nextMonth.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		nextMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cal.add(Calendar.MONTH, +1);
				month++;
				updateMonth();
			}
		});

		this.updateMonth();
		
		JButton addEvent = new JButton("+");
		addEvent.setBounds(856, 18, 42, 27);
		addEvent.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		addEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddEvent addEvent = new AddEvent();
				addEvent.AddEvent();
			}
		});
		frame.getContentPane().add(addEvent);

		JLabel lblEvents = new JLabel("Events");
		lblEvents.setBounds(908, 15, 66, 32);
		lblEvents.setLabelFor(addEvent);
		lblEvents.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		frame.getContentPane().add(lblEvents);

		JCheckBox chckbxMonthly = new JCheckBox("Monthly");
		chckbxMonthly.setBounds(60, 601, 97, 38);
		chckbxMonthly.setSelected(true);
		chckbxMonthly.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		frame.getContentPane().add(chckbxMonthly);

		JCheckBox chckbxWeekly = new JCheckBox("Weekly");
		chckbxWeekly.setBounds(462, 601, 97, 38);
		chckbxWeekly.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		frame.getContentPane().add(chckbxWeekly);

		JCheckBox chckbxDaily = new JCheckBox("Daily");
		chckbxDaily.setBounds(845, 601, 69, 38);
		chckbxDaily.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		frame.getContentPane().add(chckbxDaily);

		/*JComboBox comboBoxContacts = new JComboBox();
		comboBoxContacts.setBounds(10, 21, 113, 22);
		comboBoxContacts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		comboBoxContacts.setEditable(true);
		comboBoxContacts.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		frame.getContentPane().add(comboBoxContacts);
		

		JLabel lblContact = new JLabel("Contacts");
		lblContact.setBounds(128, 15, 78, 30);
		lblContact.setLabelFor(comboBoxContacts);
		lblContact.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		frame.getContentPane().add(lblContact);
		*/
	}


	void updateMonth() {	
		int year = cal.get(Calendar.YEAR);
		monthLabel.setText(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + " " + year);

		for(int x = 7; x < dayButton.length; x++) {
			dayButton[x].setText("");
		}

		Calendar cal = Calendar.getInstance();
		cal.set(year, month, 1);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		for(int x = 6+ dayOfWeek, day = 1; day <= daysInMonth; x++, day++){
			dayButton[x].setText("" + day);
			dayButton[x].setBackground(Color.white);
		}
	}
}
