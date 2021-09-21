package ex29;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Turner
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{
    public static void generateOutput(int years) {
        System.out.println("It will take " + years + " years to double your initial investment.");
    }

    public static void calcReturn(int rate) {
        int years = 72 / rate;
        generateOutput(years);
    }

    public static void getInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rate;
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("What is the rate of return? ");
                rate = Integer.parseInt(reader.readLine());
                if (rate > 0) {
                    calcReturn(rate);
                    flag = false;
                } else {
                    System.out.println("You cannot use zero as a rate of return!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Sorry that's not a valid input");
            }
        }
    }

    public static void main( String[] args ) throws IOException
    {
        getInput();
    }
}
