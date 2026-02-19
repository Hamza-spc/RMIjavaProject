package org.example.app;

import org.example.model.Compte;
import org.example.serviceRmi.ICompteRemote;

import java.rmi.Naming;

public class ClientRMI {

    public static void main(String[] args) throws Exception {

        ICompteRemote service =
                (ICompteRemote) Naming.lookup("rmi://localhost/CompteService");

        System.out.println("Avant : " + service.consulterCompte(1));

        service.retirer(1, 200);

        System.out.println("Après retrait : " + service.consulterCompte(1));

        service.virement(1, 2, 100);

        System.out.println("Compte 1 : " + service.consulterCompte(1));
        System.out.println("Compte 2 : " + service.consulterCompte(2));
    }
}
