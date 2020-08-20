package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Snakes & Ladders");//welcome message

        PlayGame newGame= new PlayGame();//creating an instance of PlayGame class

        Scanner scanner= new Scanner(System.in);//declaring the scanner

        //setting player names
        System.out.println("Enter Player 1 Name");
        newGame.setPlayer1Name(scanner.nextLine());

        System.out.println("Enter Player 2 Name");
        newGame.setPlayer2Name(scanner.nextLine());

        System.out.println("Enter Player 3 Name");
        newGame.setPlayer3Name(scanner.nextLine());

        System.out.println("Enter Player 4 Name");
        newGame.setPlayer4Name(scanner.nextLine());

        scanner.close();
    }
}
