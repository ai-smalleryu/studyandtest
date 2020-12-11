package workTestMianshi.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilterHandler {
    public static void main(String[] args) throws IOException {
        FileHandler filt=new FileHandler();
        filt.setLevel(Level.FINE);
        Logger global = Logger.getGlobal();
        global.setLevel(Level.FINE);
        global.addHandler(filt);
        global.info("dda");
        global.info("zxz");
        global.fine("aaaaaaaaaaaaaaaaaaaaaaa");
    }
}
