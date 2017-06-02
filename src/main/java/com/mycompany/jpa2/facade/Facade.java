/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa2.facade;

import com.mycompany.jpa2.entities.Person;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author lucasmfredmark
 */
public class Facade {
    EntityManagerFactory emf;
    
    public Facade(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public void addPerson() {
        EntityManager em = emf.createEntityManager();
        
        Person person = new Person();
        person.setFirstName("Lucas");
        person.setLastName("Meulengracht Fredmark");
        person.setBirthDate(new Date());
        person.setAge(20);
        person.setIsMarried(false);
        person.setSupervisor(null);
        person.setSupervisors(null);
        
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }
    
    public void editPerson(Integer userId, String firstName) {
        EntityManager em = emf.createEntityManager();
        Person person = findPerson(userId);
        
        em.getTransaction().begin();
        person.setFirstName(firstName);
        em.persist(em);
        em.getTransaction().commit();
        em.close();
    }
    
    public Person findPerson(Integer userId) {
        EntityManager em = emf.createEntityManager();
        Person person = em.find(Person.class, userId);
        em.close();
        
        return person;
    }
    
    public void deletePerson(Integer userId) {
        EntityManager em = emf.createEntityManager();
        Person person = findPerson(userId);
        
        em.getTransaction().begin();
        em.remove(person);
        em.getTransaction().commit();
        em.close();
    }
}
