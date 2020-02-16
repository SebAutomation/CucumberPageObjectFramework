package utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeTool {

    public static String getCurrentLocalDateTime() {
        //Get current local date and time
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmmss");
        String parseLocalDateTime = localDateTime.format(formatter);
        return parseLocalDateTime;
    }
}
