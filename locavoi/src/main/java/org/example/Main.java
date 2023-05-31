package org.example;

import org.example.domain.Personne;
import org.example.domain.Reservation;
import org.example.domain.Voiture;
import org.example.repository.PersonneRepository;
import org.example.repository.impl.PersonneRepositoryImpl;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {

        // 1. Charger la configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // 2. Charger les entités
        configuration.addAnnotatedClass(Personne.class);
        configuration.addAnnotatedClass(Reservation.class);
        configuration.addAnnotatedClass(Voiture.class);

        // 3. Créer un EntityManager
        EntityManagerFactory factory = configuration.buildSessionFactory();
        EntityManager em = factory.createEntityManager();

        PersonneRepository personneRepository = new PersonneRepositoryImpl(em);
        Personne annie = personneRepository.find(2);
        annie.setLastname("Time");
        annie.setFirstname("Vincent");
        personneRepository.save(annie);
    }
}