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

/**
 *
 * @author crist
 */
public class Genre {
    
    private Genre(){
        
    }
    
    public static String getGenreById(int genreId){
        Connection myConn = DBConnection.getConnection();
        String movieQuery = "";
        try {
            myConn.setAutoCommit(false);
            Statement stmt = myConn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from genres WHERE id == '" + genreId + "';"); 
            movieQuery = rs.getString("id") + " | " + rs.getString("name");
            stmt.close();
            rs.close();
        }
        catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
        return movieQuery;
    }
    
    public static void createGenre(String genreName){
        Connection myConn = DBConnection.getConnection();
        try {
            myConn.setAutoCommit(false);
            Statement stmt = myConn.createStatement();
            String sql = "INSERT INTO genres (name) VALUES ('"+ genreName +"');"; 
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
