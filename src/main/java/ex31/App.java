package ex31;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Turner
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{
    public static void calculateKarvonen(int age, int heartRate) {
        System.out.format("");
        System.out.println("Intensity   |  Rate");
        System.out.println();
        System.out.format("--------------------");
        System.out.println();
        for (double i = 0.55; i < 0.96; i+=0.05) {
            int intensity = (int) (i * 100);
            int target = (int) ((((220 - age) - heartRate) * i) + heartRate);
            System.out.format("%-10s %-10s",intensity, "|  " + target);
            System.out.println();
        }
    }

    public static void getInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int heartRate = 0;
        int age = 0;
        boolean flag = true;

        while(flag) {
            try {
                if (age == 0) {
                    System.out.println("Please enter your age: ");
                    age = Integer.parseInt(reader.readLine());
                }
                if (heartRate == 0) {
                    System.out.println("Please enter your resting heart rate: ");
                    heartRate = Integer.parseInt(reader.readLine());
                }
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
        calculateKarvonen(age, heartRate);
    }
    public static void main( String[] args ) throws IOException
    {
        getInput();
    }
}
