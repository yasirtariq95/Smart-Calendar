import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

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
	DefaultTableModel model;
	Calendar cal = new GregorianCalendar();
	JLabel weekLabel;
	int day = Calendar.getInstance().get(Calendar.DATE);
	int week = Calendar.getInstance().get(Calendar.WEEK_OF_MONTH);
	JPanel p1 = new JPanel(new GridLayout(7, 7));
	private JFrame frame;


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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Personal Calendar");
		frame.setSize(1000,700);
		frame.setVisible(true);

		String [] columns = {"Sunday","Monday","Tueday","Wednesday","Thursday","Friday","Saturday"};
		model = new DefaultTableModel(null,columns);
		frame.getContentPane().setLayout(null);


		weekLabel = new JLabel();
		weekLabel.setBounds(146, 56, 692, 27);
		weekLabel.setBackground(Color.BLACK);
		weekLabel.setForeground(Color.BLACK);
		frame.getContentPane().add(weekLabel);
		weekLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		weekLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JTable table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(94, 121, 788, 350);
		frame.getContentPane().add(pane);

		table.setEnabled(false);
		table.setSurrendersFocusOnKeystroke(true);
		table.setIntercellSpacing(new Dimension(1, 1));
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		table.setRowHeight(75);

		JPanel p1 = new JPanel(new GridLayout(7, 7));
		p1.setBounds(94, 121, 788, 350);
		frame.getContentPane().add(p1);

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
	}

	void updateWeek() {	
		int year = cal.get(Calendar.YEAR);
		int day = cal.get(Calendar.DATE);
		int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int startOfWeek = day - dayOfWeek+1;
		int endOfWeek = startOfWeek + 6;
		int daysInBetween = daysInMonth - endOfWeek;
		
		if (startOfWeek <= 0 ){
			startOfWeek = daysInMonth+startOfWeek;
		}else if (endOfWeek > daysInMonth){
			endOfWeek = startOfWeek+daysInBetween;
		}
		
		weekLabel.setText(cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US) + ". " +
				(startOfWeek) + ", " + year + " - " + cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US) + ". " + 
				 endOfWeek+ ", " + year);

		model.setRowCount(0);

	}

}
