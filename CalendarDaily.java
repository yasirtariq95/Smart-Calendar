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

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class CalendarDaily {
	Calendar cal = new GregorianCalendar();
	int month = Calendar.getInstance().get(Calendar.MONTH);
	int year = Calendar.getInstance().get(Calendar.YEAR);
	JLabel dayLabel;
	int day = Calendar.getInstance().get(Calendar.DATE);
	JButton dayButton = new JButton();
	JPanel p1 = new JPanel(new GridLayout(1, 1));

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main (String [] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarDaily window = new CalendarDaily();
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
	public CalendarDaily() {
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
		

		dayLabel = new JLabel();
		dayLabel.setBounds(146, 56, 692, 27);
		dayLabel.setBackground(Color.BLACK);
		dayLabel.setForeground(Color.BLACK);
		frame.getContentPane().add(dayLabel);
		dayLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		p1.setBounds(94, 121, 788, 350);
		frame.getContentPane().add(p1);

		dayButton = new JButton();
		dayButton.setFocusPainted(false);
		dayButton.setBackground(Color.white);
		p1.add(dayButton);
		
		JButton prevDay = new JButton("<<");
		prevDay.setBounds(59, 58, 56, 29);
		frame.getContentPane().add(prevDay);
		prevDay.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		prevDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cal.add(Calendar.DATE, -1);
				day--;
				updateDay();
			}

		});

		JButton nextMonth = new JButton(">>");
		nextMonth.setBounds(848, 58, 66, 29);
		frame.getContentPane().add(nextMonth);
		nextMonth.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		nextMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cal.add(Calendar.DATE, +1);
				day++;
				updateDay();
			}
		});

		this.updateDay();

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
					frame.setVisible(false);
				};
			}
		});

		JCheckBox chckbxWeekly = new JCheckBox("Weekly");
		chckbxWeekly.setBounds(462, 601, 97, 38);
		chckbxWeekly.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		frame.getContentPane().add(chckbxWeekly);
		chckbxWeekly.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					CalendarWeekly weekly = new CalendarWeekly();
					weekly.CalendarWeekly();
					frame.setVisible(false);
				};
			}
		});

		JCheckBox chckbxDaily = new JCheckBox("Daily");
		chckbxDaily.setSelected(true);
		chckbxDaily.setBounds(845, 601, 69, 38);
		chckbxDaily.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		frame.getContentPane().add(chckbxDaily);
		chckbxDaily.isSelected();

	}

	private void updateDay() {
		Calendar cal2 = new GregorianCalendar();
		int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int year = cal.get(Calendar.YEAR);
		int eventMonth = dbconnection.getEventMonth();
		int eventDay = dbconnection.getEventDay();
		String eventName = dbconnection.getEventName();
		String eventLoc = dbconnection.getEventLoc();

		if (day <= 0 ){
			day = daysInMonth;
		}else if (day > daysInMonth ){
			day = 1;
		}

		dayLabel.setText(cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US) + ", " + 
				cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + " " + day + ", " + year);
		
		dayButton.setVerticalAlignment(SwingConstants.TOP);
		
		if (eventMonth == month+1 && eventDay == day ) {
			dayButton.setText("<html>" + day + "<br><br><br>" + "Event: " + eventName +
					"<br><br>" + "Location: " + eventLoc);
		} else {
			dayButton.setText("" + day);
		}
				
		if (day == cal2.get(Calendar.DATE) && month == cal2.get(Calendar.MONTH) && year == cal2.get(Calendar.YEAR)) {	// Current Day
			dayButton.setBackground(new Color(51,153,255));
		}else {
			dayButton.setBackground(Color.white);
		}
	}

	public void CalendarDaily() {
		// TODO Auto-generated method stub
		
	}

}
