package jeux;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IJeu extends Remote {
    String devinerNombre(int proposition) throws RemoteException;
    int getTentativesRestantes() throws RemoteException;
}
