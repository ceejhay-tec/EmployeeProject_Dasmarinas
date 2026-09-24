package version5;

import java.util.ArrayList;
import java.util.Locale;

public class EmployeeRoster {
    private final ArrayList<Employee> empList;

    public EmployeeRoster() {
        this.empList = new ArrayList<>();
    }

    public EmployeeRoster(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity cannot be negative");
        }
        this.empList = new ArrayList<>(initialCapacity);
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null) {
            return false;
        }
        empList.add(emp);
        return true;
    }

    public Employee removeEmployee(int empID) {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getEmpID() == empID) {
                return empList.remove(i);
            }
        }
        return null;
    }

    public Employee searchEmployee(int empID) {
        for (Employee employee : empList) {
            if (employee.getEmpID() == empID) {
                return employee;
            }
        }
        return null;
    }

    public int countEmployees() {
        return empList.size();
    }

    public int countHE() {
        int total = 0;
        for (Employee employee : empList) {
            if (employee instanceof HourlyEmployee) {
                total++;
            }
        }
        return total;
    }

    public int countPWE() {
        int total = 0;
        for (Employee employee : empList) {
            if (employee instanceof PieceWorkerEmployee) {
                total++;
            }
        }
        return total;
    }

    public int countCE() {
        int total = 0;
        for (Employee employee : empList) {
            if (employee.getClass() == CommissionEmployee.class) {
                total++;
            }
        }
        return total;
    }

    public int countBPCE() {
        int total = 0;
        for (Employee employee : empList) {
            if (employee instanceof BasePlusCommissionEmployee) {
                total++;
            }
        }
        return total;
    }

    public void displayPayroll(int currentMonth) {
        for (Employee employee : empList) {
            double salary = employee.computeSalary(currentMonth);
            String bonus = employee.getBirthDate().getMonth() == currentMonth
                    ? " (Birthday Bonus Applied)" : "";
            System.out.printf(Locale.US, "ID: %d | Name: %-28s | Payout: ₱%,.2f%s%n",
                    employee.getEmpID(), employee.getEmpName(), salary, bonus);
        }
    }

    public void displayAllEmployees() {
        for (Employee employee : empList) {
            System.out.println(employee);
        }
    }

}
