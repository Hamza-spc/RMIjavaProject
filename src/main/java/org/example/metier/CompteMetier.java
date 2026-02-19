package org.example.metier;

import org.example.dao.ICompteDao;
import org.example.model.Compte;

public class CompteMetier implements ICompteMetier {

    private final ICompteDao dao;

    public CompteMetier(ICompteDao dao) {
        this.dao = dao;
    }

    @Override
    public Compte consulterCompte(int id) {
        Compte c = dao.findById(id);
        if (c == null)
            throw new RuntimeException("Compte introuvable");
        return c;
    }

    @Override
    public void retirer(int id, double montant) {
        Compte c = consulterCompte(id);
        if (c.getSolde() < montant)
            throw new RuntimeException("Solde insuffisant");

        c.setSolde(c.getSolde() - montant);
        dao.update(c);
    }

    @Override
    public void deposer(int id, double montant) {
        Compte c = consulterCompte(id);
        c.setSolde(c.getSolde() + montant);
        dao.update(c);
    }

    @Override
    public void virement(int idSource, int idDest, double montant) {
        retirer(idSource, montant);
        deposer(idDest, montant);
    }
}
