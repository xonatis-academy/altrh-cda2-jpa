package org.example.repository;

import org.example.domain.Personne;

import java.util.List;

public interface PersonneRepository {

    void save(Personne personne);

    void remove(Personne personne);

    List<Personne> findAll();

    Personne find(int id);

}
