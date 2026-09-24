
import version4.BasePlusCommissionEmployee;
import version4.CommissionEmployee;
import version4.Employee;
import version4.EmployeeRoster;
import version4.HourlyEmployee;
import version4.MyDate;
import version4.Name;
import version4.PieceWorkerEmployee;

public class Main4 {
    public static void main(String[] args) {
        int targetMonth = 9;
        EmployeeRoster roster = new EmployeeRoster(6);

        Name n1 = new Name("Garcia", "Miguel");
        MyDate d1 = new MyDate(14, 9, 2005);
        MyDate c1 = new MyDate(8, 6, 2022);
        HourlyEmployee he1 = new HourlyEmployee(101, n1, d1, c1, 40, 8);

        Name n2 = new Name("Reyes", "Angela");
        MyDate d2 = new MyDate(22, 4, 2004);
        MyDate c2 = new MyDate(15, 8, 2021);
        PieceWorkerEmployee pwe1 = new PieceWorkerEmployee(
                102, n2, d2, c2, 250, 6);

        Name n3 = new Name("Santos", "Daniel");
        MyDate d3 = new MyDate(7, 9, 2003);
        MyDate c3 = new MyDate(20, 5, 2020);
        CommissionEmployee ce1 = new CommissionEmployee(
                103, n3, d3, c3, 120000);

        Name n4 = new Name("Mendoza", "Sofia", "Cruz", "Jr.");
        MyDate d4 = new MyDate(18, 3, 2002);
        MyDate c4 = new MyDate(12, 4, 2019);
        BasePlusCommissionEmployee bpce1 =
                new BasePlusCommissionEmployee(
                        104, n4, d4, c4, 150000, 25000);

        Name n5 = new Name("Garcia", "Miguel");
        MyDate d5 = new MyDate(14, 9, 2005);
        MyDate c5 = new MyDate(8, 6, 2022);
        HourlyEmployee he2 = new HourlyEmployee(
                105, n5, d5, c5, 40, 8);

        Name n6 = new Name("Reyes", "Angela");
        MyDate d6 = new MyDate(22, 4, 2004);
        MyDate c6 = new MyDate(15, 8, 2021);
        PieceWorkerEmployee pwe2 = new PieceWorkerEmployee(
                106, n6, d6, c6, 250, 6);

        Employee extraEmployee = new HourlyEmployee(
                107,
                new Name("Santos", "Daniel"),
                new MyDate(7, 9, 2003),
                new MyDate(20, 5, 2020),
                40,
                8
        );

        System.out.println("======================================================================");
        System.out.println("EMPLOYEE ROSTER INITIALIZATION");
        System.out.println("======================================================================");
        System.out.println("Added he1: " + roster.addEmployee(he1));
        System.out.println("Added pwe1: " + roster.addEmployee(pwe1));
        System.out.println("Added ce1: " + roster.addEmployee(ce1));
        System.out.println("Added bpce1: " + roster.addEmployee(bpce1));
        System.out.println("Added he2: " + roster.addEmployee(he2));
        System.out.println("Added pwe2: " + roster.addEmployee(pwe2));
        System.out.println("Added employee beyond capacity: "
                + roster.addEmployee(extraEmployee));

        System.out.println("\n======================================================================");
        System.out.println("ROSTER COMPOSITION COUNTS");
        System.out.println("======================================================================");
        System.out.println("Total Employees: " + roster.getCount()
                + " / " + roster.getMax());
        System.out.println("Hourly Employees: " + roster.countHE());
        System.out.println("Piece Worker Employees: " + roster.countPWE());
        System.out.println("Commission Employees: " + roster.countCE());
        System.out.println("Base Plus Commission Employees: " + roster.countBPCE());

        System.out.println("\n======================================================================");
        System.out.println("CATEGORY DISPLAY TESTS");
        System.out.println("======================================================================");

        System.out.println("\nHourly Employees:");
        roster.displayHE();

        System.out.println("\nPiece Worker Employees:");
        roster.displayPWE();

        System.out.println("\nCommission Employees:");
        roster.displayCE();

        System.out.println("\nBase Plus Commission Employees:");
        roster.displayBPCE();

        System.out.println("\n======================================================================");
        System.out.println("ROSTER PAYROLL REPORT");
        System.out.println("======================================================================");
        roster.displayPayroll(targetMonth);

        System.out.println("\n======================================================================");
        System.out.println("ALL EMPLOYEES BEFORE REMOVAL");
        System.out.println("======================================================================");
        roster.displayAllEmployees();

        System.out.println("\n======================================================================");
        System.out.println("EMPLOYEE SEARCH AND REMOVAL");
        System.out.println("======================================================================");

        Employee found = roster.searchEmployee(102);
        System.out.println("Search for employee ID 102: " + found);

        System.out.println("Removed employee ID 102: "
                + roster.removeEmployee(102));

        System.out.println("Current Employee Count: " + roster.getCount());

        System.out.println("\nRemaining Employees:");
        roster.displayAllEmployees();

        System.out.println("\n======================================================================");
        System.out.println("OBJECT CONTRACT TESTS (equals & hashCode)");
        System.out.println("======================================================================");

        Employee identical = new HourlyEmployee(
                101,
                new Name("Garcia", "Miguel"),
                new MyDate(14, 9, 2005),
                new MyDate(8, 6, 2022),
                40,
                8
        );

        System.out.println("he1 equals identical: "
                + he1.equals(identical));

        System.out.printf(
                "he1 hashCode: %d | identical hashCode: %d (Match: %s)%n",
                he1.hashCode(),
                identical.hashCode(),
                he1.hashCode() == identical.hashCode()
        );
    }
}
