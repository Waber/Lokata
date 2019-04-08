import org.apache.commons.math3.util.Precision;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Random;

public class UnitTest {

    String fileDirectory = "C:\\Users\\Standard\\IdeaProjects\\Lokata\\Stopy.csv";
    File file = new File(fileDirectory);

    @Test
    public void checkForFile() {
        Assert.assertTrue(file.exists());
    }

    @Test
    public void checkProperCalculation() throws IOException {

        Saldo saldo;

        BufferedReader reader = new BufferedReader(new FileReader(fileDirectory));
        String line;
        Random random = new Random();
        Float randomValueBetween, min, max;
        Float newRate, minRate, maxRate;
        while ((line = reader.readLine()) != null){
            String[] data = line.split(",");
            min = Float.parseFloat(data[0]);
            max = Float.parseFloat(data[1]);
            randomValueBetween = random.nextFloat() * ((max - min) + 1) + min;
            saldo = new Saldo(fileDirectory, randomValueBetween);

            newRate = Precision.round(randomValueBetween * ((100 + Float.parseFloat(data[2]))/100),2);

            Assert.assertEquals(saldo.calculatedRate(randomValueBetween), newRate);
            System.out.println(randomValueBetween);

            minRate = Precision.round(min * ((100 + Float.parseFloat(data[2]))/100),2);
            maxRate = Precision.round(max * ((100 + Float.parseFloat(data[2]))/100),2);
//Asercje dla przypadków brzegowych
            Assert.assertEquals(saldo.calculatedRate(min), minRate);
            Assert.assertEquals(saldo.calculatedRate(max), maxRate);

        }
    }
}


