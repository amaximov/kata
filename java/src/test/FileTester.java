import java.io.File;
import java.util.Random;
import static org.testng.Assert.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FileTester {
    Random r = new Random();

    @DataProvider(name = "files")
    public Object[][] getFiles() {
        return new Object[][] { { "java/src/java/FileBasics.java" } };
    }

    @Test(dataProvider = "files", invocationCount = 10)
    public void readRandomLine(String fileName) {
        FileBasics f = new FileBasics();
        System.out.println(f.getRandomLine(new File(fileName)));
    }

    @Test(invocationCount = 10)
    public void testRandomGenerator() {
        assertEquals(r.nextInt(1), 0);
    }
}
