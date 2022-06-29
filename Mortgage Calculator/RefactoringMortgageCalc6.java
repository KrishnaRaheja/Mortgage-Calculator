//Refer to https://www.wikihow.com/Calculate-Mortgage-Payments for the Mortgage calculator equation

/* #region import*/
import java.util.*; import java.lang.Math;
import java.math.*;
import java.security.Principal;
import java.text.*;
/* #endregion */ 

public class RefactoringMortgageCalc6 {
    static byte percent = 100;
    static byte monthsInAYear = 12;
    public static void main(String[]args) {        
        System.out.println("This is a Mortgage Calculator");
        
        double loanAmount = readNumber("Loan amount (Dollars, Euros, JPY): ", 1000, 1_000_000);

        float annualInterestRatePercent = (float) readNumber("Annual Interest rate in %: ", 0, 30);

        float periodYears = (float) readNumber("Period (Years): ", 1, 30);
        
        double Mortgage = calculateMortgage(periodYears, annualInterestRatePercent, loanAmount);
        
        byte currency = (byte) readNumber("Enter 1 for US dollars, 2 for UK pounds, or 3 for Japanese yen (JPY): ", 1, 3);

        String answerOutput = formatCurrency(currency, Mortgage);
        System.out.println();
        System.out.println("Mortgage:");
        System.out.println("---------");
        System.out.println("Monthly payment: " + answerOutput);
        System.out.println();
        System.out.println("Payment Schedule (Months):");
        System.out.println("--------------------------");
        for (int month = 1; month <= periodYears * monthsInAYear; month++) {
            double balanceCycle = calculateBalance(loanAmount, annualInterestRatePercent, periodYears, month);
            System.out.println(month + ": " + formatCurrency(currency, balanceCycle));
        }
    }

    /* #region Methods */ 
    public static String formatCurrency(byte currency, double Mortgage) {
        String formattedMortgage = "";
        switch (currency) {
            case 1:
            NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
            formattedMortgage = us.format(Mortgage);
            break;

            case 2:
            NumberFormat uk = NumberFormat.getCurrencyInstance(Locale.UK);
            formattedMortgage = uk.format(Mortgage);
            break;

            case 3:
            NumberFormat oniichan = NumberFormat.getCurrencyInstance(Locale.JAPAN);
            formattedMortgage = oniichan.format(Mortgage);
            //no break statment needed here because this is the end of the loop
        } 
        return formattedMortgage;
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
    
    public static double calculateMortgage(float periodYears, float annualInterestRatePercent, double loanAmount) {
        float monthlyIntrestRate = (annualInterestRatePercent/percent)/monthsInAYear;            
        double periodMonths = periodYears * monthsInAYear;
        
        double methodMortgage = loanAmount 
            * (monthlyIntrestRate * Math.pow(1 + monthlyIntrestRate, periodMonths)) 
            / (Math.pow(1 + monthlyIntrestRate, periodMonths) - 1);
        
        return methodMortgage;
    }

    public static double calculateBalance(double loanAmount, float annualInterestRatePercent, float periodYears, int numberOfPaymentsMade) {
        float monthlyIntrestRate = (annualInterestRatePercent/percent)/monthsInAYear;            
        double periodMonths = periodYears * monthsInAYear;

        double balance = loanAmount 
            * (Math.pow(1 + monthlyIntrestRate, periodMonths) - Math.pow((1 + monthlyIntrestRate), numberOfPaymentsMade))
            / (Math.pow(1 + monthlyIntrestRate, periodMonths) - 1);
        
        return balance;
    }
    /* #endregion */
}