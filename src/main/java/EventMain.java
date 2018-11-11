/*
*
 */

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EventMain {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void EventMain() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventMain window = new EventMain();
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
	public EventMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 1000, 800);
                frame.getContentPane().setBackground(new Color(0, 51, 102));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
                frame.setTitle("Reservation Room");
		
     
                 
                 
		JLabel lblAddEvent = new JLabel("Reservation Room");
		lblAddEvent.setBounds(350, 11, 500, 100);
		lblAddEvent.setFont(new Font("Berlin Sans FB", Font.PLAIN, 35));
                lblAddEvent.setForeground(new java.awt.Color(255, 255, 255));
		frame.getContentPane().add(lblAddEvent);
		
                
                // Event Name 
                JLabel lblEventName = new JLabel("Room #");
		lblEventName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblEventName.setBounds(47, 200, 95, 20);
                lblEventName.setForeground(new java.awt.Color(255, 255, 255));
		frame.getContentPane().add(lblEventName);
                
		JFormattedTextField eventTitle = new JFormattedTextField();
		eventTitle.setBounds(182, 200, 100, 30);
		frame.getContentPane().add(eventTitle);
	
 
                
               JLabel Start = new JLabel("Start");
		Start.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		Start.setBounds(47, 260, 95, 20);
                 Start.setForeground(new java.awt.Color(255, 255, 255));
		frame.getContentPane().add(Start);

                JLabel Start1 = new JLabel("(Month, Day, Time)");
		Start1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		Start1.setBounds(700, 260, 150, 20);
                 Start1.setForeground(new java.awt.Color(255, 255, 255));
		frame.getContentPane().add(Start1);
                
                
                JFormattedTextField eventStartMonth = new JFormattedTextField();
		eventStartMonth.setBounds(182, 260, 100, 30);
		frame.getContentPane().add(eventStartMonth);
                
                JFormattedTextField eventStartDay = new JFormattedTextField();
		eventStartDay.setBounds(382, 260, 100, 30);
		frame.getContentPane().add(eventStartDay);
                
                JFormattedTextField eventStartTime = new JFormattedTextField();
		eventStartTime.setBounds(582, 260, 100, 30);
		frame.getContentPane().add(eventStartTime);
                
                JLabel End = new JLabel("End");
		End.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		End.setBounds(47, 330, 95, 20);
                End.setForeground(new java.awt.Color(255, 255, 255));
		frame.getContentPane().add(End);
                
                JLabel End1 = new JLabel("(Month, Day, Time)");
		End1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		End1.setBounds(700, 330, 150, 20);
                End1.setForeground(new java.awt.Color(255, 255, 255));
		frame.getContentPane().add(End1);
                
                JFormattedTextField eventEndMonth = new JFormattedTextField();
		eventEndMonth.setBounds(182, 330,100, 30);
		frame.getContentPane().add(eventEndMonth);
                
                JFormattedTextField eventEndDay = new JFormattedTextField();
		eventEndDay.setBounds(382, 330,100, 30);
		frame.getContentPane().add(eventEndDay);
                
                
                JFormattedTextField eventEndTime = new JFormattedTextField();
		eventEndTime.setBounds(582, 330,100, 30);
		frame.getContentPane().add(eventEndTime);
                
                

 
		

  
                JButton btnAdd = new JButton("Reservation");
		btnAdd.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
                           //EventMain event = new EventMain();
                           //event.EventMain();
			}
		});
		btnAdd.setBounds(180, 100, 140, 42);
		frame.getContentPane().add(btnAdd);
                
                JButton btnDelete = new JButton("Cancel");
		btnDelete.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
                           //EventMain event = new EventMain();
                           //event.EventMain();
			}
		});
		btnDelete.setBounds(380, 100, 140, 42);
		frame.getContentPane().add(btnDelete);
                
                
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
                //CalendarMonthly monthly = new CalendarMonthly();
                //monthly.CalendarMonthly();
                frame.dispose();
			}
		});
		btnBack.setBounds(580, 100, 140, 42);
		frame.getContentPane().add(btnBack);
                
          
                
                String[][] data = { 
            { "room # data", "avaliable data", "avaliable time data" }, 
            { "room # data", "avaliable data", "avaliable time data" } 
        }; 
        
                String[] columnNames = { "Room #", "Avaliable", "Avaliable Time" }; 
                
                
                JTable RoomList = new JTable(data, columnNames);
                RoomList.setBounds(47, 450, 900, 200); 
                frame.getContentPane().add(RoomList);
                
	}


}
