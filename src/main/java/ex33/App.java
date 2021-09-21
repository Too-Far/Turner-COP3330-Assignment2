package ex33;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Turner
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class App
{
    public static void getAnswer() {
        String[] answers = {"Yes", "No", "Maybe", "Ask again later"};
        Random random = new Random();
        System.out.println(answers[random.nextInt(4)]);

    }

    public static void getUserInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String question;
        System.out.println("What is your question? ");
        question = reader.readLine();
        getAnswer();
    }

    public static void main( String[] args ) throws IOException
    {
        getUserInput();
    }
}
