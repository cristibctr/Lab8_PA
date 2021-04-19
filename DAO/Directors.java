/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import cristi.lab8_pa.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author crist
 */
public class Directors {
    String name;
    static private List<String> moviesID = new ArrayList<>();
    
    private Directors(){
    
    }
    
    public static List<String> getDirectorByName(String directorName){
        Connection myConn = DBConnection.getConnection();
        String movieQuery = "";
        try {
            myConn.setAutoCommit(false);
            Statement stmt = myConn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT movie_title from directors WHERE name == '" + directorName + "';"); 
            while(rs.next()){
                movieQuery = rs.getString("movie_title");
                moviesID.add(movieQuery);
            }
            stmt.close();
            rs.close();
        }
        catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
        return moviesID;
    }
    
    public static void createDirector(String directorName, String movieTitle){
        Connection myConn = DBConnection.getConnection();
        try {
            myConn.setAutoCommit(false);
            Statement stmt = myConn.createStatement();
            String sql = "INSERT INTO actors (name, movie_title) VALUES ('" + directorName + "','" + movieTitle +"' );"; 
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
