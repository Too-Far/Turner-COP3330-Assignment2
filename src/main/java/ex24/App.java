package ex24;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Turner
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

final class IsAnagram {
    private final boolean isAnagram;
    private final String str1;
    private final String str2;

    public IsAnagram(boolean _isAnagram, String _str1, String _str2) {
        this.str1 = _str1;
        this.str2 = _str2;
        this.isAnagram = _isAnagram;
    }

    public void message() {
        if (this.isAnagram) {
            System.out.println(str1 +" and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " +str2 + " are not anagrams.");
        }
    }
}

public class App
{

    public static boolean isAnagram(char[] str1, char[] str2){
        int n1 = str1.length;
        int n2 = str2.length;

        //If the words are not the same size they cannot be anagrams
        if (n1 != n2) {
            return false;
        }

        Arrays.sort(str1);
        Arrays.sort(str2);

        for (int i=0; i < n1; i++) {
            if (str1[i] != str2[i]) {
                return false;
            }
        }

        return true;
    }

    public static IsAnagram getStrings() throws IOException {
        String stringOne;
        String stringTwo;
        char[] str1;
        char[] str2;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter two strings and I'll tell you if they are anagrams:");

        System.out.println("Enter the first string: ");
        stringOne = reader.readLine();

        System.out.println("Enter the second string: ");
        stringTwo = reader.readLine();

        str1 = stringOne.toCharArray();
        str2 = stringTwo.toCharArray();

        boolean anagram = isAnagram(str1, str2);
        return new IsAnagram(anagram, stringOne, stringTwo);
    }
    public static void main( String[] args ) throws IOException {
        IsAnagram result = getStrings();
        result.message();
    }
}
