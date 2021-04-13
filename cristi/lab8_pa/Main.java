/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristi.lab8_pa;

import DAO.Genre;
import DAO.Movies;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author crist
 */
public class Main {
    public static void main(String[] args){
        Movies.createMovie("Titanic1", Date.valueOf(LocalDate.now()), 120, 10);
        Genre.createGenre("Action1");
        System.out.println(Movies.getMovieById(2));
        System.out.println(Genre.getGenreById(2));
    }
}
