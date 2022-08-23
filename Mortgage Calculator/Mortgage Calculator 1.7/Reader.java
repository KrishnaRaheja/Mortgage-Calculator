import java.text.NumberFormat; import java.util.Locale; import java.util.Scanner;

public class Reader {
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
        } 
        return formattedMortgage;
    }
}
