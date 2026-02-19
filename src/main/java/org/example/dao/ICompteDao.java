package org.example.dao;

import org.example.model.Compte;

public interface ICompteDao {
    Compte findById(int id);
    void update(Compte compte);
}
