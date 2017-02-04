package states;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Menu extends JFrame {
	public void iniMenu(){
		JPanel optionsPane = new JPanel(new GridLayout(8,1));
		JPanel pane = null;
		// IP adress
		pane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton button = new JButton("Start");
		button.addActionListener(new ActionAdopter());
		button.setActionCommand("Start");
		pane = new JPanel(new GridLayout(1,1));
		pane.add(button);
		optionsPane.add(pane);
		add(optionsPane);
	}
 
}
class ActionAdopter implements ActionListener{
	public void actionPreformed(ActionEvent e){
		if(e.getActionCommand().equals("")){
		}else if(e.getActionCommand().equals("")){
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}