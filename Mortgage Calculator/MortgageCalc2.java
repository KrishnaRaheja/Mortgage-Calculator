//Refer to https://www.wikihow.com/Calculate-Mortgage-Payments for the Mortgage calculator equation

/* #region import*/
import java.util.*; import java.lang.Math;
import java.math.*;
import java.security.Principal;
import java.text.*;
/* #endregion */ 

public class MortgageCalc2 {
    public static void main(String[]args) {
        System.out.println();
        System.out.println("This is a Mortgage Calculator");

        /* #region Scanners */ 
        
        Scanner sc1 = new Scanner(System.in);
        double loanAmount = 0;   
        while (true) {
            System.out.println();
            System.out.print("Loan amount (Dollars, Euros, JPY): ");
            loanAmount = sc1.nextDouble();
            if (loanAmount <= 1000000 && loanAmount >= 1000)
            break;
            System.out.println("Enter a number between $1,000 and $1,000,000");
        }

        Scanner sc2 = new Scanner(System.in);
        float annualInterestRatePercent = 0;
        while(true) {
            System.out.println();
            System.out.print("Annual Interest rate in %: ");
            annualInterestRatePercent = sc2.nextFloat();
            if (annualInterestRatePercent >= 0 && annualInterestRatePercent <= 30)
            break;
            System.out.println("Enter a value >= 0 and <= 30");
        } 

        Scanner sc3 = new Scanner(System.in);
        float periodYears = 0;
        while (true) {
            System.out.println();
            System.out.print("Period (Years): ");
            periodYears = sc3.nextFloat();
            if (periodYears > 0 && periodYears <= 30)
            break;
            System.out.println("Enter a time period between 0 years and 30");
        }       
        
        /* #endregion */ 

        /* #region Calculation */
        // Time period in months
            double periodMonths = periodYears * 12;
        
        // Annual interest rate to monthly interest rate
            float percent = 100;
            float monthsInAYear = 12;
            float monthlyIntrestRate = (annualInterestRatePercent/percent)/monthsInAYear;

        // monthlyInterestRate * (1 + monthlyInterestRate) ^ periodMonths
            float onePlusMonthlyRate = 1 + monthlyIntrestRate;
            double parenthesisTop = Math.pow(onePlusMonthlyRate, periodMonths);
            double fullTop = parenthesisTop * monthlyIntrestRate;
        
        // (1 + monthlyInterestRate) - 1
            double fullBottom = parenthesisTop - 1;  
           
        // Top of equation / Bottom of equation
            double withoutMultiplyingPrincipal = fullTop/fullBottom;
            
        // Principal * (Top of equation / Bottom of equation) 
            double Mortgage = loanAmount * withoutMultiplyingPrincipal;
        /* #endregion */

        /* #region Currency Format */

        Scanner sc4 = new Scanner(System.in);
        byte currency = 0;

        while (true) {
            System.out.println();
            System.out.print("Enter 1 for US dollars, 2 for UK pounds, or 3 for Japanese yen (JPY): ");
            currency = sc4.nextByte();
            if (currency >= 1 && currency <= 3)
            break;
            System.out.println("Enter numbers 1, 2, or 3 only");
        }

        String answer = "";

        switch (currency) {
            case 1:
            NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
            answer = us.format(Mortgage);
            break;

            case 2:
            NumberFormat uk = NumberFormat.getCurrencyInstance(Locale.UK);
            answer = uk.format(Mortgage);
            break;

            case 3:
            NumberFormat oniichan = NumberFormat.getCurrencyInstance(Locale.JAPAN);
            answer = oniichan.format(Mortgage);
            //no break statment needed here because this is the end of the loop
        } 

        System.out.println();
        System.out.println("Monthly payment: " + answer);
        System.out.println();

        /* #endregion */
    }
}
