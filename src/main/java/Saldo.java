import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Saldo {

    private Scanner scanner;
    int min, max, rate;

    public Saldo(String csvPath, float amount){
        try {
            scanner = new Scanner(new File(csvPath));
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku zawierającego stopy oprocentowania lub plik uszkodzony");
        }


    }


}
