package org.example.serviceRmi;

import org.example.model.Compte;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICompteRemote extends Remote {

    Compte consulterCompte(int id) throws RemoteException;

    void retirer(int id, double montant) throws RemoteException;

    void deposer(int id, double montant) throws RemoteException;

    void virement(int idSource, int idDest, double montant) throws RemoteException;
}
