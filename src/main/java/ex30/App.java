package ex30;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Turner
 */

public class App
{
    public static void printMultiplicationTable() {
        System.out.format("      ");
        for (int i = 1; i < 13; i++) {
            System.out.format("%4d", i);
        }
        System.out.println();
        System.out.println("      ------------------------------------------------");

        for (int i = 1; i < 13; i++) {
            System.out.format("%4d |", i);
            for (int j = 1; j < 13; j++) {
                int value = i * j;
                System.out.format("%4d", value);
            }
            System.out.println();
        }
    }

    public static void main( String[] args )
    {
        printMultiplicationTable();
    }
}
