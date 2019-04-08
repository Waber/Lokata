import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class UnitTest {

    String fileDirectory = "C:\\Users\\180305\\IdeaProjects\\Lokata\\Stopy.csv";
    File file = new File(fileDirectory);

    @Test
    public void checkForFile() {
        Assert.assertTrue(file.exists());
    }
}


