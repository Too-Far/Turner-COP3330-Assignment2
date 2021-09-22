package ex34;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Turner
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App
{

    public static void displayNewList(String[] arrayOfNames) {
        System.out.println("There are " +arrayOfNames.length + " employees");
        for (String arrayOfName: arrayOfNames) {
            System.out.println(arrayOfName);
        }
    };

    public static void displayArrayAndGetRemoval(String[] arrayOfNames) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameToRemove;
        System.out.println("There are " + arrayOfNames.length + " employees: ");
        for (String arrayOfName : arrayOfNames) {
            System.out.println(arrayOfName);
        };

        System.out.println("Enter an employee to remove: ");
        nameToRemove = reader.readLine();

        displayNewList(removeItemFromArray(arrayOfNames, nameToRemove));
    }
    public static String[] removeItemFromArray(String[] arrayOfNames, String nameToRemove) throws Exception {
        final List<String> list = new ArrayList<String>();
        Collections.addAll(list, arrayOfNames);
        try {
            if (list.contains(nameToRemove)) {
                list.remove(nameToRemove);
            } else {
                throw new Exception("The name " + nameToRemove +" does not exist");
            }
        } catch (Exception e) {
            System.out.println("The name " + nameToRemove + " does not exist");
            System.out.println();
            System.out.println();
        }
        list.remove(nameToRemove);
        return list.toArray(new String[list.size()]);
    }


    public static void main( String[] args ) throws Exception
    {
        String[] arrayOfNames = {
                "Ryan Turner",
                "Bob Builder",
                "Sam Adams",
                "Paul Blart",
        };
        displayArrayAndGetRemoval(arrayOfNames);
    }
}
