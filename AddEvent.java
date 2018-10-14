import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddEvent {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void AddEvent() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEvent window = new AddEvent();
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
	public AddEvent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 542, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddEvent = new JLabel("Add Event");
		lblAddEvent.setBounds(202, 11, 140, 42);
		lblAddEvent.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		frame.getContentPane().add(lblAddEvent);
		
		JFormattedTextField eventTitle = new JFormattedTextField();
		eventTitle.setBounds(182, 92, 271, 20);
		frame.getContentPane().add(eventTitle);
		
		JFormattedTextField eventDescr = new JFormattedTextField();
		eventDescr.setBounds(182, 164, 271, 73);
		frame.getContentPane().add(eventDescr);
		
		JLabel lblEventName = new JLabel("Event Name");
		lblEventName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblEventName.setBounds(47, 92, 95, 20);
		frame.getContentPane().add(lblEventName);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblDescription.setBounds(47, 189, 95, 20);
		frame.getContentPane().add(lblDescription);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setBounds(364, 272, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}
