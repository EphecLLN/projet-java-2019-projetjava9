package snakeProj;

import java.util.ArrayList;
import snakeProj.snakePro_test.PartieSerpent;
import java.util.Deque;

/**
 * The class AffichageConsole displays the snake game in the Eclipse command line
 */
public class AffichageConsole {
	
	public Deque<PartieSerpent> snake = snakeProj.snakePro_test.snake;
	private int sizeTableau = 20;
	public char [][] tableau = new char[sizeTableau+2][sizeTableau+2];
	
	/**
	 * The method affichageConsole takes the position of the snake (and his body),
	 *     the position of the egg and the position of the bonus/malus egg
	 *     then print everything in the command line in Eclipse.
	 * 
	 * @see snake : object that contains the body of the snake itself
	 * @param oeufX : integer that contains the X axis of the egg
	 * @param oeufY : integer that contains the Y axis of the egg
	 * @param bonusX : integer that contains the X axis of the bonus/malus egg
	 * @param bonusY : integer that contains the Y axis of the bonus/malus egg
	 */
	public void affichageConsole(int oeufX, int oeufY, int bonusX, int bonusY){
		ArrayList<Integer> snakePositionX = new ArrayList<Integer>();
		ArrayList<Integer> snakePositionY = new ArrayList<Integer>();
		boolean writeSnake = false;
		
		// Stores the coordinates of the snake to ease the printing
		for(PartieSerpent p : snake) {
			snakePositionX.add(p.x+1);
			snakePositionY.add(p.y);
		}
		
		/**
		 *  Prints the game board using matrix algorithm
		 */

		// Checks the line
		for(int i=0; i<sizeTableau; i++) {
			// Checks if the snake is already stored in the matrix
			if(snakePositionX.size()>0) {
				writeSnake = true;
			}
			// Checks the column
			for(int j=0; j<=sizeTableau; j++) {
				// Stores the walls in the matrix
				if(i==0 || i==sizeTableau-1 || j==0 || j==sizeTableau) {
					tableau[i][j] = '#';
				}
				// Stores the egg in the matrix
				else if(j==oeufX && i==oeufY) {
					tableau[i][j] = 'X';
				}
				// Stores the bonus/malus egg in the matrix
				else if(j==bonusX && i==bonusY) {
					tableau[i][j] = '@';
				}
				// Stores the snake in the matrix
				else if(writeSnake) {
					for(int k=0; k<snakePositionX.size(); k++) {
						if(snakePositionX.get(k)==j && snakePositionY.get(k)==i) {
							tableau[i][j] = 'o';
							snakePositionX.remove(k);
							snakePositionY.remove(k);
						}
					}
				}
				// Prints a line of the game board
				System.out.printf("%c ",tableau[i][j]);
			}
			System.out.printf("%n");
		}
	}
}
