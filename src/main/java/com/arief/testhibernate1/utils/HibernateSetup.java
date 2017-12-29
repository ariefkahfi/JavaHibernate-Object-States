/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.testhibernate1.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


/**
 *
 * @author arief
 */
public class HibernateSetup {
    
    private static SessionFactory setUpSessionFactory(){
            StandardServiceRegistry ssr  = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            SessionFactory sessionFactory = new MetadataSources(ssr).buildMetadata().buildSessionFactory();
            
            return sessionFactory;
    }
    
    public static SessionFactory getInstance(){
        return setUpSessionFactory();
    }
    
}
