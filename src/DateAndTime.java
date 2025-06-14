import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class DateAndTime
{
    public static void main(String[] args)
    {
        LocalDate mydate = LocalDate.now();
        System.out.println(mydate);

        LocalTime mytime = LocalTime.now();
        System.out.println(mytime);

        LocalDateTime LDT = LocalDateTime.now();
        System.out.println(LDT);

    }


}
