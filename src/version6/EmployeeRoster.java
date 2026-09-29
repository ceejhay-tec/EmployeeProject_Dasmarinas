package version6;

import java.util.ArrayList;
import java.util.Locale;

public class EmployeeRoster {
    private final ArrayList<Employee> employees = new ArrayList<>();

    public final boolean addEmployee(Employee emp) {
        if (emp == null) {
            throw new NullPointerException("Employee cannot be null");
        }
        return employees.add(emp);
    }

    public final Employee removeEmployee(int empID) {
        for (int index = 0; index < employees.size(); index++) {
            if (employees.get(index).getEmpID() == empID) {
                return employees.remove(index);
            }
        }
        return null;
    }

    public final int countEmployees() { return employees.size(); }

    public final int countHE() {
        int count = 0;
        for (Employee employee : employees) {
            if (employee instanceof HourlyEmployee) count++;
        }
        return count;
    }

    public final int countPWE() {
        int count = 0;
        for (Employee employee : employees) {
            if (employee instanceof PieceWorkerEmployee) count++;
        }
        return count;
    }

    public final int countCE() {
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getClass() == CommissionEmployee.class) count++;
        }
        return count;
    }

    public final int countBPCE() {
        int count = 0;
        for (Employee employee : employees) {
            if (employee instanceof BasePlusCommissionEmployee) count++;
        }
        return count;
    }

    public final void displayPayroll(int currentMonth) {
        for (Employee employee : employees) {
            double salary = employee.computeSalary(currentMonth);
            String bonus = employee.getBirthDate().getMonth() == currentMonth
                    ? " (Bonus Applied)" : "";
            System.out.printf(Locale.US, "ID: %d | Name: %-28s | Payout: ₱%,.2f%s%n",
                    employee.getEmpID(), employee.getEmpName(), salary, bonus);
        }
    }
}
