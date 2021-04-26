import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MyFrame extends JFrame{
	
	DateTimeFormatter timeFormat;
	LocalDateTime currentTime = LocalDateTime.now();
	 JLabel timeLabel = new JLabel();
	 JTextField textField;
	 JButton button;
	 JLabel newLabel;
	 String time;


	 MyFrame(){
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setTitle("Clock Program");
	  this.setLayout(new FlowLayout());
	  this.setSize(500,250);
	  this.setResizable(false);
	  
	  timeFormat = DateTimeFormatter.ofPattern("hh:mm:ss a");	  
	  timeLabel.setFont(new Font("Arial",Font.PLAIN,65));
	  timeLabel.setForeground(Color.WHITE);
	  timeLabel.setBackground(Color.black);
	  timeLabel.setOpaque(true); 
	  textField = new JTextField(30);
	  button = new JButton("Enter");
	  newLabel = new JLabel();
	  newLabel.setFont(new Font("Arial",Font.PLAIN,65));
	  newLabel.setForeground(Color.WHITE);
	  newLabel.setBackground(Color.black);
	  newLabel.setOpaque(true);
	  button.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  String input = textField.getText();
			  int seconds = Integer.parseInt(input);
			  updateTime(seconds);
		  }
	  });
	  this.add(timeLabel);
	  this.add(textField);
	  this.add(button);
	  this.add(newLabel);
	  this.setVisible(true);
	  
	  setTime();
	 }
	 
	 public void setTime() {
	  time = timeFormat.format(currentTime);
	  timeLabel.setText(time);
	 }
	 public void updateTime(int seconds) {	
		 LocalDateTime newTime = currentTime.minusSeconds(seconds);
		 time = timeFormat.format(newTime);
		 newLabel.setText(time);
	 }

}
