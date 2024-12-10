package Multijoueur;

import java.io.*;
import java.net.*;
import java.util.*;

import Local.*;
import Multijoueur.ActionServeur.*;

public class Serveur {
    private static int clientCount = 0; // 2 min et max
    private static ArrayList<Socket> clientsArrayList = new ArrayList<Socket>();
    private static Map<Socket, Joueur> joueursMap = new HashMap<Socket, Joueur>();
    private static Map<Socket, ObjectOutputStream> outMap = new HashMap<Socket, ObjectOutputStream>();
    private static Map<Socket, ObjectInputStream> inMap = new HashMap<Socket, ObjectInputStream>();
    private static final Object lock = new Object();

    public static void stopServer() {
        for (Socket client : clientsArrayList) {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void resetAll() {
        clientCount = 0;
        clientsArrayList.clear();
        joueursMap.clear();
        outMap.clear();
        inMap.clear();
    }

    public static Map<Socket, Joueur> getJoueursMap() {
        return joueursMap;
    }

    public static Map<Socket, ObjectOutputStream> getOutMap() {
        return outMap;
    }

    public static Map<Socket, ObjectInputStream> getInMap() {
        return inMap;
    }

    public static Joueur getJoueur(Socket client) {
        return joueursMap.get(client);
    }

    public static ObjectOutputStream getOut(Socket client) {
        return outMap.get(client);
    }

    public static ObjectInputStream getIn(Socket client) {
        return inMap.get(client);
    }

    public static void modifJoueurMap(Socket client, Joueur joueur) {
        joueursMap.put(client, joueur);
    }

    public static void setJoueur(Socket client, Joueur joueur) {
        synchronized (lock) {
            joueursMap.put(client, joueur);
            lock.notifyAll();
        }
    }

    public void exec() {
        try {
            try (ServerSocket serverSocket = new ServerSocket(1234)) {
                System.out.println("Serveur démarré sur le port 1234");

                while (true) {
                    while (clientCount < 2) {
                        Socket client = serverSocket.accept();
                        clientCount++;
                        clientsArrayList.add(client);
                        System.out.println("Client connecté : " + clientCount);

                        ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
                        ObjectInputStream in = new ObjectInputStream(client.getInputStream());

                        outMap.put(client, out);
                        inMap.put(client, in);

                        Thread getJoueurInfo = new Thread(new GetJoueurInfo(client, in));
                        getJoueurInfo.start();
                    }

                    synchronized (lock) {
                        while (joueursMap.size() < 2) {
                            lock.wait();
                        }
                    }

                    System.out.println("2 joueurs connectés");
                    Socket client1 = clientsArrayList.get(0);
                    Socket client2 = clientsArrayList.get(1);

                    ObjectOutputStream out1 = outMap.get(client1);
                    ObjectOutputStream out2 = outMap.get(client2);

                    out1.writeObject(joueursMap.get(client2));
                    out2.writeObject(joueursMap.get(client1));

                    BoucleJeu boucleJeu = new BoucleJeu(clientsArrayList, joueursMap, outMap, inMap);
                    boucleJeu.exec();

                    resetAll();
                    System.out.println("Partie terminée, en attente de nouveaux joueurs...");
                }
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Erreur serveur : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Serveur serveur = new Serveur();
        serveur.exec();
    }
}