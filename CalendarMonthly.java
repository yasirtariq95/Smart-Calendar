import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class CalendarMonthly extends JFrame {

	DefaultTableModel model;
	Calendar cal = new GregorianCalendar();
	JLabel monthLabel;
	JButton[] button = new JButton[49];
	JPanel p1 = new JPanel(new GridLayout(7, 7));
	int month = Calendar.getInstance().get(Calendar.MONTH);

	CalendarMonthly() {
		getContentPane().setBackground(new Color(204, 204, 255));
		getContentPane().setFont(new Font("Berlin Sans FB", Font.PLAIN, 11));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Personal Calendar");
		this.setSize(1000,800);
		this.setVisible(true);

		String [] columns = {"Sunday","Monday","Tueday","Wednesday","Thursday","Friday","Saturday"};
		model = new DefaultTableModel(null,columns);
		getContentPane().setLayout(null);


		monthLabel = new JLabel();
		monthLabel.setBackground(Color.BLACK);
		monthLabel.setForeground(Color.BLACK);
		monthLabel.setBounds(338, 56, 283, 27);
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

		
		JButton prevMonth = new JButton("<<");
		prevMonth.setBounds(59, 58, 56, 29);
		getContentPane().add(prevMonth);
		prevMonth.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));

		
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
		prevMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cal.add(Calendar.MONTH, -1);
				updateMonth();
			}
		});

		this.updateMonth();

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
