package snakeProj;

import java.util.ArrayList;
import snakeProj.snakePro_test.PartieSerpent;
import snakeProj.snakePro_test;
import java.util.ArrayDeque;
import java.util.Deque;


public class AffichageConsole {
	public Deque<PartieSerpent> snake = new ArrayDeque<>();
	public void affichageConsole(int y, int x, int direction, int oeufY, int oeufX, int bonusX, int bonusY){
		int sizeTableau = 20;
		@SuppressWarnings("unchecked")
		char [][] tableau = new char[sizeTableau+2][sizeTableau+2];
		boolean writeSnake = false;
		int k;
		boolean nextPart = true;
		
		
		switch(direction) {
			case 37: //fleche de gauche
				y = y==1 ? sizeTableau : --y;
				break;
			case 38: //fleche du haut
				x = x==1 ? sizeTableau : --x;
				break;
			case 39: //fleche de droite
				y = y==sizeTableau ? 1 : ++y;
				break;
			case 40: //fleche du bas
				x = x==sizeTableau ? 1 : ++x;
				break;
		}
		for(PartieSerpent p : snake) {
			System.out.println(p);
		}
		k=0;
		for(int i=0; i<=sizeTableau; i++) {
			for(int j=0; j<=sizeTableau; j++) {
				if(i==0 || i==sizeTableau || j==0 || j==sizeTableau) {
					tableau[i][j] = '#';
				}
				else if(x==i && y==j) {
					tableau[i][j] = 'o';
				}
				else if(i==oeufX && j==oeufY) {
					tableau[i][j] = 'X';
				}
				else if(i==bonusX && j==bonusY) {
					tableau[i][j] = '@';
				}
				System.out.printf("%c ",tableau[i][j]);
			}
			System.out.printf("%n");
		}
	}
}
