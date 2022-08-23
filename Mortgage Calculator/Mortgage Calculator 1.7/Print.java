public class Print {
    public static void printMortgage(byte currency, double Mortgage) {
        String answerOutput = Reader.formatCurrency(currency, Mortgage);
        System.out.println();
        System.out.println("Mortgage:");
        System.out.println("---------");
        System.out.println("Monthly payment: " + answerOutput);
        System.out.println();
        System.out.println("Payment Schedule (Months):");
        System.out.println("--------------------------");
    }
    public static void printPaymentSchedule(float periodYears, byte monthsInAYear, double loanAmount, 
        float annualInterestRate, byte currency) {
        for (int month = 1; month <= periodYears * monthsInAYear; month++) {
            double balanceCycle = Calculator.calculateBalance(loanAmount, annualInterestRate, periodYears, month);
            System.out.println(month + ": " + Reader.formatCurrency(currency, balanceCycle));
        }
    }
}
