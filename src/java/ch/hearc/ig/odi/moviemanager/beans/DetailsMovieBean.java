/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.hearc.ig.odi.moviemanager.beans;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import ch.hearc.ig.odi.moviemanager.business.Person;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Francois Gatherat <francois.gatherat@he-arc.ch>
 */
@Named(value="detailsMovie")
@SessionScoped
public class DetailsMovieBean implements Serializable{
    
    private Movie movie;
    
    private DataModel<Person> personDM;

    @Inject Services services;
    public DetailsMovieBean() {
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    /* 
    Teste si un film est passée en paramètre ou non
    Retourne un message pour afficher ou non les details du film
    */
    public String showMovie (Movie movie){
        if(movie != null){
            this.movie = movie;
            return "show";
        }else{
            this.movie = null;
            return "error";
        }
    }
    
    /*
    Retourne la liste des film de la persone
    */
    public List<Person> getPerson(){
        if(movie == null){
            return new ArrayList();
        }
        
        return new ArrayList(movie.getPerson().values());
    }
    
}
