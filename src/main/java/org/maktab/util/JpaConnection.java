package org.maktab.util;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaConnection {

     private static EntityManagerFactory ENTITY_MANAGER_FACTORY;

     private JpaConnection() {
     }

     public static EntityManagerFactory getEntityManagerFactory() {
          if (ENTITY_MANAGER_FACTORY == null) {
               ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("final-project");
          }
          return ENTITY_MANAGER_FACTORY;
     }
}
