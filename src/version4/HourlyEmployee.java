package version4;

import java.util.Locale;
import java.util.Objects;

public class HourlyEmployee extends Employee {
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        super();
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                          float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked < 0) {
            throw new IllegalArgumentException("Hours worked cannot be negative");
        }
        this.totalHoursWorked = totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour < 0) {
            throw new IllegalArgumentException("Hourly rate cannot be negative");
        }
        this.ratePerHour = ratePerHour;
    }

    private double basePay() {
        return totalHoursWorked <= 40
                ? totalHoursWorked * ratePerHour
                : 40 * ratePerHour + (totalHoursWorked - 40) * ratePerHour * 1.5;
    }

    @Override
    public double computeSalary(int currentMonth) {
        return basePay() + super.computeSalary(currentMonth);
    }

    public void displayHourlyEmployee() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format(
                Locale.US,
                "HourlyEmployee{\n" +
                        "Employee ID: %d" +
                        ", \nEmployee Name: %s" +
                        ", \nBirth Date: %s" +
                        ", \nDate Hired: %s" +
                        ", \nTotal Hours Worked: %.2f" +
                        ", \nRate Per Hour: ₱%.2f" +
                        ", \nSalary: ₱%.2f" +
                        "\n}",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(),
                totalHoursWorked, ratePerHour, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HourlyEmployee)) {
            return false;
        }
        HourlyEmployee other = (HourlyEmployee) obj;
        return super.equals(other)
                && Float.compare(totalHoursWorked, other.totalHoursWorked) == 0
                && Double.compare(ratePerHour, other.ratePerHour) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalHoursWorked, ratePerHour);
    }

    @Override
    public HourlyEmployee clone() throws CloneNotSupportedException {
        return (HourlyEmployee) super.clone();
    }
}
