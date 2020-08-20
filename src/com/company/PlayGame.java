package com.company;

import java.util.Random;
import java.util.Scanner;

public class PlayGame {
    //variables to store player names
    private String player1Name;
    private String player2Name;
    private String player3Name;
    private String player4Name;

    //variable for winner name
    private String winner= "";

    //variable for keeping turns
    private int turn=1;

    //variables to store players' positions
    private int player1Position=0;
    private int player2Position=0;
    private int player3Position=0;
    private int player4Position=0;

    //getters and setters
    public String getPlayer1Name() {
        return player1Name;
    }

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }

    public String getPlayer3Name() {
        return player3Name;
    }

    public void setPlayer3Name(String player3Name) {
        this.player3Name = player3Name;
    }

    public String getPlayer4Name() {
        return player4Name;
    }

    public void setPlayer4Name(String player4Name) {
        this.player4Name = player4Name;
        //starting the game
        System.out.println("*******************************************");
        playGame();
    }

    //main playGame function
    public void playGame(){
        Scanner scanner= new Scanner(System.in);//declaring scanner
        //keep playing while winner String is empty
        while(winner.isEmpty()){
            printBoard();//printing board
            if(turn==1){
                System.out.println("\n" + getPlayer1Name() + " turn (*)");//telling user whose turn it is
                int num= rollDice();//rolling dice
                if(player1Position+num<=100){
                    player1Position+=num;//changing position
                }
                if(checkWin(player1Position)){
                    winner= player1Name;
                    printBoard();
                }
                checkSnake(1, player1Position);//checking if we landed on a snake
                checkLadder(1, player1Position);//checking if we landed on a ladder
                turn++;//moving the play on to the next player
            }
            //doing the same for the other players
            else if(turn==2){
                System.out.println("\n" + getPlayer2Name() + " turn ($)");
                int num= rollDice();
                if(player2Position+num<=100){
                    player2Position+=num;//changing position
                }
                if(checkWin(player2Position)){
                    winner= player2Name;
                    printBoard();
                }
                checkSnake(2, player2Position);
                checkLadder(2, player2Position);
                turn++;
            }
            else if(turn==3){
                System.out.println("\n" + getPlayer3Name() + " turn (@)");
                int num= rollDice();
                if(player3Position+num<=100){
                    player3Position+=num;//changing position
                }
                if(checkWin(player3Position)){
                    winner= player3Name;
                    printBoard();
                }
                checkSnake(3, player3Position);
                checkLadder(3, player3Position);
                turn++;
            }
            else{
                System.out.println("\n" + getPlayer4Name() + " turn (%)");
                int num= rollDice();
                if(player4Position+num<=100){
                    player4Position+=num;//changing position
                }
                if(checkWin(player4Position)){
                    winner= player4Name;
                    printBoard();
                }
                checkSnake(4, player4Position);
                checkLadder(4, player4Position);
                turn=1;
            }
        }
        printFinalMessage();//winner printed
    }

    private boolean checkWin(int position){
        boolean result;
        if(position==100){
            result= true;
        }
        else{
            result=false;
        }
        return result;
    }

    //function to roll dice
    private int rollDice(){
        Random rand = new Random();
        Scanner scanner= new Scanner(System.in);

        int totalMoves=0;
        int num=6;

        while(num==6){
            System.out.println("Press enter to roll");//giving the user a chance to roll
            scanner.nextLine();//waiting for enter key
            num= rand.nextInt((6-1)+1) +1;
            System.out.println("Rolled: " + num);
            totalMoves+=num;
        }
        return totalMoves;
    }

    //function to print the board
    private void printBoard(){
        for(int i=100; i>=1; i--){
            if(i%10==0){
                System.out.println();
            }
            if(i==player1Position){
                System.out.print("  * ");
            }
            else if(i==player2Position){
                System.out.print("  $ ");
            }
            else if(i==player3Position){
                System.out.print("  @ ");
            }
            else if(i==player4Position){
                System.out.print("  % ");
            }
            else if(i==32 || i==36 || i==48 || i==62 || i==88 || i==95 || i==97){
                System.out.print("  S ");
            }
            else if(i==1 || i==4 || i==8 || i==21 || i==28 || i==50 || i==71 || i==80){
                System.out.print("  L ");
            }
            else{
                System.out.print(" " + i + " ");
                if(i<10){
                    System.out.print(" ");
                }
            }
        }
    }

    //checks if you are at the mouth of a snake and need to go down
    private void checkSnake(int playerNum, int playerPosition){
        if(playerPosition==97){
            if(playerNum==1){
                player1Position= 78;
            }
            else if(playerNum==2){
                player2Position= 78;
            }
            else if(playerNum==3){
                player3Position= 78;
            }
            else{
                player4Position= 78;
            }
        }
        else if(playerPosition==95){
            if(playerNum==1){
                player1Position= 56;
            }
            else if(playerNum==2){
                player2Position= 56;
            }
            else if(playerNum==3){
                player3Position= 56;
            }
            else{
                player4Position= 56;
            }
        }
        else if(playerPosition==88){
            if(playerNum==1){
                player1Position= 24;
            }
            else if(playerNum==2){
                player2Position= 24;
            }
            else if(playerNum==3){
                player3Position= 24;
            }
            else{
                player4Position= 24;
            }
        }
        else if(playerPosition==62){
            if(playerNum==1){
                player1Position= 18;
            }
            else if(playerNum==2){
                player2Position= 18;
            }
            else if(playerNum==3){
                player3Position= 18;
            }
            else{
                player4Position= 18;
            }
        }
        else if(playerPosition==36){
            if(playerNum==1){
                player1Position= 6;
            }
            else if(playerNum==2){
                player2Position= 6;
            }
            else if(playerNum==3){
                player3Position= 6;
            }
            else{
                player4Position= 6;
            }
        }
        else if(playerPosition==48){
            if(playerNum==1){
                player1Position= 26;
            }
            else if(playerNum==2){
                player2Position= 26;
            }
            else if(playerNum==3){
                player3Position= 26;
            }
            else{
                player4Position= 26;
            }
        }
        else if(playerPosition==32){
            if(playerNum==1){
                player1Position= 10;
            }
            else if(playerNum==2){
                player2Position= 10;
            }
            else if(playerNum==3){
                player3Position= 10;
            }
            else{
                player4Position= 10;
            }
        }
        else{
            System.out.println("\nLuckily you didn't run into a snake");
        }
    }

    //checks if you are at the bottom of a ladder and need to go up
    private void checkLadder(int playerNum, int playerPosition){
        if(playerPosition==80){
            if(playerNum==1){
                player1Position= 99;
            }
            else if(playerNum==2){
                player2Position= 99;
            }
            else if(playerNum==3){
                player3Position= 99;
            }
            else{
                player4Position= 99;
            }
        }
        else if(playerPosition==28){
            if(playerNum==1){
                player1Position= 76;
            }
            else if(playerNum==2){
                player2Position= 76;
            }
            else if(playerNum==3){
                player3Position= 76;
            }
            else{
                player4Position= 76;
            }
        }
        else if(playerPosition==8){
            if(playerNum==1){
                player1Position= 30;
            }
            else if(playerNum==2){
                player2Position= 30;
            }
            else if(playerNum==3){
                player3Position= 30;
            }
            else{
                player4Position= 30;
            }
        }
        else if(playerPosition==4){
            if(playerNum==1){
                player1Position= 14;
            }
            else if(playerNum==2){
                player2Position= 14;
            }
            else if(playerNum==3){
                player3Position= 14;
            }
            else{
                player4Position= 14;
            }
        }
        else if(playerPosition==1){
            if(playerNum==1){
                player1Position= 38;
            }
            else if(playerNum==2){
                player2Position= 38;
            }
            else if(playerNum==3){
                player3Position= 38;
            }
            else{
                player4Position= 38;
            }
        }
        else if(playerPosition==21){
            if(playerNum==1){
                player1Position= 42;
            }
            else if(playerNum==2){
                player2Position= 42;
            }
            else if(playerNum==3){
                player3Position= 42;
            }
            else{
                player4Position= 42;
            }
        }
        else if(playerPosition==50){
            if(playerNum==1){
                player1Position= 67;
            }
            else if(playerNum==2){
                player2Position= 67;
            }
            else if(playerNum==3){
                player3Position= 67;
            }
            else{
                player4Position= 67;
            }
        }
        else if(playerPosition==71){
            if(playerNum==1){
                player1Position= 92;
            }
            else if(playerNum==2){
                player2Position= 92;
            }
            else if(playerNum==3){
                player3Position= 92;
            }
            else{
                player4Position= 92;
            }
        }
        else{
            System.out.println("\nOops no ladders for you :)");
        }
    }

    private void printFinalMessage(){
        System.out.println("\n***************************************");
        System.out.println("The winner is: " + winner.toUpperCase());
    }
}
