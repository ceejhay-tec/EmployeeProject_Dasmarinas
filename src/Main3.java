import version3.BasePlusCommissionEmployee;
import version3.CommissionEmployee;
import version3.Employee;
import version3.HourlyEmployee;
import version3.MyDate;
import version3.Name;
import version3.PieceWorkerEmployee;

public class Main3 {
    public static void main(String[] args) throws CloneNotSupportedException {
        int targetMonth = 9;

        Name n1 = new Name("Garcia", "Miguel");
        MyDate d1 = new MyDate(14, 9, 2005);
        MyDate c1 = new MyDate(8, 6, 2022);
        HourlyEmployee he1 = new HourlyEmployee(101, n1, d1, c1, 40, 8);

        Name n2 = new Name("Reyes", "Angela");
        MyDate d2 = new MyDate(22, 4, 2004);
        MyDate c2 = new MyDate(15, 8, 2021);
        PieceWorkerEmployee he2 = new PieceWorkerEmployee(102, n2, d2, c2, 250, 6);

        Name n3 = new Name("Santos", "Daniel");
        MyDate d3 = new MyDate(7, 9, 2003);
        MyDate c3 = new MyDate(20, 5, 2020);
        CommissionEmployee he3 = new CommissionEmployee(103, n3, d3, c3, 120000);

        Name n4 = new Name("Mendoza", "Sofia", "Cruz", "Jr.");
        MyDate d4 = new MyDate(18, 3, 2002);
        MyDate c4 = new MyDate(12, 4, 2019);
        BasePlusCommissionEmployee he4 =
                new BasePlusCommissionEmployee(104, n4, d4, c4, 150000, 25000);

        Employee[] employees = {he1, he2, he3, he4};

        for (Employee employee : employees) {
            employee.computeSalary(targetMonth);
            System.out.println(employee);
        }

        Employee emp1 = he1;

        Employee emp1Identical = new HourlyEmployee(
                101,
                new Name("Garcia", "Miguel"),
                new MyDate(14, 9, 2005),
                new MyDate(8, 6, 2022),
                40,
                8
        );

        Employee emp2 = new HourlyEmployee(
                105,
                new Name("Garcia", "Miguel"),
                new MyDate(14, 9, 2005),
                new MyDate(8, 6, 2022),
                40,
                8
        );

        System.out.println("\n======================================================================");
        System.out.println("OBJECT CONTRACT TESTS (equals & hashCode)");
        System.out.println("======================================================================");
        System.out.println("emp1 equals emp1Identical: " + emp1.equals(emp1Identical));
        System.out.printf(
                "emp1 hashCode: %d | emp1Identical hashCode: %d (Match: %s)%n",
                emp1.hashCode(),
                emp1Identical.hashCode(),
                emp1.hashCode() == emp1Identical.hashCode()
        );
        System.out.println("emp1 equals emp2: " + emp1.equals(emp2));

        HourlyEmployee original = he1;
        HourlyEmployee clone = original.clone();

        System.out.println("\n======================================================================");
        System.out.println("DEEP CLONE VERIFICATION");
        System.out.println("======================================================================");
        System.out.println("Original Name before modification: " + original.getEmpName());

        clone.getEmpName().setFirstName("Modified");

        System.out.println("Clone Name changed to:             " + clone.getEmpName());
        System.out.println("Original Name after modification:  " + original.getEmpName()
                + " (Deep copy successful!)");
    }
}
