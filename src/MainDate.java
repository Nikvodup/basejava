import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class MainDate {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Date date = new Date();
        System.out.println(date);
        System.out.println(System.currentTimeMillis() - start);
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        System.out.println(cal.getTime());

        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        LocalDateTime ldt = LocalDateTime.of(ld, lt);
        System.out.println(ldt);


        LocalTime now1 = LocalTime.now();
        LocalTime now2 = LocalTime.now();

        System.out.println(now1.isBefore(now2));

        System.out.println("================");
        long HoursBetween = ChronoUnit.HOURS.between(now1,now2);
        long MinutesBetween = ChronoUnit.MINUTES.between(now1,now2);
        System.out.println(HoursBetween);
        System.out.println(MinutesBetween);
        System.out.println("================");

        SimpleDateFormat sdf = new SimpleDateFormat("YY/MM/dd");
        System.out.println(sdf.format(date));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YY/MM/dd");
        System.out.println(dtf.format(ldt));
    }
}
