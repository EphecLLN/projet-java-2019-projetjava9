package snakeProj;

import java.util.ArrayList;
import snakeProj.snakePro_test.PartieSerpent;
import snakeProj.snakePro_test;
import java.util.ArrayDeque;
import java.util.Deque;


public class AffichageConsole {
	
	public Deque<PartieSerpent> snake = snakeProj.snakePro_test.snake;
	private int sizeTableau = 20;
	public char [][] tableau = new char[sizeTableau+2][sizeTableau+2];
	
	public void affichageConsole(int oeufY, int oeufX, int bonusX, int bonusY){
		ArrayList<Integer> snakePositionX = new ArrayList<Integer>();
		ArrayList<Integer> snakePositionY = new ArrayList<Integer>();
		boolean writeSnake = false;
		
		for(PartieSerpent p : snake) {
			snakePositionX.add(p.x+1);
			snakePositionY.add(p.y);
		}
		for(int i=0; i<=sizeTableau; i++) {
			if(snakePositionX.size()>0) {
				writeSnake = true;
			}
			for(int j=0; j<=sizeTableau; j++) {
				if(i==0 || i==sizeTableau || j==0 || j==sizeTableau) {
					tableau[i][j] = '#';
				}
				
				else if(i==oeufX && j==oeufY) {
					tableau[i][j] = 'X';
				}
				else if(j==bonusX && i==bonusY) {
					tableau[i][j] = '@';
				}
				else if(writeSnake) {
					for(int k=0; k<snakePositionX.size(); k++) {
						if(snakePositionX.get(k)==j && snakePositionY.get(k)==i) {
							tableau[i][j] = 'o';
							snakePositionX.remove(k);
							snakePositionY.remove(k);
						}
					}
				}
				System.out.printf("%c ",tableau[i][j]);
			}
			System.out.printf("%n");
		}
	}
}
