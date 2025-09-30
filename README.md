# Jeu RMI

Un jeu de devinette développé en **Java RMI**.  
Le serveur génère un nombre secret entre 1 et 100, et le client doit le deviner en un nombre limité de tentatives.

## 🚀 Fonctionnalités
- Communication client-serveur via **Java RMI**
- Gestion des tentatives par client
- Retour dynamique : *"Plus grand"*, *"Plus petit"*, ou *"Bravo! Vous avez trouvé."*

## 📂 Structure du projet
  ClientRMI/
  ├── src/
  │ ├── jeu/Client.java
  │ ├── jeu/IJeu.java
  │ ├── jeux/IJeu.java
  │ ├── jeux/JeuImpl.java
  │ └── jeux/Serveur.java

