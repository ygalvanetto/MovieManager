package ch.hearc.ig.odi.moviemanager.beans;

import ch.hearc.ig.odi.moviemanager.business.Person;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Yannick Galvanetto <yannick.galvanetto@he-arc.ch>
 */
@Named(value="personLISBean")
@RequestScoped
public class PersonLISBean implements Serializable {
    /*
    Utilisation des beans validation
    */
    
    private DataModel<Person> personDM;

    @Inject Services services;
    public PersonLISBean() {
    }
    
    public DataModel<Person> getPersonDM() {
        personDM = new ListDataModel<>();
        personDM.setWrappedData(services.getPeopleList());
        
        return personDM;
    }
}
