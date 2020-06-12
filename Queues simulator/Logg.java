package SistemGestiuneClienti;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Logg {
private static final Logger LOGGER=Logger.getLogger(Logg.class.getName());
static FileHandler fh;
	
 static void setupLogger(){
    LOGGER.setLevel(Level.ALL);
    try {
            FileHandler fhandler = new FileHandler("file.txt");
            SimpleFormatter sformatter = new SimpleFormatter();
            fhandler.setFormatter(sformatter);
            LOGGER.addHandler(fhandler);

    } catch (IOException ex) {
        LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
    } catch (SecurityException ex) {
        LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
    }
}


}
