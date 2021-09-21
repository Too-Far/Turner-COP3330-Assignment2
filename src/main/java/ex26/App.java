package ex26;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Turner
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class PaymentCalculator
{
    public static void calculateMonthsUntilPaidOff(double trueApy, double balance, double paymentAmount) {
    // n = -(1/30) * log(1 + b/p * (1 - (1 + i)^30)) / log(1 + i)
        System.out.println(trueApy);
        System.out.println(balance);
        System.out.println(paymentAmount);
        double months = -(1.0 / 30) * Math.log(1 + (balance / paymentAmount) * (1 - Math.pow((1 + trueApy), 30)) / Math.log(1 + trueApy));
        System.out.println(months);
    }
}

public class App
{
    public static double convertAPR(double apr) {
        double apiVal = apr / 100;
        System.out.println(apiVal);
        return apiVal / 360;
    }

    public static void getInput() throws IOException {
        double balance;
        double percentage;
        double paymentAmount;
        double trueApy;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What is your balance? ");
        balance = Double.parseDouble(String.valueOf(reader.readLine()));

        System.out.println("What is the APR on the card (as a percent)? ");
        percentage = Double.parseDouble(String.valueOf(reader.readLine()));

        System.out.println("What is the monthly payment you can make? ");
        paymentAmount = Double.parseDouble(String.valueOf(reader.readLine()));
        // Convert input percentage to a decimal and convert to apy.
        trueApy = convertAPR(percentage);
        PaymentCalculator.calculateMonthsUntilPaidOff(trueApy, balance, paymentAmount);
    }

    public static void main( String[] args ) throws IOException {
        getInput();
    }
}
/*
* It can take a lot longer to pay off your credit card balance than you might realize.
* And the formula for figuring that out isn’t pretty. Hiding the formula’s complexity with a function can help you keep your code organized.

Write a program that will help you determine how many months it will take to pay off
* a credit card balance. The program should ask the user to enter the balance of a credit card,
* the APR of the card, and their monthly payment. The program should then return the number of months needed (rounded up to the next integer value).

The formula for this is

n = -(1/30) * log(1 + b/p * (1 - (1 + i)^30)) / log(1 + i)
where

n is the number of months.
i is the daily rate (APR divided by 365).
b is the balance.
p is the monthly payment.
Example Output
What is your balance? 5000
What is the APR on the card (as a percent)? 12
What is the monthly payment you can make? 100
It will take you 70 months to pay off this card.
Constraints
Prompt for the card’s APR. Do the division internally.
Prompt for the APR as a percentage, not a decimal.
Use a class called PaymentCalculator with a public method called calculateMonthsUntilPaidOff, which returns the number of months.
Round fractions of a cent up to the next cent.
* */