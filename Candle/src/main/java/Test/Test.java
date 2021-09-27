package Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;
import java.util.spi.CalendarNameProvider;

public class Test {
    LocalDateTime now;
    LocalDateTime startDate;
    LocalDateTime endDate;

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public LocalDateTime getNow() {
        return now;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public Test(LocalDateTime now, LocalDateTime startDate, LocalDateTime endDate){
        this.now = now;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static void main (String[] args){
        LocalDateTime now =  LocalDateTime.now();
        LocalDateTime startDate = LocalDateTime.of(2020, 2,12, 2, 30);
        LocalDateTime endDate = LocalDateTime.of(2020,2, 12,2,30);

        Test test = new Test(now, startDate, endDate);
        int startMonth = test.getStartDate().getMonthValue();
        System.out.println(startMonth);

        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getActualMaximum(Calendar.DATE));
    }
}
