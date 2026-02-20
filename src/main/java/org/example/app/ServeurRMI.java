package org.example.app;

import org.example.dao.ImplCompteDao;
import org.example.metier.CompteMetier;
import org.example.metier.ICompteMetier;
import org.example.serviceRmi.ICompteRemote;
import org.example.serviceRmi.ImplCompteRemote;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServeurRMI {

    public static void main(String[] args) throws Exception {

        LocateRegistry.createRegistry(1099);

        ImplCompteDao dao = new ImplCompteDao();
        ICompteMetier metier = new CompteMetier(dao);

        ICompteRemote service = new ImplCompteRemote(metier);

        Naming.rebind("rmi://localhost/CompteService", service);

        System.out.println("✅ Serveur RMI est démarré...");
    }
}
