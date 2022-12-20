package org.maktab;


import jakarta.persistence.EntityManager;
import org.maktab.entity.Address;
import org.maktab.entity.person.Admin;
import org.maktab.exceptionhandler.RepetitiveServiceException;
import org.maktab.util.JpaConnection;

import java.time.Duration;


public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JpaConnection.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new Address());
        entityManager.getTransaction().commit();
        Admin admin=new Admin();


//        throw new RepetitiveServiceException();
//        Service[] services = Service.getServices();
//        for (int i = 0; i < services.length; i++) {
//            System.out.println(services[i].toString());

//        Duration timeDuration = Duration.ofHours(2);
//        timeDuration.plusHours(10);
//        System.out.println(timeDuration.toHours());


        //create new entity to set orders and define expert order offer subService


    }
}
