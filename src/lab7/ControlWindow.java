package lab7;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

/* 
 * 梁焱烽 
 * Java programing 2015-2016-1 
 * Lab 7
 * 
 */
public class ControlWindow extends JFrame {

	final int WINDOW_WIDTH = 400;
	final int WINDOW_HEIGHT = 150;
	final String[] str = { "male", "female" };
	List<Integer> strList = new ArrayList<Integer>();
	Button forward = null;
	Button backward = null;
	Label label = null;
	TextField textfild = null;
	JPanel panelNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel panelCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel panelSouth = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));

	public ControlWindow() {
		// TODO Auto-generated constructor stub
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		this.setLayout(new BorderLayout(0, 0));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		label = new Label(
				"Click \"Forward\" to run a word , click \"Backward\" to reverse");
		textfild = new TextField(30);
		forward = new Button("Forward");
		backward = new Button("BackWard");

		ButtonAction b = new ButtonAction();
		forward.addActionListener(b);
		backward.addActionListener(b);
		this.add(panelNorth, BorderLayout.NORTH);
		this.add(panelCenter, BorderLayout.CENTER);
		this.add(panelSouth, BorderLayout.SOUTH);
		panelNorth.add(label);
		panelCenter.add(textfild);
		panelSouth.add(forward);
		panelSouth.add(backward);
		this.setVisible(true);
	}

	public class ButtonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == forward) {
				Random ran = new Random();				
				int n = ran.nextInt(str.length);
				strList.add(n);
				String text = textfild.getText();
				text += str[n];
				textfild.setText(text);
			} else if (e.getSource() == backward) {
				String text = textfild.getText();
				int strListSize = strList.size();
				if (strListSize > 0) {
					int lastInteger = strList.get(strListSize - 1);
					text = text.substring(0,
							text.length() - str[lastInteger].length());
					textfild.setText(text);
					strList.remove(strListSize - 1);
				}
			}

		}

	}

	public static void main(String[] args) {
		new ControlWindow();

	}
}
