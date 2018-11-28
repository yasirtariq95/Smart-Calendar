import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class CalendarMonthly {
	Calendar cal = new GregorianCalendar();
	JLabel monthLabel;
	JButton[] dayButton = new JButton[49];
	JPanel p1 = new JPanel(new GridLayout(7, 7));
	int month = Calendar.getInstance().get(Calendar.MONTH);
	int year = Calendar.getInstance().get(Calendar.YEAR);
	JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();


	/**
	 * Launch the application.
	 */
	public static void main(String[]args) {
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
                        
                        
                          dayButton[x].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae) {
                        
                        
                    }
                });
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
		buttonGroup.add(chckbxMonthly);
		chckbxMonthly.setBounds(60, 601, 97, 38);
		chckbxMonthly.setSelected(true);
		chckbxMonthly.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		frame.getContentPane().add(chckbxMonthly);
		

		JCheckBox chckbxWeekly = new JCheckBox("Weekly");
		buttonGroup.add(chckbxWeekly);
		chckbxWeekly.setBounds(462, 601, 97, 38);
		chckbxWeekly.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		frame.getContentPane().add(chckbxWeekly);
		chckbxWeekly.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					CalendarWeekly weekly = new CalendarWeekly();
					weekly.CalendarWeekly();
				};
			}
		});
		

		JCheckBox chckbxDaily = new JCheckBox("Daily");
		buttonGroup.add(chckbxDaily);
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


	void updateMonth() {	
		
            		Calendar cal2 = new GregorianCalendar();
		int year = cal.get(Calendar.YEAR);
		int day = cal.get(Calendar.DATE);
		int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int dayOfWeek2 = day - dayOfWeek+1;
		int eventMonth = dbconnection.getEventMonth();
		int eventDay = dbconnection.getEventDay();
                int dayInMonth = cal.get(Calendar.DAY_OF_MONTH);
		String eventName = dbconnection.getEventName();
		String eventLoc = dbconnection.getEventLoc();
                
        
		monthLabel.setText(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + " " + year);

		for(int x = 7; x < dayButton.length; x++) {
			dayButton[x].setText("");
                        
                if (eventMonth <= 0 ){
				day = daysInMonth;
			} else 
                {
                            day = daysInMonth;
                }
                
                }
                
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, 1);


		for(int x = 6+ dayOfWeek, day1 = 1; day1 <= daysInMonth; x++, day1++){
			dayButton[x].setText("" + day1);
			dayButton[x].setBackground(Color.white);
                        
                        dayButton[x].setVerticalAlignment(SwingConstants.TOP);
                        
                        
                        if (eventMonth == month+1 && eventDay == dayInMonth ) {
			dayButton[x].setText("<html>" + day1 + "<br><br><br>" + "Event: " + eventName +
					"<br><br>" + "Location: " + eventLoc);
		} else {
			dayButton[x].setText("" + day1);
		}

                        
                        if (day1 == cal2.get(Calendar.DATE) && month == cal2.get(Calendar.MONTH) && year == cal2.get(Calendar.YEAR)) {	// Current Day
			
				dayButton[x].setBackground(new Color(51,153,255));
			}else {
				dayButton[x].setBackground(Color.white);
			}
                        
		}
                
	}


	public void CalendarMonthly() {
		// TODO Auto-generated method stub
		
	}
}
