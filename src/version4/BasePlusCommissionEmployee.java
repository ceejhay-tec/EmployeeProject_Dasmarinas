package version4;

import java.util.Locale;
import java.util.Objects;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super();
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                                      double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) {
            throw new IllegalArgumentException("Base salary cannot be negative");
        }
        this.baseSalary = baseSalary;
    }

    @Override
    public double computeSalary(int currentMonth) {
        return baseSalary + super.computeSalary(currentMonth);
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format(
                Locale.US,
                "BasePlusCommissionEmployee{\n" +
                        "Employee ID: %d" +
                        ", \nEmployee Name: %s" +
                        ", \nBirth Date: %s" +
                        ", \nDate Hired: %s" +
                        ", \nTotal Sale: ₱%.2f" +
                        ", \nBase Salary: ₱%.2f" +
                        ", \nCommission: ₱%.2f" +
                        ", \nSalary: ₱%.2f" +
                        "\n}",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(),
                getTotalSale(), baseSalary, getTotalSale() * getCommissionRate(),
                computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BasePlusCommissionEmployee)) {
            return false;
        }
        BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) obj;
        return super.equals(other) && Double.compare(baseSalary, other.baseSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), baseSalary);
    }

    @Override
    public BasePlusCommissionEmployee clone() throws CloneNotSupportedException {
        return (BasePlusCommissionEmployee) super.clone();
    }
}
