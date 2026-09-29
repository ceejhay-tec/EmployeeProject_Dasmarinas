package version6;

public class HourlyEmployee extends Employee {
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                          float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public final float getTotalHoursWorked() { return totalHoursWorked; }

    public final void setTotalHoursWorked(float totalHoursWorked) {
        if (!Float.isFinite(totalHoursWorked) || totalHoursWorked < 0) {
            throw new IllegalArgumentException("Hours worked must be non-negative");
        }
        this.totalHoursWorked = totalHoursWorked;
    }

    public final double getRatePerHour() { return ratePerHour; }

    public final void setRatePerHour(double ratePerHour) {
        if (!Double.isFinite(ratePerHour) || ratePerHour < 0) {
            throw new IllegalArgumentException("Rate per hour cannot be negative");
        }
        this.ratePerHour = ratePerHour;
    }

    @Override
    public final double computeSalary() {
        double regularHours = Math.min(totalHoursWorked, 40);
        double overtimeHours = Math.max(totalHoursWorked - 40, 0);
        return regularHours * ratePerHour + overtimeHours * ratePerHour * 1.5;
    }

    @Override
    public final double computeSalary(int currentMonth) {
        return computeSalary() + getBirthdayBonus(currentMonth);
    }

    @Override
    public final void displayEmployee() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format(java.util.Locale.US,
                "HourlyEmployee{ID: %d, Name: %s, Birth Date: %s, Date Hired: %s, "
                        + "Hours: %.2f, Rate: ₱%.2f, Salary: ₱%.2f}",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(),
                totalHoursWorked, ratePerHour, computeSalary());
    }
}
