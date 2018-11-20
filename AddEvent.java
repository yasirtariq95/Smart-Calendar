/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AddEvent {

	JFrame frame;

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
		frame.setBounds(200, 200, 1000, 800);
                frame.getContentPane().setBackground(new Color(0, 51, 102));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
                frame.setTitle("Add Event");
		
     
                 
                 
		JLabel lblAddEvent = new JLabel("Add Event");
		lblAddEvent.setBounds(420, 11, 200, 42);
		lblAddEvent.setFont(new Font("Berlin Sans FB", Font.PLAIN, 35));
                lblAddEvent.setForeground(new java.awt.Color(255, 255, 255));
		frame.getContentPane().add(lblAddEvent);
		
                
                // Event Name 
                JLabel lblEventName = new JLabel("Event Name");
		lblEventName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblEventName.setBounds(47, 200, 95, 20);
                lblEventName.setForeground(new java.awt.Color(255, 255, 255));
		frame.getContentPane().add(lblEventName);
                
		JFormattedTextField eventTitle = new JFormattedTextField();
		eventTitle.setBounds(182, 180, 700, 50);
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
                
                
                JLabel Location = new JLabel("Location");
		Location.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		Location.setBounds(47, 420, 95, 20);
                Location.setForeground(new java.awt.Color(255, 255, 255));
		frame.getContentPane().add(Location);
                
                JFormattedTextField eventLocation = new JFormattedTextField();
		eventLocation.setBounds(182, 420, 700, 73);
		frame.getContentPane().add(eventLocation);
                
                
                
                JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblDescription.setBounds(47, 530, 95, 20);
                lblDescription.setForeground(new java.awt.Color(255, 255, 255));
		frame.getContentPane().add(lblDescription);
              
		JFormattedTextField eventDescr = new JFormattedTextField();
		eventDescr.setBounds(182, 530, 700, 90);
		frame.getContentPane().add(eventDescr);
		

  
                
                JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
                            String ename = eventTitle.getText();
                            String loc = eventLocation.getText();
                           /**
                            if(checkEvents(ename))
                            {
                                JOptionPane.showMessageDialog(null, "This location ");
                            }**/
                            
                            PreparedStatement ps;
                            String query = "INSERT INTO Events (EventName,Location) VALUES(?,?)";
                            
                            try {
                                ps = dbconnection.getConnection().prepareStatement(query);
            
                                ps.setString(1, ename);
                                ps.setString(2, loc);
                                
                                if(ps.executeUpdate() > 0)
                                {
                                    JOptionPane.showMessageDialog(null, "Event Added");
                                }
                            }catch (SQLException ex) {
                                Logger.getLogger(CalendarRegistration.class.getName()).log(Level.SEVERE, null, ex);
                            }
                           //EventMain event = new EventMain();
                           //event.EventMain();
			}
		});
		btnAdd.setBounds(180, 80, 140, 42);
		frame.getContentPane().add(btnAdd);
                
                JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
                           //EventMain event = new EventMain();
                           //event.EventMain();
			}
		});
		btnDelete.setBounds(380, 80, 140, 42);
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
		btnBack.setBounds(580, 80, 140, 42);
		frame.getContentPane().add(btnBack);
                
         
                
                JButton eventReservation = new JButton("Reservation Room");
		eventReservation.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		eventReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
                          EventMain event  = new EventMain();
                           event.EventMain();
                           
			}
		});
		eventReservation.setBounds(200, 650, 140, 42);
		frame.getContentPane().add(eventReservation);
                
                
                JButton ContactList = new JButton("Contact List");
		ContactList.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		ContactList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
                           //EventMain event = new EventMain();
                           //event.EventMain();
                           
			}
		});
		ContactList.setBounds(400, 650, 140, 42);
		frame.getContentPane().add(ContactList);
                
	}
        /**public boolean checkEvents(String username)
    {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkEvent = false;
        String query = "SELECT * FROM Events WHERE Location =?";
        
        try {
            ps = dbconnection.getConnection().prepareStatement(query);
            ps.setString(1, username);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                checkEvent = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CalendarRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
         return checkEvent;
    }**/
}