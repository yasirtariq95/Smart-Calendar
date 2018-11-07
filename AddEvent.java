/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

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
		frame.setBounds(200, 200, 1000, 800);
                frame.getContentPane().setBackground(new Color(0, 51, 102));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
     
                 
                 
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
		Start.setBounds(47, 300, 95, 20);
                 Start.setForeground(new java.awt.Color(255, 255, 255));
		frame.getContentPane().add(Start);
                
                JFormattedTextField eventStart = new JFormattedTextField();
		eventStart.setBounds(182, 300, 270, 40);
		frame.getContentPane().add(eventStart);
                
                JLabel End = new JLabel("End");
		End.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		End.setBounds(500, 300, 95, 20);
                End.setForeground(new java.awt.Color(255, 255, 255));
		frame.getContentPane().add(End);
                
                JFormattedTextField eventEnd = new JFormattedTextField();
		eventEnd.setBounds(600, 300,270, 40);
		frame.getContentPane().add(eventEnd);
                
                
                JLabel Location = new JLabel("Location");
		Location.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		Location.setBounds(47, 420, 95, 20);
                Location.setForeground(new java.awt.Color(255, 255, 255));
		frame.getContentPane().add(Location);
                
                JFormattedTextField eventLocation = new JFormattedTextField();
		eventLocation.setBounds(182, 400, 700, 73);
		frame.getContentPane().add(eventLocation);
                
                
                
                JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblDescription.setBounds(47, 520, 95, 20);
                lblDescription.setForeground(new java.awt.Color(255, 255, 255));
		frame.getContentPane().add(lblDescription);
              
		JFormattedTextField eventDescr = new JFormattedTextField();
		eventDescr.setBounds(182, 500, 700, 73);
		frame.getContentPane().add(eventDescr);
		

  
                
                JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(300, 80, 140, 42);
		frame.getContentPane().add(btnAdd);
                
                
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
                //CalendarMonthly monthly = new CalendarMonthly();
                //monthly.CalendarMonthly();
                frame.dispose();
			}
		});
		btnBack.setBounds(520, 80, 140, 42);
		frame.getContentPane().add(btnBack);
                
         
	}
}