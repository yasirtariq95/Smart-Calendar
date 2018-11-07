/*
*
 */
package se_project;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class EventMain {

	JPanel p1 = new JPanel(new GridLayout(7, 7));

	private JFrame frame;
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
	public EventMain() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 51, 102));
                frame.setBounds(200, 200, 1000, 800);
		frame.getContentPane().setFont(new Font("Berlin Sans FB", Font.PLAIN, 11));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Personal Calendar");
		frame.setSize(1000,700);
		frame.setVisible(true);


                
                
	}


	
	


	public void EventMain() {
		// TODO Auto-generated method stub
		
	}

}