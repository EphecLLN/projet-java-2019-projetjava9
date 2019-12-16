package snakeProj;

import java.awt.Point;

import java.sql.*;
import snakeProj.snakePro_test;
import snakeProj.pseudoPlayer;

/**
 * The class connectToGame sends the data of the game in the database
 */
public class connectToGame {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private int score = snakeProj.snakePro_test.score;
	private String idPlayer= snakeProj.pseudoPlayer.idPlayer;

	/**
	 * Method that links the game to the database
	 */
	public connectToGame() {
	    try {
	    	// Links the class to the postgresql database
	    	Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:5432/srvGame";
			String user = "postgres";
			String passwd = "moimoimoi02";

			con = DriverManager.getConnection(url, user, passwd);

			// Creates an object Statement
			st  = con.createStatement();
			// The object dataSend contains the result of the SQL requestL

	    } catch (Exception e) {}
	}
	/**
	 * Method that sends the data to the database with the score and the id of the player
	 */
	public void dataSend() {
	    try {  	
	    	String query ="insert into savescore(id_player,score_player)Values('\"+idPlayer+\"',\"+score+\")";
	    	rs = st.executeQuery(query);
	    	System.out.println(rs);
	    } catch (Exception e) {}
	}
}
