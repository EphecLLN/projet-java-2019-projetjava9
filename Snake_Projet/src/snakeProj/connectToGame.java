package snakeProj;

import java.awt.Point;

import java.sql.*;


public class connectToGame {
private Connection con;
private Statement st;
private ResultSet rs;
private int score= snakeProj.snakePro_test.score;
private String idPlayer= snakeProj.pseudoPlayer.idPlayer;

	public connectToGame() {
	    try {
	      Class.forName("org.postgresql.Driver");
	         
	      String url = "jdbc:postgresql://localhost:5432/srvGame";
	      String user = "postgres";
	      String passwd = "moimoimoi02";
	         
	      con = DriverManager.getConnection(url, user, passwd);
	         
	      //Création d'un objet Statement
	      st  = con.createStatement();
	      //L'objet dataSend contient le résultat de la requête SQL


	         
	    } catch (Exception e) {
	     
	    }   
	  }
	  public void dataSend() {
		    try {
		        System.out.println("idPlayer dans l'envoie "+idPlayer);
		        System.out.println("score dans l'envoie "+score);
		    	String query ="insert into savescore(id_player,score_player)Values('"+idPlayer+"',"+score+")";
		    	String query2 ="select * savescore";
		    	rs = st.executeQuery(query);
		    	System.out.println(rs);	
		    } catch (Exception e) {
		      
		    }   
		  }
}