package ex32;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Turner
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

class HandleGuesses
{

    public static int compareGuessWithRandom(int currentGuess, int randomNum){
        if (currentGuess == randomNum) {
            return 3;
        } else if (currentGuess < randomNum) {
            return 1;
        } else if (currentGuess > randomNum) {
            return 2;
        }
        return -1;
    }

    public static void getAllGuesses(int randomNumber, int lowOrHigh) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int totalGuesses = 1;
        int currentGuess;
        boolean flag = true;
         //lowOrHigh == 1 for low 2 for high 3 for on the money

        while (flag) {
            if (lowOrHigh == 3) {
                System.out.println("You got it in " + totalGuesses + " guesses!");
                flag = false;
            } else if (lowOrHigh == 1) {
                System.out.println("Too low, Guess again: ");
                totalGuesses += 1;
                try {
                    currentGuess = Integer.parseInt(reader.readLine());
                    lowOrHigh = compareGuessWithRandom(currentGuess, randomNumber);
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number");
                    totalGuesses += 1;
                }
            } else if (lowOrHigh == 2) {
                System.out.println("Too high, guess again: ");
                totalGuesses += 1;
                try {
                    currentGuess = Integer.parseInt(reader.readLine());
                    lowOrHigh = compareGuessWithRandom(currentGuess, randomNumber);
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number");
                    totalGuesses += 1;
                }
            }
        }
    }

    public static void startGuesses(int randomNumber) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int guess = 0;
        // Handle first attempt;
        try {
            System.out.println("I have my number, whats your guess? ");
            guess = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number");
        }
        if (guess == randomNumber) {
            System.out.println("You got it in one guess!");
        } else {
            int lowOrHigh = compareGuessWithRandom(guess, randomNumber);
            getAllGuesses(randomNumber, lowOrHigh);
        }

    }
}

public class App
{

    public static int generateRandomNumber(int difficulty) {
        // 1 = 10 2 = 100 3 = 1000
        Random random = new Random();
        if (difficulty == 1) {
            System.out.println(random.nextInt(11));
            return random.nextInt(11);
        } else if (difficulty == 2) {
            return random.nextInt(101);
        } else if (difficulty == 3) {
            return random.nextInt(1001);
        } else {
            return -1;
        }
    }

    public static int validateNumber(String input) {
        int intVariable;
        try {
            intVariable = Integer.parseInt(input);
            return intVariable;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    public static int getDifficulty() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String diffString;
        int difficulty = 0;
        boolean flag = true;
        while (flag) {
                System.out.println("Enter the difficulty level (1, 2 or 3): ");
                diffString = reader.readLine();
                difficulty = validateNumber(diffString);
                if (difficulty != -1) {
                    flag = false;
                }
        }
        return difficulty;
    }

    public static void main( String[] args ) throws IOException
    {
        int difficulty = getDifficulty();
        int randomNumber = generateRandomNumber(difficulty);
        HandleGuesses.startGuesses(randomNumber);
    }
}
