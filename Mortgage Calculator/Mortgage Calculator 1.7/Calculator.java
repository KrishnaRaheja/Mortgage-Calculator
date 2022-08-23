public class Calculator {
    static byte percent = 100;
    
    public static double calculateMortgage(float periodYears, float annualInterestRatePercent, double loanAmount) {
        float monthlyIntrestRate = getMonthlyIntrest(annualInterestRatePercent);
        double periodMonths = getPeriodMonths(periodYears);
        
        double methodMortgage = loanAmount 
            * (monthlyIntrestRate * Math.pow(1 + monthlyIntrestRate, periodMonths)) 
            / (Math.pow(1 + monthlyIntrestRate, periodMonths) - 1);
        
        return methodMortgage;
    }
    public static double calculateBalance(double loanAmount, float annualInterestRatePercent, float periodYears, int numberOfPaymentsMade) {
        float monthlyIntrestRate = getMonthlyIntrest(annualInterestRatePercent);        
        double periodMonths = getPeriodMonths(periodYears);
    
        double balance = loanAmount 
            * (Math.pow(1 + monthlyIntrestRate, periodMonths) - Math.pow((1 + monthlyIntrestRate), numberOfPaymentsMade))
            / (Math.pow(1 + monthlyIntrestRate, periodMonths) - 1);
        
        return balance;
    }

    private static float getMonthlyIntrest(float annualInterestRatePercent) {
        return (annualInterestRatePercent/percent)/Main.monthsInAYear;
    }
    
    private static float getPeriodMonths(float periodYears) {
        return periodYears * Main.monthsInAYear;
    }
}
