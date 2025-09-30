package jeux;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Serveur {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(3099);

            JeuImpl jeu = new JeuImpl();

            registry.rebind("Jeu", jeu);

            System.out.println("Serveur RMI démarré, en attente des clients...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
