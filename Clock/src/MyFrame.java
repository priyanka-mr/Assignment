import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import java.util.*;
import javax.swing.*;


public class MyFrame extends JFrame{
	
	DateTimeFormatter timeFormat;
	LocalDateTime currentTime = LocalDateTime.now();
	 JLabel timeLabel;
	 JTextField textField;
	 JButton button;
	 JLabel newLabel;
	 String time;


	 MyFrame(){
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setTitle("My Clock Program");
	  this.setLayout(new FlowLayout());
	  this.setSize(500,250);
	  this.setResizable(false);
	  
	  timeFormat = DateTimeFormatter.ofPattern("hh:mm:ss a");	  
	  timeLabel = new JLabel();
	  timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));
	  timeLabel.setForeground(new Color(0x00FF00));
	  timeLabel.setBackground(Color.black);
	  timeLabel.setOpaque(true); 
	  textField = new JTextField(30);
	  button = new JButton("Enter");
	  newLabel = new JLabel();
	  newLabel.setFont(new Font("Verdana",Font.PLAIN,50));
	  newLabel.setForeground(new Color(0x00FF00));
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
	  while(true) {
	  time = timeFormat.format(currentTime);
	  timeLabel.setText(time);
	  try {
	   Thread.sleep(1000);
	  } catch (InterruptedException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
	  }
	 }
	 public void updateTime(int seconds) {	
		 LocalDateTime newTime = currentTime.minusSeconds(seconds);
		 time = timeFormat.format(newTime);
		 newLabel.setText(time);
	 }

}
