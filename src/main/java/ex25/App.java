package ex25;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Turner
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class App
{
    public static void createOutput(int score, String password) {
        switch (score) {
            case 0:
                System.out.println("The password " + password + " is very weak.");
                break;
            case 1:
                System.out.println("The password " + password + " is a weak password.");
                break;
            case 2:
                System.out.println("The password " + password + " is a strong password.");
                break;
            case 3:
                System.out.println("The password " + password + " is a very strong password.");
        }
    }

    public static int passwordValidator(String password) {
        Pattern numberPattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Pattern charPattern = Pattern.compile("^[a-zA-Z]*$");
        Pattern charAndNum = Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]+$");
        Pattern withSpecial = Pattern.compile("^(?=.*[A-Za-z])(?=.*[!@#$%&*()_+=|<>?{}\\[\\]~-])(?=.*[0-9])[A-Za-z0-9!@#$%&*()_+=|<>?{}\\[\\]~-]+$");


        if (password.length() < 8 && numberPattern.matcher(password).matches()) {
            return 0;
        }
        if (password.length() < 8 && charPattern.matcher(password).matches()) {
            return 1;
        }
        if (password.length() < 8) {
            if (charPattern.matcher(password).matches()) {
                return 1;
            } else if (charAndNum.matcher(password).matches()) {
                return 1;
            }
        }
        if (withSpecial.matcher(password).matches()) {
            if (password.length() >= 8) {
                return 3;
            }
        }

        if (password.length() >= 8) {
            if (charAndNum.matcher(password).matches()) {
                {
                    return 2;
                }
            }
         }

        return 0;
    }

    public static String getPassword() throws IOException {
        String password;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter your desired password: ");
        password = reader.readLine();
        return password;
    }

    public static void main( String[] args ) throws IOException
    {
        String password;
        password = getPassword();
        int passwordScore = passwordValidator(password);
        createOutput(passwordScore, password);
    }
}
