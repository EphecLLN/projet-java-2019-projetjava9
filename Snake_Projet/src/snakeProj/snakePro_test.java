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


/**
 * The class Snake contains the logic of the snake game.
 * It also contains the graphic part.
 */
public class snakePro_test extends JPanel{

    private static final long serialVersionUID = 1L;
    private static int WIDTH = 25;
    public static Deque<PartieSerpent> snake = new ArrayDeque<>();
    //lie la variable oeuf de la classe creerOeuf
    private Point oeuf = snakeProj.creerOeuf.oeuf;
    public Random rand = new Random();
    public boolean Croissance = false;
    public boolean eggEaten = false;
    public static int gameLost = 0;
    private int offset = 0;
    private static int offsetIncrementValue = 5;
    public int refresh = 0;
    public int newDirection = 39;
    private static boolean mursActifs = false;
    public static int debutPartie = 0;
    public static int score = 0;
    public boolean reset = false;
    public JPanel panel;
    public int compteurOff = 1;
    private Point bonus = new Point(0, 0);
    private int BoostVitesse = 0;
    public int BonusOeuf = 0;
    private int offsetIncrementValueBonus = 5;
    private static int offsetIncrementBasique = 5;
    public int comparateur = 1;
    private static int regleur = 0;
    private static int vert = 1;
    private static int blanc = 0;
    private static int orange = 0;
    private static int mursAide = 0;
   
    
    public static void main(String[] args) {
        
        // Spawns the first egg
        creerOeuf egg = new creerOeuf();
        egg.creerOeuf();
        
        // Set the title of the game
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
        
        // Set the parameters of the menu bar
        frame.setContentPane(panel);
        panel.setLayout(null);
        JMenuBar BarreDeMenu = new JMenuBar();
        panel.add(BarreDeMenu);
        BarreDeMenu.setBounds(0, 0, 20*WIDTH, WIDTH);
        JMenu Commencer = new JMenu("Commencer");
        JMenu Options = new JMenu("Options");
        JMenu Style = new JMenu("Couleur Serpent");
        JMenu Vitesse = new JMenu("Vitesse de jeu");
        BarreDeMenu.add(Commencer);
        BarreDeMenu.add(Vitesse);
        BarreDeMenu.add(Style);
        BarreDeMenu.add(Options);        
        
        // Add the options of the menu bar
        JMenuItem NewGame = new JMenuItem("Nouvelle Partie");
        JMenuItem ActiverMurs = new JMenuItem("Activer les murs");
        JMenuItem DesactiverMurs = new JMenuItem("Désactiver les murs");
        JMenuItem Regles = new JMenuItem("Règles");
        JMenuItem Vert = new JMenuItem("Serpent vert");
        JMenuItem Orange = new JMenuItem("Serpent orange");
        JMenuItem Blanc = new JMenuItem("Serpent blanc");
        JMenuItem Vitesse1 = new JMenuItem("Vitesse lente");
        JMenuItem Vitesse2 = new JMenuItem("Vitesse normale");
        JMenuItem Vitesse3 = new JMenuItem("Vitesse rapide");
        
        Options.add(ActiverMurs);
        Options.add(DesactiverMurs);
        Commencer.add(NewGame);
        Commencer.add(Regles);
        Vitesse.add(Vitesse1);
        Vitesse.add(Vitesse2);
        Vitesse.add(Vitesse3);
        Style.add(Vert);
        Style.add(Orange);
        Style.add(Blanc);
        
        //Wall 
        ActiverMurs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(debutPartie == 0) {
	               mursActifs = true;
	               mursAide = 1;
            	}
            }
        });
        DesactiverMurs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(debutPartie == 0) {
	                mursActifs = false;
	                mursAide = 0;
            	}
            }
        });
        
        //Start Game
        NewGame.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {
                debutPartie = 1;
            }
            
        });
        
        //Show rules
        Regles.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent e) {
                regleur = 1;
            }   
        });
        
        //Snake Colors
        Vert.addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent e) {
                if(debutPartie == 0) {
                    vert = 1;
                    orange = 0;
                    blanc = 0;
                }
            }   
        });
        
        Orange.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent e) {
                if(debutPartie == 0) {
                    vert = 0;
                    orange = 1;
                    blanc = 0;
                }
            }   
        });
        
        Blanc.addActionListener(new ActionListener() {          
            public void actionPerformed(ActionEvent e) {
                if(debutPartie == 0) {
                    vert = 0;
                    orange = 0;
                    blanc = 1;
                }
            }   
        });
        
        //Snake Speed
        Vitesse1.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {
            	if(debutPartie == 0) {
	            	offsetIncrementBasique = 3;
	            	offsetIncrementValue = 3;
            	}
            }  
        });
        
        Vitesse2.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {
            	if(debutPartie == 0) {
	            	offsetIncrementBasique = 5;
	            	offsetIncrementValue = 5;
            	}
            }  
        });
        
        Vitesse3.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {
            	if(debutPartie == 0) {
	            	offsetIncrementBasique = 7;
	            	offsetIncrementValue = 7;
            	}
            }  
        });
        
        // Set the parameters of the window
        frame.setSize(20*WIDTH, 20*WIDTH); 
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); 
    }

    /**
     * The method Snake runs the snake game
     */
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

    /**
     * The method paintComponent moves, paints and extends the snake.
     * It also create the normal eggs as well as the bonus egg.
     */
    @Override
    protected void paintComponent(Graphics objet) {
        // Activates the wall every 10 eggs eaten 
        if(mursActifs == false) {
            if(score % 10 == 1 && score != 1) {
                mursActifs = true;
            }   
        }

        // Start the game
        if(debutPartie == 1) {
            super.paintComponent(objet);
            offset += offsetIncrementValue;
            PartieSerpent head = null;
            if(offset > WIDTH) {
                offset = 0;
                try {
                    /* Moves the snake by cloning the position of the head
                     *     thanks to the ArrayDeque method that stores the data
                     *     by listing them in a stack
                     */
                    head = (PartieSerpent) snake.getFirst().clone();
                    head.move();
                    head.direction = newDirection;
                    snake.addFirst(head);
                    
                    // Extends the snake's length when an egg is eaten
                    if(head.x == oeuf.x && head.y == oeuf.y) {
                    	if(mursAide == 0) {
                    		mursActifs = false;
                    	}
                        Croissance = true;
                        eggEaten = true;
                        creerOeuf egg = new creerOeuf();
                        egg.creerOeuf();
                        BoostVitesse++;
                        offsetIncrementValue = offsetIncrementBasique;
                // Creates the bonus every 7 eggs eaten
                        if(BoostVitesse == 7) {
                                creerBonus();
                                BoostVitesse = 0;
                        }
                        score++;  
                    }
                    /* Deletes the last part of the snake when no
                     *     eggs are eaten, so the snake conserves
                     *     it's length
                     */
                    if(!Croissance) {
                        snake.pollLast();  
                    }
                    else {
                        Croissance = false;
                    }
                    
                    // Adds some speed to the snake when the bonus/malus is eaten
                    if(head.x == bonus.x && head.y == bonus.y) {
                        bonus = new Point(0, 0);
                        offsetIncrementValue += offsetIncrementValueBonus;
                    }
                }
                // Catch the error if a clone fails
                catch (CloneNotSupportedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        // Change the color of the egg to warn the activation of the walls
            if(score % 10 == 0.00 && score != 0) {
                objet.setColor(Color.RED);
            }
        // Colors the egg
            else if(score % 10 != 0.00 || score == 0) {
            objet.setColor(Color.YELLOW);
            }
            objet.fillOval(oeuf.x*WIDTH + WIDTH/4, oeuf.y*WIDTH + WIDTH/4, WIDTH/2, WIDTH/2);
            
            /*objet.setColor(Color.RED);
            objet.fillOval(oeuf.x*WIDTH + WIDTH/4, oeuf.y*WIDTH + WIDTH/4, WIDTH/2, WIDTH/2);*/
            
            // Change the background color when a certain amount of score is reached
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
            if(vert == 1) {
                objet.setColor(Color.GREEN);
            }
            else if(orange == 1) {
                objet.setColor(Color.orange);
            }
            else if(blanc == 1){
                objet.setColor(Color.white);
            }
            // Check if the snake eats itself
            for(PartieSerpent p : snake) {
                if(offset == 0) {
            // Don't check if the head collides itself
                    if(p != head) {
                // Check if the head collides with a part of the snake's body
                        if(p.x == head.x && p.y == head.y) {
                            gameLost = 1;
                            debutPartie = 0;
                        }
                    }
                }

                // Fill the snake
                if(p.direction == 37 || p.direction == 39) {
                    objet.fillRect(p.x * WIDTH + ((p.direction == 37) ? -offset : offset), p.y*WIDTH, WIDTH, WIDTH);
                } 
                else {
                    objet.fillRect(p.x * WIDTH, p.y*WIDTH + ((p.direction == 38) ? -offset : offset), WIDTH, WIDTH);
                }
            }

            // Writes the score in the top left corner in the game
            objet.setColor(Color.BLUE);
            objet.drawString("Score : " + score, 9, 45);

            // Writes the warning of the activation of the walls
            if(mursActifs == true && mursAide == 0) {
	            if(score % 10 == 1 && score != 1) {
	                objet.setColor(Color.BLUE);
	                objet.setFont(new Font("Arial", WIDTH, WIDTH));
	                objet.drawString("Les murs sont actifs", 130, 300); 
	            }
            }
        }
        else {
            // Draws "game over" when the game is over 
            if(gameLost>0) {
                objet.setColor(Color.RED);
                objet.setFont(new Font("Arial", 40, 40));
                objet.drawString("GAME OVER", 110, 9*WIDTH);

                /* Writes the game over in the command line and send
                 *     the score and player's name to the database
                 * @see pseudoPlayer
                 */
                if(gameLost++<2){
                    pseudoPlayer pseudo = new pseudoPlayer();
                    pseudo.pseudoPlayer();
                    System.out.println("Game Over! :'(");
                }
                return;
            }

            // Displays the rules and the introduction of the game
            else {
                objet.setColor(Color.GREEN.darker());
                objet.setFont(new Font("Arial", 40, 40));
                objet.drawString("Snake Un Jeu", 110, 5*WIDTH);
                
                if(regleur == 1){
                objet.setColor(Color.black);
                objet.setFont(new Font("Arial", 20, 20));
                objet.drawString("Règles :", 5, 8*WIDTH);   
                
                objet.setColor(Color.black);
                objet.setFont(new Font("Arial", 14, 14));
                objet.drawString("- Manger un maximum d'oeufs.", 5, 9*WIDTH);   
                
                objet.setColor(Color.black);
                objet.setFont(new Font("Arial", 14, 14));
                objet.drawString("- Ne pas s'auto-manger ou se cogner aux murs s'ils sont actifs.", 5, 10*WIDTH);   
                
                objet.setColor(Color.black);
                objet.setFont(new Font("Arial", 14, 14));
                objet.drawString("- Attention au malus invisible qui boost la vitesse. ", 5, 11*WIDTH); 
                
                objet.setColor(Color.black);
                objet.setFont(new Font("Arial", 14, 14));
                objet.drawString("- Tout les 10 oeufs mangés, les murs s'activent jusqu'au prochain oeuf.", 5, 12*WIDTH);
                
                }

                objet.setColor(Color.GREEN.darker());
                objet.setFont(new Font("Arial", WIDTH, WIDTH));
                objet.drawString("BONNE CHANCE JEUNE SERPENT", 35, 17*WIDTH);
            }   
        }   
    }

    /** 
     * The method creerBonus creates the bonus egg in the game
     */
    public void creerBonus() {
        boolean positionAvailable = false;
        while(!positionAvailable){
            bonus.x = rand.nextInt(12);
            bonus.y = rand.nextInt(13) + 1;
            positionAvailable = true;
            for(PartieSerpent p : snake) {
                if(p.x == bonus.x && p.y == bonus.y) {
                    positionAvailable = false;
                    break;
                }
            }
        }
    }

    /**
     * The method onKeyPressed get the input on the keyboard
     *     to convert it to an integer, so it knows if it's either
     *     moving up, down, left or right
     * @param keyCode : integer that represents the input on the keyboard
     *                  where the inputs are the arrows
     */
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

    /**
    * The class PartieSerpent contains two methods: one to print the game in the
    *     command line, and the other to do the teleportation of the snake's body
    */
    class PartieSerpent extends AffichageConsole {
        public int x, y, direction;
        
        /**
        * The method PartieSerpent allows to store the position of the snake's head
        *     and calls the method affichageConsole to print everything in the 
        *     command line
        *
        * @param x : gives the x axis of the snake as an Integer
        * @param y : gives the y axis of the snake as an Integer
        * @param direction : gives the direction of the snake as an Integer
        *
        * @see affichageConsole
        */
        public PartieSerpent(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            // Calls the method affichageConsole to print the snake
            affichageConsole(oeuf.x+1, oeuf.y, bonus.x+1, bonus.y);
        }

        /**
        * The method move teleports a part of the snake when it passes through a 
        *     deactivated wall, or check if it hits the activated wall
        */
        public void move(){
            // Check if the snake hits a wall when the walls are activated 
            if(mursActifs == true) {
                /* Check if the snake hits the left or the right wall
                 * If it hits, loose the game
                 */
                if(direction == 37 || direction == 39) {
                    // Moves the snake to the right or to the left
                    x += (direction == 37) ? -1 : 1;

                    // When the snake hits the right wall
                    if(x > 18) {
                        gameLost = 1;
                        debutPartie = 0;
                    }
                    // When the snake hits the left wall
                    else if(x < 0) {
                        gameLost = 1;
                        debutPartie =0;
                    }
                 }
                 /* Check if the snake hits the top or the bottom wall
                  * If it hits, loose the game
                  */
                 else {
                    // Moves the snake up or down
                    y += (direction == 38) ? -1 : 1;

                    // When the snake hits the top wall
                    if(y > 18) {
                        gameLost = 1;
                        debutPartie = 0;
                    }
                    // When the snake hits the bottom wall
                    else if(y < 1) {
                        gameLost = 1;
                        debutPartie = 0;
                    }
                }
            }
            // Teleports the snake when walls are deactivated
            else{
                // Moves the snake to the left or to the right
                if(direction == 37 || direction == 39) {
                    // Moves the snake
                    x += (direction == 37) ? -1 : 1;

                    // Teleports the snake from the right to the left
                    if(x > 18)
                        x = 0;
                    // Teleports the snake from the left to the right
                    else if(x < 0)
                        x = 18;
                }
                // Moves the snake up or down
                else {
                    // Moves the snake
                    y += (direction == 38) ? -1 : 1;

                    // Teleports the snake from the bottom to the top
                    if(y > 18)
                        y = 1;
                    // Teleports the snake from the top to the bottom
                    else if(y < 1)
                        y = 18;
                }
            }
        }
        
        /**
         * The protected method clone() gets the snakes body by cloning the head
         *
         * @throws CloneNotSupportedException : throws an exception when the clone fails 
         * @return PartieSerpent : returns the snake's head position
         */
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new PartieSerpent(x, y, direction);
        }
    } 
}
