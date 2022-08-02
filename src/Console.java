import java.io.IOException;

public class Console {

    // Console font colors by https://stackoverflow.com/a/45444716
    public static final String RED = "\033[0;31m";
    public static final String YELLOW = "\033[0;33m";
    public static final String PURPLE = "\033[0;35m";
    public static final String RESET = "\033[0m";
    public static final String CYAN = "\033[0;36m";

    public static void nextEntry() {
        try {
            System.in.read();
            clear();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void clear() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
