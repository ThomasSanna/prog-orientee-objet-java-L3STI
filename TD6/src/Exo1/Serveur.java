package Exo1;

import java.io.*;
import java.net.*;

import Exo1.ActionServeur.ReceivePersonne;

public class Serveur {

  public static void main(String[] args) {

    try{
      ServerSocket serverSocket = new ServerSocket(2000);

      while (true){
        Socket client = serverSocket.accept();

        Thread receivePersonneThread = new Thread(new ReceivePersonne(client));
        receivePersonneThread.start();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}