package snakeProj;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class pseudoPlayer extends JFrame {
private JPanel container = new JPanel();
private JTextField jtf = new JTextField();
private JFormattedTextField jtf2 = new JFormattedTextField(NumberFormat.getIntegerInstance());
private JLabel label = new JLabel("tableau de résultat");
private JButton b = new JButton ("Envoyer");
public static String idPlayer="user";
private int score= snakeProj.snakePro_test.score;



public pseudoPlayer(){
  this.setTitle("Animation");
  this.setSize(300, 300);
  this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  this.setLocationRelativeTo(null);
  container.setBackground(Color.white);
  container.setLayout(new BorderLayout());
  JPanel top = new JPanel();        
  Font police = new Font("Arial", Font.BOLD, 14);
  jtf.setFont(police);
  jtf.setPreferredSize(new Dimension(150, 30));
  jtf.setForeground(Color.BLUE);
  jtf2.setPreferredSize(new Dimension(150, 30));
  b.addActionListener(new BoutonListener());
  top.add(label);
  top.add(jtf);	
  top.add(b);
  this.setContentPane(top);
  this.setVisible(true); 
  
}       

class BoutonListener implements ActionListener{
  public void actionPerformed(ActionEvent e) {
    String idPlayer2= jtf.getText();  
    System.out.println(idPlayer2);
    System.out.println(score);
    idPlayer= idPlayer2;
	connectToGame connect=new connectToGame();
	connect.dataSend();
	dispose();
    }
}

	public void pseudoPlayer() {
		jtf.getText();

	}
	}

