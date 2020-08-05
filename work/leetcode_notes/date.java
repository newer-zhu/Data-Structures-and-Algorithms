package leetcode_notes;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class date {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        int month = now.getMonthValue();
        int today = now.getDayOfMonth();

        now = now.minusDays(today - 1);
        DayOfWeek weekday = now.getDayOfWeek();
        int value = weekday.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++)
            System.out.print("   ");
        while (now.getMonthValue() == month){
            System.out.printf("%3d",now.getDayOfMonth());
            if (now.getDayOfMonth() == today)
                System.out.print("*");
            else
                System.out.print(" ");
            now = now.plusDays(1);
            if (now.getDayOfWeek().getValue() == 1)
                System.out.println();
        }
        if (now.getDayOfWeek().getValue() != 1)
            System.out.println();
    }
}
