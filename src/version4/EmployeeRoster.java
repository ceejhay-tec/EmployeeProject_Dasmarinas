package version4;

import java.util.Locale;

public class EmployeeRoster {
    private final Employee[] empList;
    private final int max;
    private int count;

    public EmployeeRoster() {
        this(10);
    }

    public EmployeeRoster(int max) {
        if (max < 0) {
            throw new IllegalArgumentException("Roster capacity cannot be negative");
        }
        this.max = max;
        this.empList = new Employee[max];
        this.count = 0;
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null || count >= max) {
            return false;
        }
        empList[count++] = emp;
        return true;
    }

    public Employee removeEmployee(int empID) {
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                Employee removed = empList[i];
                for (int j = i; j < count - 1; j++) {
                    empList[j] = empList[j + 1];
                }
                count--;
                empList[count] = null;
                return removed;
            }
        }
        return null;
    }

    public Employee searchEmployee(int empID) {
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                return empList[i];
            }
        }
        return null;
    }

    public int countHE() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                total++;
            }
        }
        return total;
    }

    public int countPWE() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                total++;
            }
        }
        return total;
    }

    public int countCE() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i].getClass() == CommissionEmployee.class) {
                total++;
            }
        }
        return total;
    }

    public int countBPCE() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) {
                total++;
            }
        }
        return total;
    }

    public void displayHE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                HourlyEmployee employee = (HourlyEmployee) empList[i];
                employee.displayHourlyEmployee();
            }
        }
    }

    public void displayPWE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee employee = (PieceWorkerEmployee) empList[i];
                employee.displayPieceWorkerEmployee();
            }
        }
    }

    public void displayCE() {
        for (int i = 0; i < count; i++) {
            if (empList[i].getClass() == CommissionEmployee.class) {
                ((CommissionEmployee) empList[i]).displayCommissionEmployee();
            }
        }
    }

    public void displayBPCE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee employee =
                        (BasePlusCommissionEmployee) empList[i];
                employee.displayBasePlusCommissionEmployee();
            }
        }
    }

    public void displayAllEmployees() {
        for (int i = 0; i < count; i++) {
            Employee employee = empList[i];
            System.out.printf(Locale.US, "%d. ID: %d | Name: %s | Type: %s%n",
                    i + 1, employee.getEmpID(), employee.getEmpName(),
                    employee.getClass().getSimpleName());
        }
    }

    public void displayPayroll(int currentMonth) {
        for (int i = 0; i < count; i++) {
            Employee employee = empList[i];
            double salary;
            String type;

            if (employee instanceof BasePlusCommissionEmployee) {
                type = "BasePlusCommission";
                salary = ((BasePlusCommissionEmployee) employee).computeSalary(currentMonth);
            } else if (employee instanceof CommissionEmployee) {
                type = "Commission";
                salary = ((CommissionEmployee) employee).computeSalary(currentMonth);
            } else if (employee instanceof PieceWorkerEmployee) {
                type = "PieceWorker";
                salary = ((PieceWorkerEmployee) employee).computeSalary(currentMonth);
            } else if (employee instanceof HourlyEmployee) {
                type = "Hourly";
                salary = ((HourlyEmployee) employee).computeSalary(currentMonth);
            } else {
                continue;
            }

            String bonus = employee.getBirthDate().getMonth() == currentMonth
                    ? " (Birthday Bonus Applied)" : "";
            System.out.printf(Locale.US, "[%s] ID: %d | Name: %s | Salary: ₱%,.2f%s%n",
                    type, employee.getEmpID(), employee.getEmpName(), salary, bonus);
        }
    }

    public int getCount() {
        return count;
    }

    public int getMax() {
        return max;
    }

}
