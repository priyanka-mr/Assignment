import java.text.SimpleDateFormat;
import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.*;


public class MyFrame extends JFrame{
	
	SimpleDateFormat timeFormat;
	 JLabel timeLabel;
	 JTextField textField;
	 JButton button;
	 String time;


	 MyFrame(){
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setTitle("My Clock Program");
	  this.setLayout(new FlowLayout());
	  this.setSize(500,250);
	  this.setResizable(false);
	  
	  timeFormat = new SimpleDateFormat("hh:mm:ss a");	  
	  timeLabel = new JLabel();
	  timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));
	  timeLabel.setForeground(new Color(0x00FF00));
	  timeLabel.setBackground(Color.black);
	  timeLabel.setOpaque(true); 
	  textField = new JTextField(30);
	  button = new JButton("Enter");
	  this.add(timeLabel);
	  this.add(textField);
	  this.add(button);
	  this.setVisible(true);
	  
	  setTime();
	 }
	 
	 public void setTime() {
	  while(true) {
	  time = timeFormat.format(Calendar.getInstance().getTime());
	  timeLabel.setText(time);
	  try {
	   Thread.sleep(1000);
	  } catch (InterruptedException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
	  }
	 }

}
