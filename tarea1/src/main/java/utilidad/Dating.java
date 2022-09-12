package utilidad;

import java.time.Duration;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class Dating {

    private final static long hour = Duration.ofHours(1).getSeconds();

    private final static long minute = Duration.ofMinutes(1).getSeconds();

    public static LocalDate toLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static String formatDuration(Duration duration) {
        long seconds = duration.getSeconds();
        long hours = seconds / hour;
        seconds -= hours * hour;
        long minutes = seconds / minute;

        String hoursStr = hours < 10 ? "0" + Long.toString(hours) : Long.toString(hours);
        String minutesStr = minutes < 10 ? "0" + Long.toString(minutes) : Long.toString(minutes);

        return hoursStr + ":" + minutesStr;
    }
}
