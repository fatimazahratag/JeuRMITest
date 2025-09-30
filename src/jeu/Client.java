package jeu;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            IJeu jeu = (IJeu) registry.lookup("Jeu");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                int tentativesRestantes = jeu.getTentativesRestantes();

                if (tentativesRestantes <= 0) {
                    System.out.println("Nombre de tentatives épuisé. Fin de la partie.");
                    break;
                }

                System.out.println("Tentatives restantes : " + tentativesRestantes);
                System.out.print("Entrez un nombre : ");
                int proposition = scanner.nextInt();

                String reponse = jeu.devinerNombre(proposition);
                System.out.println("Réponse serveur : " + reponse);

                if ("Bravo! Vous avez trouvé.".equals(reponse)) {
                    break;
                }
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
