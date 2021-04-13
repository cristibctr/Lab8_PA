/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import cristi.lab8_pa.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author crist
 */
public class Movies {
    private Movies(){
    
    }
    
    public static String getMovieById(int movieId){
        Connection myConn = DBConnection.getConnection();
        String movieQuery = "";
        try {
            myConn.setAutoCommit(false);
            Statement stmt = myConn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from movies WHERE id == '" + movieId + "';"); 
            movieQuery = rs.getString("id") + " | " + rs.getString("title") + " | " + rs.getString("release_date") + " | " + rs.getString("duration") + " | " + rs.getString("score");
            stmt.close();
            rs.close();
        }
        catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
        return movieQuery;
    }
    
    public static void createMovie(String movieTitle, Date releaseDate ,int durationInMinutes, int score){
        Connection myConn = DBConnection.getConnection();
        try {
            myConn.setAutoCommit(false);
            Statement stmt = myConn.createStatement();
            String sql = "INSERT INTO movies (title, release_date, duration, score) VALUES ('" + movieTitle + "'," + releaseDate + " , "+ durationInMinutes +", "+ score +" );"; 
            stmt.executeUpdate(sql);
            stmt.close();
            myConn.commit();
        }
        catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
    }

}
