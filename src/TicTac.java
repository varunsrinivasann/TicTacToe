import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class TicTac {
    String[] data = new String[9];
    Scanner userInputData = new Scanner(System.in);
    Random random = new Random();
    Boolean gameOver = false;
    // The Constructor, upon being called, it should automatically start the game.
    TicTac(){
        //First we need to fill up all the parts of this with a space, which can later be replaced as the game goes on!
        fill();
        render();
        userInput();
    }
    // This function is responsible for first filling up all the data points with spaces
    public void fill() {
        for(int i = 0; i < 9; i++) {
            data[i] =  " " + i + " ";
        }
    }

    // This function will repeatedly prompt the user to input their x's until the game is over ( a maximum of around 9 times )
    public void render() {
        //prompt the user for their choice first using the input function
        System.out.println("\n"); // the first line
        System.out.println(data[0] + "|" + data[1] +"|" + data[2] ); // the first line
        System.out.println("___" + "|" + "___" +"|" + "___" ); // the visuals
        System.out.println(data[3] + "|"+ data[4] +"|" + data[5] ); // the second line
        System.out.println("___" + "|" + "___" +"|" + "___" ); // the visuals
        System.out.println(data[6] + "|" + data[7] +"|" + data[8] ); // the third line


    }
    // This function will take in the user input and update the Data array in order to store the user input
    private void userInput() {
        int userSquare;
        int cpuSquare;
        do {
            System.out.print("Enter which box you want to enter the 'x' in - ");
            userSquare = userInputData.nextInt(); // send the x and the square number
        }while(data[userSquare].equals(" o ") || data[userSquare].equals(" x "));
        updateData(userSquare,'x');
        render();
        checkWinner();
        if(gameOver) {
            return;
        }

        do {
            cpuSquare = random.nextInt(9);
        }while (data[cpuSquare].equals(" o ") || data[cpuSquare].equals(" x "));
        updateData(cpuSquare,'o'); // send the o and the square number
        render();
        checkWinner();
        if(gameOver) {
                return;
        }
        userInput();
    }

    private void updateData(int square, char a) {
        //store the data on the array
        String newSquare = " " + a + " ";
        data[square] = newSquare;
    }

    private void checkWinner(){
        //first row
        for(int i = 0; i < 3; i++){
            if( data[i].equals(" x ") && data[i + 3].equals(" x ") && data[i + 6].equals(" x ")) {
                System.out.println(("You Win!"));
                gameOver = true;
            }
            else if ( data[i].equals(" o ") && data[i + 3].equals(" o ") && data[i + 6].equals(" o "))
            {
                System.out.println(("You Lose :("));
                gameOver = true;
            }
        }

        // first column
        for(int i = 0; i < 7; i = i + 3){
            if( data[i].equals(" x ") && data[i + 1].equals(" x ") && data[i + 2].equals(" x ")) {
                System.out.println(("You Win!"));
                gameOver = true;
            }
            else if ( data[i].equals(" o ") && data[i + 1].equals(" o ") && data[i + 2].equals(" o "))
            {
                System.out.println(("You Lose :("));
                gameOver = true;
            }
        }
        // first diagonal
        {
            int i = 0;
            if( data[i].equals(" x ") && data[i + 4].equals(" x ") && data[i + 8].equals(" x ")) {
                System.out.println(("You Win!"));
                gameOver = true;
            }
            else if ( data[i].equals(" o ") && data[i + 4].equals(" o ") && data[i + 8].equals(" o "))
            {
                System.out.println(("You Lose :("));
                gameOver = true;
            }
        }
        // Second diagonal
        {
            int i = 2;
            if( data[i].equals(" x ") && data[i + 2].equals(" x ") && data[i + 4].equals(" x ")) {
                System.out.println(("You Win!"));
                gameOver = true;
            }
            else if ( data[i].equals(" o ") && data[i + 2].equals(" o ") && data[i + 4].equals(" o ")) {
                System.out.println(("You Lose :("));
                gameOver = true;
            }
        }
    }
}