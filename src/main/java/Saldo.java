import org.apache.commons.math3.util.Precision;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Saldo {

    String line;
    float min, max, rate;


    boolean properAmount = false;

    public Saldo(String csvPath, float amount){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvPath));

            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                if(amount > Float.parseFloat(data[0]) && amount < Float.parseFloat(data[1])){
                    rate = Float.parseFloat(data[2]);
                    properAmount = true;
                }
            }

        } catch (java.io.IOException e) {
            System.out.println("Brak pliku zawierającego stopy oprocentowania lub plik uszkodzony");
        }
    }


    protected boolean isProperAmount() {
        return properAmount;
    }

    protected float calculatedRate(float amount){
        return Precision.round(amount * ((100 + rate)/100),2);
    }




}
