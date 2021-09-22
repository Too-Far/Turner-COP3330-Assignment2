package ex36;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Turner
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class StatisticalCalcs
{
    private static double AVERAGE;
    private static double SD;
    private static double MIN;
    private static double MAX;
    private static double SUM;
    List<Integer> numbers;

    public StatisticalCalcs (List<Integer> numsArray) {
        this.numbers = numsArray;
        sum();
        average();
        max();
        min();
        std();
    }

    private void sum() {
        for (Integer number : this.numbers) {
            SUM += number;
        }
    }

    private  void average() {
        int length = this.numbers.size();
        AVERAGE = SUM/length;
    }

    private void max() {
        MAX = Collections.max(this.numbers, null);
    }

    private void min() {
        MIN = Collections.min(this.numbers, null);
    }

    private void std() {
        double deviation = 0.0;
        int length = this.numbers.size();
        double mean = SUM / length;
        for (double num: this.numbers) {
            deviation += Math.pow(num - mean, 2);
        }
        SD = Math.sqrt(deviation/length);
    }

    public static double getAVERAGE() {
        return AVERAGE;
    }

    public static double getSD() {
        return SD;
    }

    public static double getMIN() {
        return MIN;
    }

    public static double getMAX() {
        return MAX;
    }

}

public class App
{
    public static List<Integer> getNumbers() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final List<Integer> numbers = new ArrayList<>();

        boolean flag = true;
        System.out.println("Please enter your list of numbers. Type any letter to complete.");
        while (flag) {
            try {
                System.out.println("Enter a number: ");
                numbers.add(Integer.parseInt(reader.readLine()));
            } catch (NumberFormatException e) {
                flag = false;
            }
        }
        return numbers;
    }

    public static void displayValues(List<Integer> numbers) {
        String list = Arrays.toString(numbers.toArray()).replace("[", "").replace("]", "");
        System.out.println("Numbers: " + list);

        System.out.println("The average is " + StatisticalCalcs.getAVERAGE());
        System.out.println("The minimum is " + StatisticalCalcs.getMIN());
        System.out.println("The maximum is " + StatisticalCalcs.getMAX());
        System.out.println("The standard deviation is " + StatisticalCalcs.getSD());
    }


    public static void main( String[] args ) throws IOException
    {
        List<Integer> numbers = getNumbers();
        StatisticalCalcs calcs = new StatisticalCalcs(numbers);
        displayValues(numbers);
    }
}
