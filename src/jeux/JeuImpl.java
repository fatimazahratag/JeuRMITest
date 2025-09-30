package jeux;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class JeuImpl extends UnicastRemoteObject implements IJeu {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int MAX_TENTATIVES = 5;
    private final int nombreSecret;
    private Map<String, Integer> tentativesParClient;

    public JeuImpl() throws RemoteException {
        super();
        Random rand = new Random();
        this.nombreSecret = rand.nextInt(100) + 1;
        tentativesParClient = new HashMap<>();
        System.out.println("Nombre secret généré : " + nombreSecret);
    }

    private String getClientId() throws RemoteException {
        return Thread.currentThread().getName();
    }

    @Override
    public synchronized String devinerNombre(int proposition) throws RemoteException {
        String clientId = getClientId();
        int essais = tentativesParClient.getOrDefault(clientId, 0);

        if (essais >= MAX_TENTATIVES) {
            return "Nombre de tentatives épuisé. Partie terminée.";
        }

        tentativesParClient.put(clientId, essais + 1);

        if (proposition == nombreSecret) {
            return "Bravo! Vous avez trouvé.";
        } else if (proposition < nombreSecret) {
            return "Plus grand";
        } else {
            return "Plus petit";
        }
    }

    @Override
    public int getTentativesRestantes() throws RemoteException {
        String clientId = getClientId();
        int essais = tentativesParClient.getOrDefault(clientId, 0);
        return MAX_TENTATIVES - essais;
    }
}
