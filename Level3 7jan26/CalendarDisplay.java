import java.util.Scanner;

public class CalendarDisplay {
    public static String getMonthName(int month) {
        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        return months[month - 1];
    }

    public static boolean isLeapYear(int year) {
        if (year < 1582)
            return false;
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getDaysInMonth(int month, int year) {
        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (month == 2 && isLeapYear(year))
            return 29;
        return days[month - 1];
    }

    public static int getFirstDayOfMonth(int day, int month, int year) {
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (day + x + (31 * m0) / 12) % 7;
        return d0;
    }

    public static void printCalendar(int month, int year) {
        String monthName = getMonthName(month);
        int daysInMonth = getDaysInMonth(month, year);
        int startDay = getFirstDayOfMonth(1, month, year);

        System.out.println(monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < startDay; i++)
            System.out.print("    ");
        int dayOfWeek = startDay;
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);
            dayOfWeek = (dayOfWeek + 1) % 7;
            if (dayOfWeek == 0)
                System.out.println();
        }
        if (dayOfWeek != 0)
            System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int month = input.nextInt();
        int year = input.nextInt();
        printCalendar(month, year);
        input.close();
    }
}
