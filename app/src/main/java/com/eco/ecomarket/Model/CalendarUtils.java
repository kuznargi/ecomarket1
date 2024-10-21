package com.eco.ecomarket.Model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CalendarUtils {
    public static LocalDate selectedDate;

    public static String formattedDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        return date.format(formatter);
    }
    public static String formattedTime(LocalTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        return time.format(formatter);
    }
    public static String monthYearFromDate(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return localDate.format(formatter);
    }




    public static ArrayList<LocalDate> daysInMonthArray(LocalDate date) {
        ArrayList<LocalDate> dayInMonthArray = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(date);

        int dayInMonth = yearMonth.lengthOfMonth();
        LocalDate firstOfMonth = CalendarUtils.selectedDate.withDayOfMonth(1);
        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue();

        for (int i = 1; i <= 42; i++) {
            if (i <= dayOfWeek || i > dayInMonth + dayOfWeek) {
                dayInMonthArray.add(null); // Empty day
            } else {
                dayInMonthArray.add(LocalDate.of(selectedDate.getYear(),selectedDate.getMonth(),i - dayOfWeek) ); // Valid day
            }
        }
        return dayInMonthArray;
    }
    public static ArrayList<LocalDate> daysInWeekArray(LocalDate date) {
        ArrayList<LocalDate> days = new ArrayList<>();
        LocalDate current=sundayForDate(selectedDate);
        LocalDate endDate=current.plusWeeks(1);
        while(current.isBefore(endDate)){
            days.add(current);
            current=current.plusDays(1);
        }
        return days;

    }

    private static LocalDate sundayForDate(LocalDate current) {
    LocalDate oneWeekAgo= current.minusWeeks(1);
    while(current.isAfter(oneWeekAgo)){
        if(current.getDayOfWeek()== DayOfWeek.SUNDAY)
            return current;
        current=current.minusDays(1);

    }
    return  null;
    }



}
