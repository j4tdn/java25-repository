package datetime;

import java.text.SimpleDateFormat;
import java.util.*;

public class Ex03 {

    private static final SimpleDateFormat DTF = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        Calendar startDate = new GregorianCalendar(2022, Calendar.JUNE, 7);
        int requiredWorkDays = 110;

        Set<String> holidays = new HashSet<String>();
        holidays.add(keyOf(new GregorianCalendar(2022, Calendar.SEPTEMBER, 1)));
        holidays.add(keyOf(new GregorianCalendar(2022, Calendar.SEPTEMBER, 2)));

        boolean includeStartDayAsDay1 = true;

        Calendar deadline = calculateDeadline(startDate, requiredWorkDays, holidays, includeStartDayAsDay1);

        System.out.println("Start date: " + DTF.format(startDate.getTime()) + " (" + dayNameEn(startDate) + ")");
        System.out.println("Workdays required: " + requiredWorkDays);
        System.out.println("Deadline: " + DTF.format(deadline.getTime()) + " (" + dayNameEn(deadline) + ")");
    }

    public static Calendar calculateDeadline(Calendar start, int workDays, Set<String> holidays, boolean includeStartAsDay1) {
        Calendar d = cloneCal(start);
        int count = 0;

        if (!includeStartAsDay1) {
            d.add(Calendar.DAY_OF_MONTH, 1);
        }

        while (true) {
            if (isWorkingDay(d, holidays)) {
                count++;
                if (count == workDays) {
                    return d;
                }
            }
            d.add(Calendar.DAY_OF_MONTH, 1);
        }
    }

    public static boolean isWorkingDay(Calendar date, Set<String> holidays) {
        int dow = date.get(Calendar.DAY_OF_WEEK);
        boolean isWeekend = (dow == Calendar.SATURDAY || dow == Calendar.SUNDAY);
        return !isWeekend && !holidays.contains(keyOf(date));
    }

    private static Calendar cloneCal(Calendar src) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(src.getTimeInMillis());
        return c;
    }

    private static String keyOf(Calendar cal) {
        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH) + 1;
        int d = cal.get(Calendar.DAY_OF_MONTH);
        return String.format("%04d%02d%02d", y, m, d);
    }

    private static String dayNameEn(Calendar cal) {
        String[] en = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
        return en[cal.get(Calendar.DAY_OF_WEEK) - 1];
    }
}
