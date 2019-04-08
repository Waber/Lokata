import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\180305\\IdeaProjects\\Lokata\\Stopy.csv";
        Float money;
        Saldo saldo;
        Scanner in = new Scanner(System.in);

        System.out.println("Wprowadź kwotę dla której chcesz obliczyc saldo w formacie ##,##");
        money = in.nextFloat();
        saldo = new Saldo(filePath, money);

        if(saldo.properAmount){
            System.out.println("Nowe saldo po roku: " + saldo.calculatedRate(money));
        }

    }
}
