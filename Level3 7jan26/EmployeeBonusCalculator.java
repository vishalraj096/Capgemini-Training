public class EmployeeBonusCalculator {
    public static int[][] generateSalaryAndService(int employeeCount) {
        int minSalary = 10000;
        int maxSalary = 99999;
        int maxYears = 10;

        int[][] data = new int[employeeCount][2];
        for (int i = 0; i < employeeCount; i++) {
            int salary = (int) (Math.random() * (maxSalary - minSalary + 1)) + minSalary;
            int years = (int) (Math.random() * (maxYears + 1));
            data[i][0] = salary;
            data[i][1] = years;
        }
        return data;
    }

    public static double[][] computeNewSalaryAndBonus(int[][] salaryAndService) {
        double[][] latest = new double[salaryAndService.length][2];
        for (int i = 0; i < salaryAndService.length; i++) {
            int oldSalary = salaryAndService[i][0];
            int years = salaryAndService[i][1];
            double rate = (years > 5) ? 0.05 : 0.02;
            double bonus = oldSalary * rate;
            double newSalary = oldSalary + bonus;
            latest[i][0] = newSalary;
            latest[i][1] = bonus;
        }
        return latest;
    }

    public static double[] computeTotals(int[][] oldData, double[][] newData) {
        double sumOld = 0, sumNew = 0, totalBonus = 0;
        for (int i = 0; i < oldData.length; i++) {
            sumOld += oldData[i][0];
            sumNew += newData[i][0];
            totalBonus += newData[i][1];
        }
        return new double[] { sumOld, sumNew, totalBonus };
    }

    public static void printReport(int[][] oldData, double[][] newData) {
        System.out.println("Employee Bonus Report (Zara, 10 years)\n");
        System.out.println("Emp\tYears\tOld Salary\tBonus\t\tNew Salary");
        for (int i = 0; i < oldData.length; i++) {
            int years = oldData[i][1];
            int oldSalary = oldData[i][0];
            double bonus = newData[i][1];
            double newSalary = newData[i][0];
            System.out.printf("%d\t%d\t%d\t\t%.2f\t\t%.2f%n", (i + 1), years, oldSalary, bonus, newSalary);
        }
        double[] totals = computeTotals(oldData, newData);
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("TOTALS\t-\t%.0f\t\t%.2f\t\t%.2f%n", totals[0], totals[2], totals[1]);
    }

    public static void main(String[] args) {
        int employeeCount = 10;
        int[][] salaryAndService = generateSalaryAndService(employeeCount);
        double[][] latest = computeNewSalaryAndBonus(salaryAndService);
        printReport(salaryAndService, latest);
    }
}
