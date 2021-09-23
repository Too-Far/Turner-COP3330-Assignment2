package ex39;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Turner
 */

import java.util.*;

public class App
{
    public static void formatOutput(Map<String, String[]> data) {
        Iterator<Map.Entry<String, String[]>> itr = data.entrySet().iterator();
        System.out.format("");
        System.out.println("Intensity   |  Position      | Separation Date");
        System.out.println();
        System.out.format("--------------------");
        System.out.println();
        String format = "|%1$-10s|%2$-10s|%3$-20s|\n";
        while (itr.hasNext()) {
            Map.Entry<String, String[]> entry = itr.next();
            String name = entry.getValue()[1] + " " + entry.getValue()[0];
            System.out.format( name +" | " + entry.getValue()[2] +" | " + entry.getValue()[3]);
            System.out.println();
        };

    }

    public static Map<String, String[]> setData() {
        Map<String, String[]> peopleMap = new HashMap<>();
        String[] person1 = new String[]{"Johnson", "John", "Manager", "2016-12-31"};
        String[] person2 = new String[]{"Xiong", "Tou", "Software Engineer", "2016-10-05"};
        String[] person3 = new String[]{"Michaelson", "Michaela", "District manager", "2015-12-19"};
        String[] person4 = new String[]{"Jacobson", "Jake", "Programmer", ""};
        String[] person5 = new String[]{"Jackson", "Jacquelyn", "DBA", ""};
        String[] person6 = new String[]{"Webber", "Sally", "Web Developer", "2015-12-18"};
        List<String[]> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);
        people.add(person6);

        for(String[] person: people) {
                peopleMap.put(person[0], person);
        }
        return peopleMap;
    }

    public static void main( String[] args )
    {

        Map<String, String[]> data = setData();
        formatOutput(data);
    }
}
