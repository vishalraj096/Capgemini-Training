import java.util.Scanner;

public class MonthlyCalendarPrinter {
    public static String monthName(int m) {
        String[] names = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        if (m < 1 || m > 12)
            throw new IllegalArgumentException("Month must be 1-12");
        return names[m - 1];
    }

    public static boolean isLeapYear(int y) {
        return (y % 400 == 0) || (y % 4 == 0 && y % 100 != 0);
    }

    public static int daysInMonth(int m, int y) {
        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (m == 2 && isLeapYear(y))
            return 29;
        return days[m - 1];
    }

    public static int firstDayOfMonth(int m, int y) {
        int d = 1;
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
        return d0;
    }

    public static void printCalendar(int m, int y) {
        String name = monthName(m);
        int days = daysInMonth(m, y);
        int first = firstDayOfMonth(m, y);
        System.out.println(name + " " + y);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        for (int i = 0; i < first; i++)
            System.out.print("    ");
        for (int day = 1; day <= days; day++) {
            System.out.printf("%3d ", day);
            if ((first + day) % 7 == 0)
                System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int y = sc.nextInt();
        printCalendar(m, y);
        sc.close();
    }
}
