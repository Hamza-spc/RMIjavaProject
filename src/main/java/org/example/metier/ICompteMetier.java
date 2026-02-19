package org.example.metier;

import org.example.model.Compte;

public interface ICompteMetier {

    Compte consulterCompte(int id);

    void retirer(int id, double montant);

    void deposer(int id, double montant);

    void virement(int idSource, int idDest, double montant);
}
