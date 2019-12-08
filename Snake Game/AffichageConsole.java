package snakeProj;

import java.util.ArrayList;

public class AffichageConsole {
	public static void main2(String[] args) {
		int sizeTableau = 20;
		ArrayList<String> [][] tableau = new ArrayList[sizeTableau+2][sizeTableau+2];
		ArrayList<Integer> snakePositionX = new ArrayList<Integer>();
		ArrayList<Integer> snakePositionY = new ArrayList<Integer>();
		int x = 3;
		int y = 3;
		int direction = 39;
		boolean writeSnake = false;
		int k;
		boolean nextPart = true;
		snakePositionX.add(x);
		snakePositionY.add(y);
		snakePositionX.add(5);
		snakePositionY.add(5);

		switch(direction) {
			case 37: //fl�che de gauche
				y = y==1 ? sizeTableau : --y;
				break;
			case 38: //fl�che du haut
				x = x==1 ? sizeTableau : --x;
				break;
			case 39: //fl�che de droite
				y = y==sizeTableau ? 1 : ++y;
				break;
			case 40: //fl�che du bas
				x = x==sizeTableau ? 1 : ++x;
				break;
		}
	
		k=0;
		for(int i=0; i<=sizeTableau; i++) {
			ArrayList<String> innerList = new ArrayList<>();
			innerList.clear();
			ArrayList<String> ligne = new ArrayList<>();
			ligne.clear();
			if(nextPart) {
				if(i==snakePositionX.get(k)) {
					writeSnake = true;
				}
			}
			for(int j=0; j<=sizeTableau; j++) {
				if(i==0 || i==sizeTableau) {
					tableau[i][j] = innerList;
					innerList.add("#");
					tableau[i][j] = ligne;
					ligne.add("#");
				}
				else if(j==0 || j==sizeTableau) {
					tableau[i][j] = innerList;
					innerList.add("#");
					tableau[i][j] = ligne;
					ligne.add("#");
				}
				else if(writeSnake && j==snakePositionY.get(k)){
					if(k<snakePositionX.size()-1) {
						k++;
					}
					else {
						nextPart = false;
					}
					tableau[i][j] = ligne;
					ligne.add("o");
	
					writeSnake = false;
				}
				else {
					tableau[i][j] = innerList;
					innerList.add(" ");
					tableau[i][j] = ligne;
					ligne.add(" ");
				}
	
				if(j==sizeTableau) {
					System.out.println(tableau[i][j]);
				}
			}
		}
	
	}
}
