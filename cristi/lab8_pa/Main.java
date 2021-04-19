/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristi.lab8_pa;

import DAO.Genre;
import DAO.Movies;
import DAO.Actors;
import java.util.List;

/**
 *
 * @author crist
 */
public class Main {
    public static void main(String[] args){
//        Movies.createMovie("Titanic2", Date.valueOf(LocalDate.now()), 120, 10);
//        Genre.createGenre("Action2");
//        Actors.createActor("notSegal", "alTreileaFilm");
        System.out.println(Actors.getActorByName("Segal"));
        System.out.println(Movies.getMovieById(2));
        System.out.println(Genre.getGenreById(2));
        CSVReader idk = new CSVReader("IMDb ratings.csv");
        List<List<String>> dataSet = idk.getDataSet();
        System.out.println(dataSet);
    }
}
