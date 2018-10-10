import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class CalendarMonthly extends JFrame {

	DefaultTableModel model;
	Calendar cal = new GregorianCalendar();
	JLabel label;

	CalendarMonthly() {
		getContentPane().setBackground(new Color(204, 204, 255));
		getContentPane().setFont(new Font("Berlin Sans FB", Font.PLAIN, 11));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Personal Calendar");
		this.setSize(800,400);
		this.setVisible(true);


		String [] columns = {"Sunday","Monday","Tueday","Wednesday","Thursday","Friday","Saturday"};
		model = new DefaultTableModel(null,columns);
		getContentPane().setLayout(null);


		label = new JLabel();
		label.setBackground(Color.BLACK);
		label.setForeground(Color.BLACK);
		label.setBounds(240, 56, 283, 27);
		getContentPane().add(label);
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTable table = new JTable(model);
		table.setSurrendersFocusOnKeystroke(true);
		table.setIntercellSpacing(new Dimension(1, 1));
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(60, 111, 660, 213);
		getContentPane().add(pane);

		JButton b1 = new JButton("<<");
		b1.setBounds(10, 58, 56, 29);
		getContentPane().add(b1);
		b1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));

		JButton b2 = new JButton(">>");
		b2.setBounds(708, 58, 66, 29);
		getContentPane().add(b2);
		b2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cal.add(Calendar.MONTH, +1);
				updateMonth();
			}
		});
		b1.addActionListener(new ActionListener() {
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
		label.setText(month + " " + year);

		int startDay = cal.get(Calendar.DAY_OF_WEEK);
		int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);

		model.setRowCount(0);
		model.setRowCount(weeks);

		int i = startDay-1;
		for(int day=1;day<=numberOfDays;day++){
			model.setValueAt(day, i/7 , i%7 );    
			i = i + 1;
		}

	}

	public static void main(String[] arguments) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		CalendarMonthly monthly = new CalendarMonthly();
	}

}
