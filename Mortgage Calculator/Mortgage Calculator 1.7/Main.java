//Refer to https://www.wikihow.com/Calculate-Mortgage-Payments for the Mortgage calculator equation

public class Main {
    
    static byte monthsInAYear = 12;
    public static void main(String[]args) {        
        System.out.println("This is a Mortgage Calculator");
        
        double loanAmount = Reader.readNumber("Loan amount (Dollars, Euros, JPY): ", 1000, 1_000_000);

        float annualInterestRatePercent = (float) Reader.readNumber("Annual Interest rate in %: ", 0, 30);

        float periodYears = (float) Reader.readNumber("Period (Years): ", 1, 30);
        
        double Mortgage = Calculator.calculateMortgage(periodYears, annualInterestRatePercent, loanAmount);
        
        byte currency = (byte) Reader.readNumber("Enter 1 for US dollars, 2 for UK pounds, or 3 for Japanese yen (JPY): ", 1, 3);
        
        Print.printMortgage(currency, Mortgage);
        
        Print.printPaymentSchedule(periodYears, monthsInAYear, loanAmount, annualInterestRatePercent, currency);
    }
}