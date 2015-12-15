/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.hearc.ig.odi.moviemanager.beans;

import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 *
 * @author Yannick Galvanetto <yannick.galvanetto@he-arc.ch>
 */
@Named(value="personBean")
@RequestScoped
public class CreatePersonBean implements Serializable{
    
    @Min(0)
    private long number;
    
    @NotNull
    @Size(min=1, max=5)
    private String lastName;
    
    @NotNull
    @Size(min=1, max=5)
    private String firstName;
    
    @Inject Services services;
    public CreatePersonBean(){
    
    }
    
    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /*
    La méthode ne peut pas retourner un null
    */
    @NotNull
    public String add(){
        try {
           services.createPerson(number, firstName, lastName);
        
            return "success"; 
        }catch (Exception e ) {
            return "error";
        }
    }
       
}
