package org.example.repository.impl;

import org.example.domain.Personne;
import org.example.repository.PersonneRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class PersonneRepositoryImpl implements PersonneRepository {

    private final EntityManager em;

    public PersonneRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Personne personne) {
        em.getTransaction().begin();
        em.persist(personne);
        em.getTransaction().commit();
    }

    @Override
    public void remove(Personne personne) {
        em.getTransaction().begin();
        em.remove(personne);
        em.getTransaction().commit();
    }

    @Override
    public List<Personne> findAll() {
        return em.createQuery("SELECT p FROM Personne p", Personne.class).getResultList();
    }

    @Override
    public Personne find(int id) {
        return em.find(Personne.class, id);
    }
}
