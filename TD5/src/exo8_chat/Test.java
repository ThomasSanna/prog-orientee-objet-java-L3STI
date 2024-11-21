package exo8_chat;

import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Entrez une donnée: ");
    String input = scanner.nextLine();
    System.out.println("Vous avez entré: " + input);
    scanner.close();
  }
}
