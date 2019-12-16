package snakeProj;
import java.awt.BorderLayout;

import java.awt.Color;
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

/**
 * The class pseudoPlayer allows to get the name of a player with a graphic interface
 */
public class pseudoPlayer extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel container = new JPanel();
	private JTextField jtf = new JTextField();
	private JLabel label = new JLabel("Nom du Joueur");
	private JButton boutonEnvoi = new JButton ("Envoyer");
	private JButton boutonAnnuler = new JButton ("Annuler");
	public static String idPlayer="user";
	private int score= snakeProj.snakePro_test.score;
	private JLabel scorePartie = new JLabel("Score de la partie :");
	private JLabel bestScore = new JLabel(""+score);

	/**
	 * The method pseudoPlayer shows the score of all players in a new window.
	 * It also ask the player to write his name
	 */
	public pseudoPlayer(){
		// Set the basic displays of a screen
		this.setTitle("Score");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setLayout(new BorderLayout());
		JPanel top = new JPanel(); 
		top.setLayout(new GridLayout(11,2));

		// Gets the scores of the top 5 players stored in the database
		recupScore recup = new recupScore();
		recup.dataReceive();
		JLabel vide = new JLabel("");
		JLabel vide2 = new JLabel("");
		JLabel scoreMax = new JLabel("" + snakeProj.recupScore.scoreMax);
		JLabel scoreMax2 = new JLabel("" + snakeProj.recupScore.scoreMax2);
		JLabel scoreMax3 = new JLabel("" + snakeProj.recupScore.scoreMax3);
		JLabel scoreMax4 = new JLabel("" + snakeProj.recupScore.scoreMax4);
		JLabel scoreMax5 = new JLabel("" + snakeProj.recupScore.scoreMax5);
		JLabel top1 = new JLabel(snakeProj.recupScore.top1);
		JLabel top2 = new JLabel(snakeProj.recupScore.top2);
		JLabel top3 = new JLabel(snakeProj.recupScore.top3);
		JLabel top4 = new JLabel(snakeProj.recupScore.top4);
		JLabel top5 = new JLabel(snakeProj.recupScore.top5);

		// Set the background color and the police of the characters
		top.setBackground(Color.LIGHT_GRAY);
		Font police = new Font("Arial", Font.BOLD, 14);
		jtf.setFont(police);
		scorePartie.setFont(police);
		label.setFont(police);

		// Set the buttons "Envoyer" and "Annuler"
		jtf.setPreferredSize(new Dimension(150, 30));
		jtf.setForeground(Color.BLUE);
		boutonEnvoi.addActionListener(new BoutonListener());
		boutonAnnuler.addActionListener(new BoutonListener1());

		// Displays the top 5 players
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
		top.add(boutonEnvoi);
		top.add(boutonAnnuler);
		this.setContentPane(top);
		this.setVisible(true);
	}       

	/**
	 * The class BoutonListener gets the score and the name of the player
	 *     and send them to the database via the method dataSend() in the
	 *     class connectToGame.
	 * The action is performed by clicking on the button "Envoyer"
	 *
	 * @see connectToGame
	 * @see dataSend()
	 */
	class BoutonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		String idPlayer2 = jtf.getText(); 
		idPlayer = idPlayer2;
		connectToGame connect = new connectToGame();
		connect.dataSend();

		dispose();
		}
	}
	
	/**
	 * The class BoutonListener1 cancels the sending of the player's name
	 *     and score
	 * The action is performed by clicking on the button "Annuler"
	 *
	 */
	class BoutonListener1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dispose();
	    }
	}

	/**
	 * The method pseudoPlayer gets the player's name written in the text field
	 */
	public void pseudoPlayer() {
		jtf.getText();
	}
}
