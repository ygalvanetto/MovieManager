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
public class Movie {
    
    private long id;
    private String name;
    private String producer;
    private int size;
    private Map<Long, Person> persons;

    public Movie(long id, String name, String producer) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        persons = new HashMap();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
        
    /*
    La classe ajoute la personne qu'elle reçoit en paramètre à la liste des personnes du film.
    */
    public void addPerson (Person person) {
        persons.put(person.getId(), person);
        size= persons.size();
    }
    
    /*
    Retourne la liste des personnes
    */
    public Map<Long, Person> getPerson() {
        return persons;
    }
    
}
