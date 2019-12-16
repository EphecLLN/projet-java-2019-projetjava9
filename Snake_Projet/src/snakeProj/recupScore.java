package snakeProj;

import java.awt.Point;
import java.sql.*;

/**
 * The class recupScore gets the scores stored in the database
 *
 */
public class recupScore {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	public static int scoreMax = 0;
	public static int scoreMax2 = 0;
	public static int scoreMax3 = 0;
	public static int scoreMax4 = 0;
	public static int scoreMax5 = 0;
	public static String top1 = "user";
	public static String top2 = "user";
	public static String top3 = "user";
	public static String top4 = "user";
	public static String top5 = "user";

	public recupScore() {
	    try {
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
	public void dataReceive() {
		try {
	    	String query ="SELECT * FROM public.savescore order by  score_player DESC";
	    	rs = st.executeQuery(query);
	    	 //On récupère les MetaData
	        ResultSetMetaData resultMeta = rs.getMetaData();
	        
	        while(rs.next()){
	        	int scoreLect = (int) rs.getObject(2);
	        	if(scoreLect > scoreMax) {
	        		scoreMax = (int) rs.getObject(2);
	        		top1 = (String) rs.getObject(1);
	        	}
	        	else if(scoreLect>scoreMax2 && scoreMax>scoreMax2) {
	        		scoreMax2 = (int) rs.getObject(2);
	        		top2 = (String) rs.getObject(1);
	        	}
	        	else if(scoreLect>scoreMax3 && scoreMax2>scoreMax3) {
	        		scoreMax3 = (int) rs.getObject(2);
	        		top3 = (String) rs.getObject(1);
	        	}
	        	else if(scoreLect>scoreMax4 && scoreMax3>scoreMax4) {
	        		scoreMax4 = (int) rs.getObject(2);
	        		top4 = (String) rs.getObject(1);
	        	}
	        	else if(scoreLect>scoreMax5 && scoreMax4>scoreMax5) {
	        		scoreMax5 = (int) rs.getObject(2);
	        		top5 = (String) rs.getObject(1);
	        	}
	        	
	        }  
	        System.out.print("\n" + top1 + " score de:" + scoreMax);
	    	System.out.print("\n" + top2 + " score de:" + scoreMax2);
	    	System.out.print("\n" + top3 + " score de:" + scoreMax3);
	    	System.out.print("\n" + top4 + " score de:" + scoreMax4);
	    	System.out.print("\n" + top5 + " score de:" + scoreMax5);
	         
	    } catch (Exception e) {}   
	}
}
	
