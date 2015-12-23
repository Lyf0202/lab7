package lab7;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/* 
 * 梁焱烽 
 * Java programing 2015-2016-1 
 * Lab 7
 * 
 */
public class RunnerWindow extends JFrame {

	final int WINDOW_WIDTH = 300;
	final int WINDOW_HEIGHT = 150;
	
	Button button = null;
	TextField text = null;
	Label label = null;
	public RunnerWindow() {
		// TODO Auto-generated constructor stub
		this.setTitle("RunnerWindow");
		this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setLocationRelativeTo(null);
		StopButtonListener stop = new StopButtonListener();
		
		label = new Label("This Window displays the running letter:");
		
		text = new TextField(30);
			
		button = new Button("stop the process");
		button.addActionListener(stop);
		this.add(label);
		this.add(text);
		this.add(button);
		
		this.setVisible(true);
	}
	
	public class StopButtonListener implements ActionListener{

		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == button){
				JOptionPane.showMessageDialog(null, "The Program exits","消息", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		}
		
	}
	public static void main(String[] args) {
		new RunnerWindow();
	}
}
