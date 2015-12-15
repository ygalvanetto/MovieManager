/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.hearc.ig.odi.moviemanager.business;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Yannick Galvanetto <yannick.galvanetto@he-arc.ch>
 */
public class Person {
    
    private long id;
    private String firstName;
    private String lastName;
    private int size;
    private Map<Long, Movie> movies;
    
    
    public Person(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        movies = new HashMap();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    
    /*
    La classe reçoit le film en paramètre.
    Elle ajoute le film à la liste des films de la personne
    Et elle appelle le méthode addPeron de la classe movie pour ajouter la personne à la liste des personnes qui ont vu le film.
    */
    public void addMovie (Movie movie) {
        movies.put(movie.getId(), movie);
        movie.addPerson(this);
        size = movies.size();
    }
    
    /*
    Retourne la liste des films
    */
    public Map<Long, Movie> getMovies() {
        return movies;
    }
}
