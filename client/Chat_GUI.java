package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Chat_GUI {

	private JFrame frame; 
	private static JTextArea textArea = new JTextArea();
	private Client client;
	private JTextField message;
	
	public static void main(String[] args) {
		
		//public void run() {
		try {
			Chat_GUI window = new Chat_GUI();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Chat_GUI() {
		
		// create the client
		client = new Client("localhost", 52864);
		
		//Creates panel and button
		JPanel panel = new JPanel();
		JButton button = new JButton();
		button.setBounds(450,650,500,500);
		button.setText("Send");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				client.send(message.getText(), client.address, client.port);
			}
		});
		
		//creates message bar
		 message = new JTextField();
		message.setPreferredSize(new Dimension(500,30));
	  
	    panel.setBackground(Color.white);
	    panel.setBounds(0,650,750,250);
	    panel.add(message);
	    panel.add(button);
	    panel.setLayout(new FlowLayout());
		
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("Chat Room");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit appliction
	    frame.setResizable(false);
	    frame.setSize(750,750); //sets x and y dimension
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true); // makes frame visible
	    frame.setLayout(null);
	    frame.add(panel);
	    
	    textArea.setEditable(false);
	    
	    JScrollPane scrollPane = new JScrollPane(textArea);
	    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	    this.frame = frame;
	}

	public static void printToConsole(String message) {
		textArea.setText(textArea.getText()+"\n");
	}
}	
