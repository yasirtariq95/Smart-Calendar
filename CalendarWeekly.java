import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class CalendarWeekly {
	Calendar cal = new GregorianCalendar();
	JLabel monthLabel;
	JButton[] dayButton = new JButton[7];
	JPanel p1 = new JPanel(new GridLayout(1, 7));
	int month = Calendar.getInstance().get(Calendar.MONTH);
	int year = Calendar.getInstance().get(Calendar.YEAR);
	int week = Calendar.getInstance().get(Calendar.WEEK_OF_MONTH);
	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarWeekly window = new CalendarWeekly();
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
	public CalendarWeekly() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 255));
		frame.getContentPane().setFont(new Font("Berlin Sans FB", Font.PLAIN, 11));
		frame.setTitle("Personal Calendar");
		frame.setSize(1000,700);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);


		monthLabel = new JLabel();
		monthLabel.setBounds(338, 56, 283, 27);
		monthLabel.setBackground(Color.BLACK);
		monthLabel.setForeground(Color.BLACK);
		frame.getContentPane().add(monthLabel);
		monthLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		monthLabel.setHorizontalAlignment(SwingConstants.CENTER);

		p1.setBounds(94, 121, 788, 350);
		frame.getContentPane().add(p1);

		for(int x = 0; x < dayButton.length; x++){

			dayButton[x] = new JButton();
			dayButton[x].setFocusPainted(false);
			dayButton[x].setBackground(Color.white);

			p1.add(dayButton[x]);
		};

		JButton prevMonth = new JButton("<<");
		prevMonth.setBounds(59, 58, 56, 29);
		frame.getContentPane().add(prevMonth);
		prevMonth.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		prevMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cal.add(Calendar.WEEK_OF_MONTH, -1);
				week--;
				updateWeek();
			}
		});

		JButton nextMonth = new JButton(">>");
		nextMonth.setBounds(848, 58, 66, 29);
		frame.getContentPane().add(nextMonth);
		nextMonth.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		nextMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cal.add(Calendar.WEEK_OF_MONTH, +1);
				week++;
				updateWeek();
			}
		});

		this.updateWeek();

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
		chckbxMonthly.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		frame.getContentPane().add(chckbxMonthly);
		chckbxMonthly.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					CalendarMonthly monthly = new CalendarMonthly();
					monthly.CalendarMonthly();
				};
			}
		});

		JCheckBox chckbxWeekly = new JCheckBox("Weekly");
		chckbxWeekly.setSelected(true);
		chckbxWeekly.setBounds(462, 601, 97, 38);
		chckbxWeekly.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		frame.getContentPane().add(chckbxWeekly);

		JCheckBox chckbxDaily = new JCheckBox("Daily");
		chckbxDaily.setBounds(845, 601, 69, 38);
		chckbxDaily.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		frame.getContentPane().add(chckbxDaily);
		chckbxDaily.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					CalendarDaily daily = new CalendarDaily();
					daily.CalendarDaily();
				};
			}
		});
	}

	void updateWeek() {	
		Calendar cal2 = new GregorianCalendar();
		int year = cal.get(Calendar.YEAR);
		int day = cal.get(Calendar.DATE);
		int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int dayOfWeek2 = day - dayOfWeek+1;

		monthLabel.setText(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + " " + year);

		String [] columns = {"Sun.","Mon.","Tue.","Wed.","Thu.","Fri.","Sat."};


		for(int x = 0; x < dayButton.length; x++) {

			if (dayOfWeek2 <= 0 ){
				dayOfWeek2 = daysInMonth-dayOfWeek+1;
			} else if (dayOfWeek2 > daysInMonth-1 && cal.get(Calendar.MONTH) == 11) {
				dayOfWeek2 = 1;
			}  else if (dayOfWeek2 > daysInMonth) {
				dayOfWeek2 = 1;
			}

			dayButton[x].setVerticalAlignment(SwingConstants.TOP);
			dayButton[x].setText(columns[x] + " " + dayOfWeek2);

			if (dayOfWeek2 == cal2.get(Calendar.DATE) && cal.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) 
					&& cal.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)) {	// Current Day
				dayButton[x].setBackground(new Color(51,153,255));
			}else {
				dayButton[x].setBackground(Color.white);
			}

			dayOfWeek2++;
		}
	}

	public void CalendarWeekly() {
		// TODO Auto-generated method stub

	}
}
