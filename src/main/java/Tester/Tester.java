/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import Entity.Address;
import Entity.Customer;
import Entity.Customer2;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Aske
 */
public class Tester {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    
    public static void main(String[] args) {
        
        EntityManager em = emf.createEntityManager();
    
        em.getTransaction().begin();
            Address a1 = new Address("Naurbjergvej 26", "Lille Skensved");
            Address a2 = new Address("Naurbjergvej 27", "Lille Skensved");
            
            ArrayList<Address> list1 = new ArrayList();
            list1.add(a1);
            list1.add(a2);
            
            
            
            Customer2 c1 = new Customer2("Jønke", "Jørgensen");
            Customer2 c2 = new Customer2("Hanne", "Jørgensen");
            c1.setAddresses(list1);
            c2.setAddresses(list1);
//            
//            c1.addHobby("Løb");
//            c1.addHobby("Våben");
//            c1.addHobby("Øl");
//            c2.addHobby("Folkedans");
//        
            em.persist(c1);
            em.persist(c2);

            Persistence.generateSchema("pu", null);

            em.getTransaction().commit();
   
    }
    
    
    
}
