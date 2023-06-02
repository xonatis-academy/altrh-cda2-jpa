package org.example;

import org.example.domain.Booking;
import org.example.domain.Client;
import org.example.domain.Hotel;
import org.example.domain.Room;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        // 1. Charger la configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // 2. Charger les entités
        configuration.addAnnotatedClass(Hotel.class);
        configuration.addAnnotatedClass(Room.class);
        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(Booking.class);

        // 3. Créer un EntityManager
        EntityManagerFactory factory = configuration.buildSessionFactory();
        EntityManager em = factory.createEntityManager();
    }
}