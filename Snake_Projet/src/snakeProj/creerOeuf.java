package snakeProj;

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;
import snakeProj.snakePro_test.PartieSerpent;
import snakeProj.snakePro_test;

/**
 * The class creerOeuf is a class that creates an egg in an available place on the game platform
 */
public class creerOeuf {

    public static Point oeuf = new Point(1,1);
    public Random rand = new Random();
    public Deque<PartieSerpent> snake = new ArrayDeque<>();

    /**
     * Method that checks the available positions to create the egg randomly through the game platform
     * @see oeuf : type Point, contains x,y axis which are integers
     * @see snake : type PartieSerpent, contains the positions of the snake
     */
    public void creerOeuf() {
        boolean positionAvailable = false;
        while(!positionAvailable){
            oeuf.x = rand.nextInt(12);
            //Y axis has a random that begins at 1 so it doesn't spawn in the menu bar
            oeuf.y = rand.nextInt(12)+1;
            positionAvailable = true;
            for(PartieSerpent p : snake) {
                if(p.x == oeuf.x && p.y == oeuf.y) {
	                positionAvailable = false;
	                break;
                }
            }
        }
    }
}
