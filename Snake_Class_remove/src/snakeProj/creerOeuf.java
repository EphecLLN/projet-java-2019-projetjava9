package snakeProj;

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import snakeProj.snakePro_test.PartieSerpent;
import snakeProj.snakePro_test;

public class creerOeuf {
	
    public static Point oeuf = new Point(1,1);
    public Random rand = new Random();
    public Deque<PartieSerpent> snake = new ArrayDeque<>();

	
	
	
    public void creerOeuf() {
        boolean positionAvailable = false;
        while(!positionAvailable){
            oeuf.x = rand.nextInt(12);
            oeuf.y = rand.nextInt(13) + 1;//-------------------------------------------------------
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
