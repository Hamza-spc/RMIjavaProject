package org.example.serviceRmi;

import org.example.metier.ICompteMetier;
import org.example.model.Compte;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplCompteRemote extends UnicastRemoteObject implements ICompteRemote {

    private final ICompteMetier metier;

    public ImplCompteRemote(ICompteMetier metier) throws RemoteException {
        super();
        this.metier = metier;
    }

    @Override
    public Compte consulterCompte(int id) throws RemoteException {
        return metier.consulterCompte(id);
    }

    @Override
    public void retirer(int id, double montant) throws RemoteException {
        metier.retirer(id, montant);
    }

    @Override
    public void deposer(int id, double montant) throws RemoteException {
        metier.deposer(id, montant);
    }

    @Override
    public void virement(int idSource, int idDest, double montant) throws RemoteException {
        metier.virement(idSource, idDest, montant);
    }
}
