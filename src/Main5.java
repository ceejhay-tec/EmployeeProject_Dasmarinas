
import version5.BasePlusCommissionEmployee;
import version5.CommissionEmployee;
import version5.Employee;
import version5.EmployeeRoster;
import version5.HourlyEmployee;
import version5.MyDate;
import version5.Name;
import version5.PieceWorkerEmployee;

public class Main5 {
    public static void main(String[] args) {
        int targetMonth = 9;
        EmployeeRoster roster = new EmployeeRoster();

        Name n1 = new Name("Garcia", "Miguel");
        MyDate d1 = new MyDate(14, 9, 2005);
        MyDate c1 = new MyDate(8, 6, 2022);
        HourlyEmployee he1 = new HourlyEmployee(101, n1, d1, c1, 40, 8);

        Name n2 = new Name("Reyes", "Angela");
        MyDate d2 = new MyDate(22, 4, 2004);
        MyDate c2 = new MyDate(15, 8, 2021);
        PieceWorkerEmployee pwe1 =
                new PieceWorkerEmployee(102, n2, d2, c2, 250, 6);

        Name n3 = new Name("Santos", "Daniel");
        MyDate d3 = new MyDate(7, 9, 2003);
        MyDate c3 = new MyDate(20, 5, 2020);
        CommissionEmployee ce1 =
                new CommissionEmployee(103, n3, d3, c3, 120000);

        Name n4 = new Name("Mendoza", "Sofia", "Cruz", "Jr.");
        MyDate d4 = new MyDate(18, 3, 2002);
        MyDate c4 = new MyDate(12, 4, 2019);
        BasePlusCommissionEmployee bpce1 =
                new BasePlusCommissionEmployee(
                        104, n4, d4, c4, 150000, 25000);

        System.out.println("======================================================================");
        System.out.println("DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)");
        System.out.println("======================================================================");
        System.out.println("Enrolled he1: " + roster.addEmployee(he1));
        System.out.println("Enrolled pwe1: " + roster.addEmployee(pwe1));
        System.out.println("Enrolled ce1: " + roster.addEmployee(ce1));
        System.out.println("Enrolled bpce1: " + roster.addEmployee(bpce1));
        System.out.println("Total Roster Size: "
                + roster.countEmployees() + " employees");

        System.out.println("\n======================================================================");
        System.out.println("ROSTER COMPOSITION COUNTS");
        System.out.println("======================================================================");
        System.out.println("Hourly Employees: " + roster.countHE());
        System.out.println("Piece Worker Employees: " + roster.countPWE());
        System.out.println("Commission Employees: " + roster.countCE());
        System.out.println("Base Plus Commission Employees: "
                + roster.countBPCE());

        System.out.println("\n======================================================================");
        System.out.println("PURE POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("[No downcasting; dynamic dispatch via Employee.computeSalary()]");
        System.out.println("======================================================================");
        roster.displayPayroll(targetMonth);

        System.out.println("\n======================================================================");
        System.out.println("ALL EMPLOYEES BEFORE REMOVAL");
        System.out.println("======================================================================");
        roster.displayAllEmployees();

        System.out.println("\n======================================================================");
        System.out.println("COLLECTION REMOVAL TEST");
        System.out.println("======================================================================");

        Employee found = roster.searchEmployee(102);
        System.out.println("Search for employee ID 102: " + found);

        Employee removed = roster.removeEmployee(102);
        System.out.println("Removed employee ID 102: " + removed);

        System.out.println("Updated Roster Size: "
                + roster.countEmployees());

        System.out.println("\nCurrent Active Employees:");
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

        System.out.println(
                "he1 equals identical: " + he1.equals(identical)
        );

        System.out.printf(
                "he1 hashCode: %d | identical hashCode: %d (Match: %s)%n",
                he1.hashCode(),
                identical.hashCode(),
                he1.hashCode() == identical.hashCode()
        );
    }
}
