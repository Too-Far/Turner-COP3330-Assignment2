package ex28;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Turner
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{
    public static void createOutput(int sum) {
        System.out.println("The total is " + sum);
    }

    public static void handleCalcs(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        createOutput(sum);
    }

    public static int[] getInput()throws IOException {
        int[] numbers;
        int numOfNumbers;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("How many numbers would you like to add?");
        numOfNumbers = Integer.parseInt(reader.readLine());

        // Init array
        numbers = new int[numOfNumbers];
        
        for (int i = 0; i < numOfNumbers; i++) {
            int currentNum = i + 1;
            System.out.println("Enter number " + currentNum);
            numbers[i] = Integer.parseInt(reader.readLine());
        }

        return numbers;
    }
    public static void main( String[] args ) throws IOException
    {
        int[] numbers = getInput();
        handleCalcs(numbers);
    }
}
