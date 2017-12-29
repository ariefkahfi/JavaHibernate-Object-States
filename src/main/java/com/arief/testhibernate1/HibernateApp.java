package com.arief.testhibernate1;

import com.arief.testhibernate1.entity.Person;
import com.arief.testhibernate1.utils.HibernateSetup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author arief
 */
public class HibernateApp {
    public static void main(String[] args) {
        
        SessionFactory sessionFactory = HibernateSetup.getInstance();
        
        
//        TRANSIENT STATE  
//        Person arief = new Person()
//        arief.setName("Arief");
//        arief.setAddress("Test address");
//        TRANSIENT STATE  

        Session session = sessionFactory.openSession();        
        session.beginTransaction();
       
        
        
        Person arief = (Person)session.get(Person.class, 1);
//        PERSISTENT STATE HERE 
//        PERSISTENT STATE HERE 
        arief.setAddress("Persistent address update");
//        PERSISTENT STATE HERE         
//        PERSISTENT STATE HERE         
        session.getTransaction().commit();
        session.close();
//        DETACHED STATE HERE
//        DETACHED STATE HERE
//        DETACHED STATE HERE
//        DETACHED STATE HERE

//        OPEN SESSION AGAIN  
        session = sessionFactory.openSession();
        session.beginTransaction();
        
        arief.setName("name_after_detached_to_persistent_but_before_session_update");
        
        session.update(arief);
//        PERSISTENT STATE HERE 
//        PERSISTENT STATE HERE 
//        PERSISTENT STATE HERE 
        arief.setAddress("address_after_detached_to_persistent_2");
        arief.setName("name_after_detached_to_persistent_2");
//        PERSISTENT STATE HERE         
        System.out.println("Session is dirty : " + session.isDirty());
//        PERSISTENT STATE HERE         
//        PERSISTENT STATE HERE 
        session.getTransaction().commit();
        session.close();
    }
}
