package ex38;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Turner
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class UserHandler
{
    public static int[] gatherInput() throws IOException {
        String temp;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a list of numbers, separated by spaces: ");
        temp = reader.readLine();
        return Stream.of(temp.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}

public class App
{
    public static List<Integer> filterEvenNumbers(int[] nums) {
        List<Integer> numbers = new ArrayList<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                numbers.add(num);
            }
        }
        return numbers;
    }

    public static void main( String[] args ) throws IOException
    {
        int[] numbers = UserHandler.gatherInput();
        System.out.println("The even numbers are: " + Arrays.toString(filterEvenNumbers(numbers).toArray()).replace("[", "").replace("]", ""));
    }
}
