package org.example.dao;

import org.example.model.Compte;

import java.util.HashMap;
import java.util.Map;

public class ImplCompteDao implements ICompteDao {

    private final Map<Integer, Compte> comptes = new HashMap<>();

    public ImplCompteDao() {
        comptes.put(1, new Compte(1, "Hamza", 1000));
        comptes.put(2, new Compte(2, "Sara", 500));
    }

    @Override
    public Compte findById(int id) {
        return comptes.get(id);
    }

    @Override
    public void update(Compte compte) {
        comptes.put(compte.getId(), compte);
    }
}
