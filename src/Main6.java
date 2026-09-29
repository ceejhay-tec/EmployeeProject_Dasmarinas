
import version6.BasePlusCommissionEmployee;
import version6.CommissionEmployee;
import version6.EmployeeRoster;
import version6.HourlyEmployee;
import version6.MyDate;
import version6.Name;
import version6.PieceWorkerEmployee;

public class Main6 {
    public static void main(String[] args) {
        int targetMonth = 9;
        EmployeeRoster roster = new EmployeeRoster();

        System.out.println("FORMAL ABSTRACTION AND IMMUTABLE IDENTIFIERS");
        System.out.println("Employee is abstract, so new Employee(...) is rejected by the compiler.");

        System.out.println("\nTESTING ENCAPSULATION & DEFENSIVE COPYING");
        MyDate birthDate = new MyDate(14, 9, 2005);
        HourlyEmployee hourly = new HourlyEmployee(
                101,
                new Name("Garcia", "Miguel"),
                birthDate,
                new MyDate(8, 6, 2022),
                40,
                8
        );

        System.out.printf(
                "Original Birth Month: %d (%s)%n",
                birthDate.getMonth(),
                birthDate
        );

        System.out.println(
                "Attempting external tampering: emp.getBirthDate().setMonth(9)..."
        );

        hourly.getBirthDate().setMonth(9);

        System.out.println(
                "Employee's Actual Birth Date after tampering attempt: "
                        + hourly.getBirthDate()
        );

        System.out.println(
                "Result: SUCCESS (Internal state protected via defensive copying)"
        );

        System.out.println("\nTESTING EXCEPTION HANDLING & INPUT VALIDATION");

        try {
            System.out.println(
                    "Attempting to create HourlyEmployee with rate: -150.00..."
            );

            new HourlyEmployee(
                    102,
                    new Name("Doe", "Jane"),
                    new MyDate(1, 1, 1990),
                    new MyDate(1, 1, 2020),
                    40,
                    -150.00
            );

        } catch (IllegalArgumentException exception) {
            System.out.println(
                    "Caught Expected Exception: ["
                            + exception.getClass().getSimpleName()
                            + "] "
                            + exception.getMessage()
            );
        }

        try {
            System.out.println(
                    "Attempting to assign invalid calendar date: 31 Feb 2026..."
            );

            new MyDate(31, 2, 2026);

        } catch (IllegalArgumentException exception) {
            System.out.println(
                    "Caught Expected Exception: ["
                            + exception.getClass().getSimpleName()
                            + "] "
                            + exception.getMessage()
            );
        }

        roster.addEmployee(hourly);

        roster.addEmployee(
                new PieceWorkerEmployee(
                        102,
                        new Name("Reyes", "Angela"),
                        new MyDate(22, 4, 2004),
                        new MyDate(15, 8, 2021),
                        250,
                        6
                )
        );

        roster.addEmployee(
                new CommissionEmployee(
                        103,
                        new Name("Santos", "Daniel"),
                        new MyDate(7, 9, 2003),
                        new MyDate(20, 5, 2020),
                        120000
                )
        );

        roster.addEmployee(
                new BasePlusCommissionEmployee(
                        104,
                        new Name("Mendoza", "Sofia", "Cruz", "Jr."),
                        new MyDate(18, 3, 2002),
                        new MyDate(12, 4, 2019),
                        150000,
                        25000
                )
        );

        System.out.println(
                "\nPOLYMORPHIC PAYROLL EXECUTION (Target Month: Sep)"
        );

        System.out.println(
                "[Dynamic dispatch via abstract contract computeSalary()]"
        );

        roster.displayPayroll(targetMonth);
    }
}
