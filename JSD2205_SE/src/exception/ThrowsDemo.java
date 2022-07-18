package exception;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class ThrowsDemo {
    public void dosome() throws IOException, AWTException {
    }
}

class SubClass extends ThrowsDemo {
    /*
    public void dosome() throws IOException, AWTException {
    }

    public void dosome() throws IOException {
    }

    public void dosome() throws FileNotFoundException {
    }

    public void dosome() throws SQLException {
    }

    public void dosome() throws Exception {
    }

     */

}
