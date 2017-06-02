/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa2.test;

import com.mycompany.jpa2.facade.Facade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author lucasmfredmark
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        Facade facade = new Facade(emf);
        
        facade.addPerson();
        System.out.println(facade.findPerson(1).getFirstName());
        facade.editPerson(1, "Jens");
        System.out.println(facade.findPerson(1).getFirstName());
        facade.deletePerson(1);
    }
}
