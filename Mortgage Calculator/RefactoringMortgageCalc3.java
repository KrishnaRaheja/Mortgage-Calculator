//Refer to https://www.wikihow.com/Calculate-Mortgage-Payments for the Mortgage calculator equation

/* #region import*/
import java.util.*; import java.lang.Math;
import java.math.*;
import java.security.Principal;
import java.text.*;
/* #endregion */ 

public class RefactoringMortgageCalc3 {
    public static void main(String[]args) {        
        System.out.println("This is a Mortgage Calculator");
        
        double loanAmount = readNumber("Loan amount (Dollars, Euros, JPY): ", 1000, 1_000_000);

        float annualInterestRatePercent = (float) readNumber("Annual Interest rate in %: ", 0, 30);

        float periodYears = (float) readNumber("Period (Years): ", 1, 30);
        
        
        /* #region Calculation & currencyformat */ 
        double Mortgage = calculateMortgage(periodYears, annualInterestRatePercent, loanAmount);
        
        byte currency = (byte) readNumber("Enter 1 for US dollars, 2 for UK pounds, or 3 for Japanese yen (JPY): ", 1, 3);

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
    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.println(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;

     }
    
    public static double calculateMortgage(    
        float periodYears, 
        float annualInterestRatePercent, 
        double loanAmount) {

        float percent = 100;
        float monthsInAYear = 12;
        float monthlyIntrestRate = (annualInterestRatePercent/percent)/monthsInAYear;    
        
        // Time period in months
        double periodMonths = periodYears * monthsInAYear;
        
        double methodMortgage = loanAmount * (monthlyIntrestRate * Math.pow(1 + monthlyIntrestRate, periodMonths)) / (Math.pow(1 + monthlyIntrestRate, periodMonths) - 1);
        return methodMortgage;
    }
}