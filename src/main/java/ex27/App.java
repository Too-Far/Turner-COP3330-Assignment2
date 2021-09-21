package ex27;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Turner
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

class HandleVerification
{
    public static boolean fNamePasses;
    private static boolean lNamePasses;
    private static boolean zipCodePasses;
    private static boolean eIDPasses;

    public static void checkEID(String id) {
        String regex = "^[a-zA-Z]{2}-[0-9]{4}$";
        if (Pattern.matches(regex, id)) {
            eIDPasses = true;
        }
    }

    public static void checkZipCode(String zip) {
        if(Pattern.matches("^[0-9]{5}$", zip)) {
            zipCodePasses = true;
        }
    }

    public static void checkLName(String lName) {
        if (lName != null && !lName.trim().isEmpty() && lName.length() >= 2) {
            lNamePasses = true;
        }
    }

    public static void checkFName(String fName) {
        if (fName != null && !fName.trim().isEmpty() && fName.length() >=2) {
            fNamePasses = true;
        }
    }

    public static boolean getEIDPasses () {
        return eIDPasses;
    }

    public static boolean getZipCodePasses() {
        return zipCodePasses;
    }

    public static boolean getLNamePasses() {
        return lNamePasses;
    }

    public static boolean getFNamePasses() {
        return fNamePasses;
    }
}

public class App
{
    public static void generateMessage(String fName, String lName, String zip, String eId) {
        if (HandleVerification.getFNamePasses()
                && HandleVerification.getLNamePasses()
                && HandleVerification.getEIDPasses()
                && HandleVerification.getZipCodePasses()) {
            System.out.println("All of your entries are valid.");
        } else if (!HandleVerification.getFNamePasses()) {
            System.out.println("The first name " + fName +" is not valid. The entry must contain two characters.");
        } else if (!HandleVerification.getLNamePasses()) {
            System.out.println("The last name " +lName +" is not valid. The entry must contain two characters ");
        } else if (!HandleVerification.getZipCodePasses()) {
            System.out.println("The zip code " + zip +" is not valid. It must be a 5 digit number.");
        } else if (!HandleVerification.getEIDPasses()){
            System.out.println("The EID " + eId + " is not valid. Must follow format `AA-1234`");
        }
    }

    public static void getInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName;
        String lName;
        String zipCode;
        String eID;
        System.out.println("Enter the first name");
        fName = reader.readLine();
        HandleVerification.checkFName(fName);

        System.out.println("Enter the last name");
        lName = reader.readLine();
        HandleVerification.checkLName(lName);

        System.out.println("Enter the ZIP code");
        zipCode = reader.readLine();
        HandleVerification.checkZipCode(zipCode);

        System.out.println("Enter the employee ID: ");
        eID = reader.readLine();
        HandleVerification.checkEID(eID);

        generateMessage(fName, lName, zipCode, eID);
    }

    public static void main( String[] args ) throws IOException
    {
        getInput();
    }
}
