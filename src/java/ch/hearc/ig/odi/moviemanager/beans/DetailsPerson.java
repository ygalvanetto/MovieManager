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
@Named(value="detailsPerson")
@SessionScoped
public class DetailsPerson implements Serializable{
    private Person person;
    
    private DataModel<Movie> moviesDM;

    @Inject Services services;
    public DetailsPerson() {
    }
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    /* 
    Teste si une personne est passée en paramètre ou non
    Retourne un message pour afficher ou non les details de la personne
    */
    public String showPerson (Person pers){
        if(pers != null){
            person = pers;
            return "show";
        }else{
            person = null;
            return "error";
        }
    }
    
    /*
    Retourne la liste des film de la persone
    */
    public List<Movie> getMovies(){
        if(person == null){
            return new ArrayList();
        }
        
        return new ArrayList(person.getMovies().values());
    }
    
}
