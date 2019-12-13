package snakeProj;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class pseudoPlayer extends JFrame {
private JPanel container = new JPanel();
private JTextField jtf = new JTextField();
private JLabel label = new JLabel("Nom du Joueur");
private JButton b = new JButton ("Envoyer");
private JButton a = new JButton ("Annuler");
public static String idPlayer="user";
private int score= snakeProj.snakePro_test.score;
private int debutPartie= snakeProj.snakePro_test.debutPartie;
private JLabel scorePartie = new JLabel("Score de la partie :");
private JLabel bestScore = new JLabel(""+score);




public pseudoPlayer(){
  this.setTitle("Score");
  this.setSize(300, 300);
  this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  this.setLocationRelativeTo(null);
  container.setLayout(new BorderLayout());
  JPanel top = new JPanel(); 
  top.setLayout(new GridLayout(11,2));

  	recupScore recup=new recupScore();
	recup.dataReceive();
	JLabel vide = new JLabel("");
	JLabel vide2 = new JLabel("");
	 JLabel scoreMax = new JLabel(""+snakeProj.recupScore.scoreMax);
	 JLabel scoreMax2 = new JLabel(""+snakeProj.recupScore.scoreMax2);
	 JLabel scoreMax3 = new JLabel(""+snakeProj.recupScore.scoreMax3);
	 JLabel scoreMax4 = new JLabel(""+snakeProj.recupScore.scoreMax4);
	 JLabel scoreMax5 = new JLabel(""+snakeProj.recupScore.scoreMax5);
	 JLabel top1 = new JLabel(snakeProj.recupScore.top1);
	 JLabel top2 = new JLabel(snakeProj.recupScore.top2);
	 JLabel top3 = new JLabel(snakeProj.recupScore.top3);
	 JLabel top4 = new JLabel(snakeProj.recupScore.top4);
	 JLabel top5 = new JLabel(snakeProj.recupScore.top5);
  
  top.setBackground(Color.LIGHT_GRAY);
  Font police = new Font("Arial", Font.BOLD, 14);
  jtf.setFont(police);
  scorePartie.setFont(police);
  label.setFont(police);

  jtf.setPreferredSize(new Dimension(150, 30));
  jtf.setForeground(Color.BLUE);
  b.addActionListener(new BoutonListener());
  a.addActionListener(new BoutonListener1());
  top.add(top1);
  top.add(scoreMax);
  top.add(top2);
  top.add(scoreMax2);
  top.add(top3);
  top.add(scoreMax3);
  top.add(top4);
  top.add(scoreMax4);
  top.add(top5);
  top.add(scoreMax5);
  top.add(vide);
  top.add(vide2);
  top.add(scorePartie);
  top.add(bestScore);
  top.add(label);
  top.add(jtf);	
  top.add(b);
  top.add(a);
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
	
	
	debutPartie = 1;
	dispose();
    }
}
class BoutonListener1 implements ActionListener{
	  public void actionPerformed(ActionEvent e) {

		debutPartie = 1;
		dispose();
	    }
	}


	public void pseudoPlayer() {
		jtf.getText();

	}
	}

