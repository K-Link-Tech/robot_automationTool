package base;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Logs an informational message with a timestamp.
     *
     * @param message The message to log.
     */
    public static void log(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println("[INFO] [" + timestamp + "] " + message);
    }

    /**
     * Logs an error message with a timestamp and optional exception details.
     *
     * @param message The error message to log.
     */
    public static void logError(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.err.println("[ERROR] [" + timestamp + "] " + message);

    }
}

