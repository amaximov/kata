import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class FileBasics {

    /**
     * we read the whole file, but we only keep one line in memory at a time
     * 
     * @param f
     * @return
     */
    public String getRandomLine(File f) {
        Random r = new Random();
        BufferedReader in = null;
        int counter = 0;
        String currLine = null, result = null;

        try {
            in = new BufferedReader(new FileReader(f));
            while ((currLine = in.readLine()) != null) {
                // first row will be picked with 100% probability, since nextInt(1) is always 0
                if (counter == r.nextInt(counter + 1)) {
                    result = currLine;
                }
                counter++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ignore) {
                }
            }
        }
        return result;
    }
}
