package ex37;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Turner
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

class UserInput
{
    private static int minLength;
    private static int numSpecChars;
    private static int numOfNumbers;

    public static void getInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("What is the minimum length? ");
        minLength = Integer.parseInt(reader.readLine());

        System.out.println("How many special characters? ");
        numSpecChars = Integer.parseInt(reader.readLine());

        System.out.println("How many numbers? ");
        numOfNumbers = Integer.parseInt(reader.readLine());
    }

    public static int getMinLength() {
        return minLength;
    }

    public static int getNumSpecChars() {
        return numSpecChars;
    }

    public static int getNumOfNumbers() {
        return numOfNumbers;
    }
}

class PasswordGenerator
{
    int minLength;
    int numSpecialChars;
    int numberofNumbers;
    String[] chars = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    String[] specChars = new String[]{"+", "-", "&", "|", "!", "(", ")", "{", "}", "[", "]", "^",
            "~", "*", "?", ":","\"","\\", "@", "$", "%", "#"};
    String[] numbers = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public PasswordGenerator(int length, int numNums, int numSpec) {
        minLength = length;
        numberofNumbers = numNums;
        numSpecialChars = numSpec;
    }

    public String generatePassword() {

        String[] password = new String[minLength];
        Random rand = new Random();
        if (numberofNumbers + numSpecialChars > minLength) {
            throw new IllegalArgumentException("You must have more letters than numbers + special characters.");
        }
        for (int i=0; i<minLength; i++) {
            int index = 0;
            boolean flag = true;
            while (flag) {
                int interimIndex = rand.nextInt(minLength);
                if (password[interimIndex] == null) {
                    index = interimIndex;
                    flag = false;
                }
            }
            if (numberofNumbers > 0) {
                int charIndex = rand.nextInt(numbers.length);
                password[index] = numbers[charIndex];
                numberofNumbers-=1;
            } else if (numSpecialChars > 0) {
                int charIndex = rand.nextInt(specChars.length);
                password[index] = specChars[charIndex];
                numSpecialChars-=1;
            } else {
                int charIndex = rand.nextInt(chars.length);
                password[index] = chars[charIndex];
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String value: password) {
            builder.append(value);
        }
        return builder.toString();
    }
}

public class App
{

    public static void main( String[] args ) throws IOException {
        UserInput.getInput();

        PasswordGenerator generator = new PasswordGenerator(UserInput.getMinLength(), UserInput.getNumOfNumbers(), UserInput.getNumSpecChars());
        System.out.println(" your password is: " + generator.generatePassword());
    }
}
