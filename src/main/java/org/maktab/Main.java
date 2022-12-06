package org.maktab;


import org.maktab.util.JpaConnection;

public class Main {
    public static void main(String[] args) {
        JpaConnection.getEntityManagerFactory().createEntityManager();
    }

}