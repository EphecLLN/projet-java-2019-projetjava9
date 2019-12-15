package snakeProj;
 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import snakeProj.creerOeuf;
import snakeProj.snakePro_test.PartieSerpent;


 
public class snakePro_test extends JPanel{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int WIDTH = 25;
    public static Deque<PartieSerpent> snake = new ArrayDeque<>();
    //lie la variable oeuf de la classe creerOeuf
    private Point oeuf = snakeProj.creerOeuf.oeuf;
    public Random rand = new Random();
    public boolean Croissance = false;
    public boolean eggEaten = false;
    public static int gameLost = 0;
    public int offset = 0;
    public int offsetIncrementValue = 5;
    public int refresh = 0;
    public int newDirection = 39;
    public static boolean mursActifs = false;
    public static int debutPartie = 0;
    public static int score=0;
    public boolean reset = false;
    public JPanel panel;
    public int compteurOff = 1;
    private Point bonus = new Point(7, 7);
    public int BoostVitesse = 0;
    public int BonusOeuf = 0;
    private int offsetIncrementValueBonus = 10;
    public int comparateur = 1;
   

    
    public static void main(String[] args) {
    	creerOeuf egg = new creerOeuf();
    	egg.creerOeuf();
    	
    	//FenÃªtre
        JFrame frame = new JFrame("Snake Un Jeu");
        JPanel panel = new snakePro_test();
        
        frame.addKeyListener(new KeyListener() {
           
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
            }
           
            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
            }
           
            @Override
            public void keyPressed(KeyEvent e) {
                ((snakePro_test) panel).onKeyPressed(e.getKeyCode());
            }
        });
        
       
        //BarreDeMenu
        frame.setContentPane(panel);
        panel.setLayout(null);
        JMenuBar BarreDeMenu = new JMenuBar();
        panel.add(BarreDeMenu);
        BarreDeMenu.setBounds(0, 0, 20*WIDTH, WIDTH);
        JMenu Commencer = new JMenu("Commencer");
        JMenu Options = new JMenu("Options");
        BarreDeMenu.add(Commencer);
        BarreDeMenu.add(Options);
        
        //Bouton activer les murs ou dÃ©sactiver
        JMenuItem NewGame = new JMenuItem("Nouvelle Partie");
        JMenuItem ActiverMurs = new JMenuItem("Activer les murs");
        JMenuItem DesactiverMurs = new JMenuItem("Désactiver les murs");
        Options.add(ActiverMurs);
        Options.add(DesactiverMurs);
        Commencer.add(NewGame);
        ActiverMurs.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mursActifs = true;
        	}
        });
        DesactiverMurs.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mursActifs = false;
        	}
        });
        
        NewGame.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
	        	debutPartie = 1;
	        }
			
		});
        
        
        //Fenetre 
        frame.setSize(20*WIDTH, 20*WIDTH); 
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); 
    }
 
    public snakePro_test() {
    	snake.add(new PartieSerpent(3, 3, 39));  
        new Thread(new Runnable() {          
            @Override
            public void run() {
                while(true) {
                    repaint();
                    try {
                        Thread.sleep(1000/60l);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        })
        .start();
        }
   
    @Override
    protected void paintComponent(Graphics objet) {
    	//Malus Murs Actifs si 10 oeufs mangés
    	if(mursActifs == false) {
	    	if(score % 10 == 1 && score != 1) {
	        	mursActifs = true;
	    	} 	
	    }
    	//Debut de Partie
    	if(debutPartie == 1) {
	        super.paintComponent(objet);
	        offset += offsetIncrementValue;
	        PartieSerpent head = null;
	        if(offset > WIDTH) {
	            offset = 0;
	            try {
	                head = (PartieSerpent) snake.getFirst().clone();
	                head.move();
	                head.direction = newDirection;
	                snake.addFirst(head);
	                if(head.x == oeuf.x && head.y == oeuf.y) {
	                	mursActifs = false;
	                    Croissance = true;
	                    eggEaten = true;
	                    creerOeuf egg = new creerOeuf();
	                    egg.creerOeuf();
	                    BoostVitesse++;
	                    offsetIncrementValue = 5;
	                    if(BoostVitesse == 7) {
	                    	creerBonus();
	                    	BoostVitesse = 0;
	                    }
	                    score++;  
	                }
	                if(!Croissance) {
	                    snake.pollLast();  
	                }
	                else {
	                    Croissance = false;
	                }
	                if(head.x == bonus.x && head.y == bonus.y) {
	                	bonus = new Point(0, 0);
	                	offsetIncrementValue = offsetIncrementValueBonus;
	                }
	                
	            }
	            catch (CloneNotSupportedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        } 
	        if(score % 10 == 0.00 && score != 0) {
	        	objet.setColor(Color.RED);
	        }
	        else if(score % 10 != 0.00 || score == 0) {
	        objet.setColor(Color.YELLOW);
	        }
	        objet.fillOval(oeuf.x*WIDTH + WIDTH/4, oeuf.y*WIDTH + WIDTH/4, WIDTH/2, WIDTH/2);
	        
	        /*objet.setColor(Color.RED);
	        objet.fillOval(oeuf.x*WIDTH + WIDTH/4, oeuf.y*WIDTH + WIDTH/4, WIDTH/2, WIDTH/2);*/
	        
	        if(score < 10) {
	            setBackground(Color.DARK_GRAY);
	            }  
	        if(score>10 && snake.size()<20) {
	        	setBackground(Color.gray);
	        }
	        else if(score>20 && snake.size()<30) {
	        	setBackground(Color.CYAN);
	        }
	        else if(score>30 && snake.size() < 40) {
	        	setBackground(Color.BLACK);
	        }
	        objet.setColor(Color.GREEN);
	        for(PartieSerpent p : snake) {
	            if(offset == 0) {
	                if(p != head) {
	                    if(p.x == head.x && p.y == head.y) {
	                        gameLost = 1;
	                        debutPartie = 0;
	                    }
	                }
	            }
	            if(p.direction == 37 || p.direction == 39) {
	                objet.fillRect(p.x * WIDTH + ((p.direction == 37) ? -offset : offset), p.y*WIDTH, WIDTH, WIDTH);
	            } 
	            else {
	                objet.fillRect(p.x * WIDTH, p.y*WIDTH + ((p.direction == 38) ? -offset : offset), WIDTH, WIDTH);
	            }
	        }        
	        objet.setColor(Color.GREEN);
	        objet.setColor(Color.BLUE);
	        objet.drawString("Score : "+ score, 9, 45);
	        
	        if(score % 10 == 1 && score != 1) {
	        	objet.setColor(Color.GREEN);
	            objet.setColor(Color.BLUE);
	            objet.drawString("Les murs sont actifs", 180, 300);	
	        }
        }
    	else {
    		if(gameLost>0) {
                objet.setColor(Color.RED);
                objet.setFont(new Font("Arial", 40, 40));
                objet.drawString("GAME OVER", 110, 9*25);
                if(gameLost++<2){
                    pseudoPlayer pseudo=new pseudoPlayer();
                    pseudo.pseudoPlayer();
                    System.out.println("Game Over! :'(");
                }
                return;
            }
    		else {
    			objet.setColor(Color.orange);
        		objet.setFont(new Font("Arial", 40, 40));
        		objet.drawString("Snake Un Jeu", 110, 5*25);
    		}
    		
    	}	
    }
    
    public void creerBonus() {
    	boolean positionAvailable = false;
    		while(!positionAvailable){
        		bonus.x =  rand.nextInt(12);
        		bonus.y =  rand.nextInt(13) + 1;//------------------------------------------------------
        		positionAvailable = true;
                for(PartieSerpent p : snake) {
                    if(p.x == bonus.x && p.y == bonus.y) {
                            positionAvailable = false;
                            break;
                    }
        	}
        }
    }
    
    public void onKeyPressed(int keyCode) {
        if(keyCode >= 37 && keyCode <= 40) {
            if(Math.abs(keyCode - newDirection) != 2) {
                newDirection = keyCode;
                try{
                	Thread.sleep(50);
                }
                catch(Exception e) {
                	System.out.println(e);
                }
            }
        }
    }
   
    class PartieSerpent extends AffichageConsole {
        public int x, y, direction;
        
        public PartieSerpent(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            affichageConsole(oeuf.x+1, oeuf.y, bonus.x, bonus.y);
        }
       
        public void move(){
        	// Bouton avec condition de boolean (exemple : muractif) 
        	if(mursActifs == true) {
        		 if(direction == 37 || direction == 39) {
                     x += (direction == 37) ? -1 : 1;
                     if(x > 18) {
                        gameLost = 1;
                     	debutPartie = 0;
                     }
                     else if(x < 0) {
                     	gameLost = 1;
                     	debutPartie =0;
                     }
                 }else {
                     y += (direction == 38) ? -1 : 1;
                     if(y > 18) {
                     	gameLost = 1;
                     	debutPartie = 0;
                     }
                     else if(y < 1) {
                     	gameLost = 1;
                     	debutPartie = 0;
                     }
                 }
        	}
        	else if (mursActifs == false) {
        		 if(direction == 37 || direction == 39) {
                     x += (direction == 37) ? -1 : 1;
                     if(x > 18)
                         x = 0;
                     else if(x < 0)
                     	x = 18;
                 }
        		 else {
                     y += (direction == 38) ? -1 : 1;
                     if(y > 18)
                     	y = 1;
                     else if(y < 1)
                     	y = 18;
                 }
        	}
         }
       
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new PartieSerpent(x, y, direction);
        }
    } 
}
