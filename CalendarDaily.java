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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class CalendarDaily {
	DefaultTableModel model;
	Calendar cal = new GregorianCalendar();
	JLabel dayLabel;
	int day = Calendar.getInstance().get(Calendar.DATE);

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Personal Calendar");
		frame.setSize(1000,700);
		frame.setVisible(true);


		String [] columns = {"Time" ,"Events"};
		String [][] rows = {{"12 am"},{ "1 am"}, {"2 am"}, {"3 am"}, {"4 am"}, {"5 am"}, {"6 am"}, {"7 am"}, {"8 am"}, {"9 am"}, {"10 am"}, {"11 am"},
				{"12 pm"},{ "1 pm"}, {"2 pm"}, {"3 pm"}, {"4 pm"}, {"5 pm"}, {"6 pm"}, {"7 pm"}, {"8 pm"}, {"9 pm"}, {"10 pm"}, {"11 pm"}
		};

		model = new DefaultTableModel(rows,columns);
		JTable table = new JTable(model);
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setSurrendersFocusOnKeystroke(true);
		table.setIntercellSpacing(new Dimension(1, 1));
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(94, 121, 788, 350);
		frame.getContentPane().add(pane);
		table.setRowHeight(30);

		frame.getContentPane().setLayout(null);

		dayLabel = new JLabel();
		dayLabel.setBounds(277, 56, 380, 27);
		dayLabel.setBackground(Color.BLACK);
		dayLabel.setForeground(Color.BLACK);
		frame.getContentPane().add(dayLabel);
		dayLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		dayLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel p1 = new JPanel(new GridLayout(24, 1));
		p1.setBounds(94, 121, 788, 350);
		frame.getContentPane().add(p1);

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

	private void updateDay() {
		int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int year = cal.get(Calendar.YEAR);

		if (day <= 0 ){
			day = daysInMonth;
		}else if (day > daysInMonth){
			day = 1;
		}

		dayLabel.setText(cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US) + ", " + 
				cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + " " + day + ", " + year);
	}

}
