package version3;

import java.util.Locale;
import java.util.Objects;

public class CommissionEmployee extends Employee {
    private double totalSale;

    public CommissionEmployee() {
        super();
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                              double totalSale) {
        super(empID, empName, birthDate, dateHired);
        setTotalSale(totalSale);
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        if (totalSale < 0) {
            throw new IllegalArgumentException("Total sale cannot be negative");
        }
        this.totalSale = totalSale;
    }

    public double getCommissionRate() {
        if (totalSale < 50000) {
            return 0.05;
        }
        if (totalSale < 100000) {
            return 0.10;
        }
        if (totalSale < 500000) {
            return 0.15;
        }
        return 0.20;
    }

    @Override
    public double computeSalary(int currentMonth) {
        return totalSale * getCommissionRate() + super.computeSalary(currentMonth);
    }

    public void displayCommissionEmployee() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format(
                Locale.US,
                "CommissionEmployee{\n" +
                        "Employee ID: %d" +
                        ", \nEmployee Name: %s" +
                        ", \nBirth Date: %s" +
                        ", \nDate Hired: %s" +
                        ", \nTotal Sale: ₱%.2f" +
                        ", \nCommission Rate: %.0f%%" +
                        ", \nSalary: ₱%.2f" +
                        "\n}",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(),
                totalSale, getCommissionRate() * 100, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommissionEmployee)) {
            return false;
        }
        CommissionEmployee other = (CommissionEmployee) obj;
        return super.equals(other) && Double.compare(totalSale, other.totalSale) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalSale);
    }

    @Override
    public CommissionEmployee clone() throws CloneNotSupportedException {
        return (CommissionEmployee) super.clone();
    }
}
