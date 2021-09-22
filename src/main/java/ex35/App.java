package ex35;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Turner
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class App
{
    public static void pickWinnerAndDisplay(List<String> names, int size) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(size);
        System.out.println("The winner is.... " + names.get(randomIndex));
    }

    public static void collectNames() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final List<String> names = new ArrayList<String>();
        String name;
        boolean flag = true;
        while (flag) {
            System.out.println("enter a name: ");
            name = reader.readLine();
            if (!Objects.equals(name, "")) {
                names.add(name);
            } else {
                flag = false;
                pickWinnerAndDisplay(names, names.size());
            }
        }
    };

    public static void main( String[] args ) throws IOException
    {
        collectNames();
    }
}
