package ro.ulbs.proiectaresoftware.students;

public class Logger {
    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    public void info(String mesaj) {
        System.out.println("[INFO]: " + mesaj);
    }

    public void error(String mesaj) {
        System.err.println("[EROARE]: " + mesaj);
    }
}