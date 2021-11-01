package view;

/**
 * This class is used to call on the main method from TradingBot
 * since JavaFX has issues in building executable jars with classes
 * that extend the Application class.
 *
 * @author Catalin Cosma
 */
public class Main {
    public static void main(String[] args) {
        TradingBot.main(args);
    }

}
