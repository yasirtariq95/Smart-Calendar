import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class CalendarMonthly extends JFrame {

	DefaultTableModel model;
	Calendar cal = new GregorianCalendar();
	JLabel monthLabel;

	CalendarMonthly() {
		getContentPane().setBackground(new Color(204, 204, 255));
		getContentPane().setFont(new Font("Berlin Sans FB", Font.PLAIN, 11));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Personal Calendar");
		this.setSize(1000,700);
		this.setVisible(true);
		
		String [] columns = {"Sunday","Monday","Tueday","Wednesday","Thursday","Friday","Saturday"};
		model = new DefaultTableModel(null,columns);
		getContentPane().setLayout(null);
		
		monthLabel = new JLabel();
		monthLabel.setBounds(338, 56, 283, 27);
		monthLabel.setBackground(Color.BLACK);
		monthLabel.setForeground(Color.BLACK);
		getContentPane().add(monthLabel);
		monthLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		monthLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JTable table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(60, 111, 854, 474);
		getContentPane().add(pane);
		table.setEnabled(false);
		table.setSurrendersFocusOnKeystroke(true);
		table.setIntercellSpacing(new Dimension(1, 1));
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		table.setRowHeight(75);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
				int col = table.columnAtPoint(e.getPoint());
				
					AddEvent add = new AddEvent();
					add.AddEvent();
				}
		});

		JButton prevMonth = new JButton("<<");
		prevMonth.setBounds(59, 58, 56, 29);
		getContentPane().add(prevMonth);
		prevMonth.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		prevMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cal.add(Calendar.MONTH, -1);
				updateMonth();
			}
		});

		this.updateMonth();

		JButton nextMonth = new JButton(">>");
		nextMonth.setBounds(848, 58, 66, 29);
		getContentPane().add(nextMonth);
		nextMonth.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		nextMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cal.add(Calendar.MONTH, +1);
				updateMonth();
			}
		});
		
		JButton addEvent = new JButton("+");
		addEvent.setBounds(856, 18, 42, 27);
		addEvent.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		addEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().add(addEvent);
		
		JLabel lblEvents = new JLabel("Events");
		lblEvents.setBounds(908, 15, 66, 32);
		lblEvents.setLabelFor(addEvent);
		lblEvents.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		getContentPane().add(lblEvents);
		
		JCheckBox chckbxMonthly = new JCheckBox("Monthly");
		chckbxMonthly.setBounds(60, 601, 97, 38);
		chckbxMonthly.setSelected(true);
		chckbxMonthly.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		getContentPane().add(chckbxMonthly);
		
		JCheckBox chckbxWeekly = new JCheckBox("Weekly");
		chckbxWeekly.setBounds(462, 601, 97, 38);
		chckbxWeekly.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		getContentPane().add(chckbxWeekly);
		
		JCheckBox chckbxDaily = new JCheckBox("Daily");
		chckbxDaily.setBounds(845, 601, 69, 38);
		chckbxDaily.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		getContentPane().add(chckbxDaily);
		
		JComboBox comboBoxContacts = new JComboBox();
		comboBoxContacts.setBounds(10, 21, 113, 22);
		comboBoxContacts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		comboBoxContacts.setEditable(true);
		comboBoxContacts.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		getContentPane().add(comboBoxContacts);
		
		JLabel lblContact = new JLabel("Contacts");
		lblContact.setBounds(128, 15, 78, 30);
		lblContact.setLabelFor(comboBoxContacts);
		lblContact.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		getContentPane().add(lblContact);
	}

	
	void updateMonth() {	
		cal.set(Calendar.DAY_OF_MONTH, 1);

		String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
		int year = cal.get(Calendar.YEAR);
		monthLabel.setText(month + " " + year);

		int startDay = cal.get(Calendar.DAY_OF_WEEK);
		int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);

		model.setRowCount(0);
		model.setRowCount(weeks);

		int i = startDay-1;
		for(int day = 1; day <= numberOfDays; day++){
			model.setValueAt(day, i/7 , i%7 );    
			i++;
		}
	}

	public static void main(String[] arg) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		CalendarMonthly monthly = new CalendarMonthly();
	}
}
