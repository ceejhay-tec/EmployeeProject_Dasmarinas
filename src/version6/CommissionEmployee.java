package version6;

public class CommissionEmployee extends Employee {
    private double totalSale;

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                              double totalSale) {
        super(empID, empName, birthDate, dateHired);
        setTotalSale(totalSale);
    }

    public final double getTotalSale() { return totalSale; }

    public final void setTotalSale(double totalSale) {
        if (!Double.isFinite(totalSale) || totalSale < 0) {
            throw new IllegalArgumentException("Total sale cannot be negative");
        }
        this.totalSale = totalSale;
    }

    public final double getCommissionRate() {
        if (totalSale < 50000) return 0.05;
        if (totalSale < 100000) return 0.10;
        if (totalSale < 500000) return 0.15;
        return 0.20;
    }

    @Override
    public double computeSalary() {
        return totalSale * getCommissionRate();
    }

    @Override
    public double computeSalary(int currentMonth) {
        return computeSalary() + getBirthdayBonus(currentMonth);
    }

    @Override
    public void displayEmployee() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format(java.util.Locale.US,
                "CommissionEmployee{ID: %d, Name: %s, Birth Date: %s, Date Hired: %s, "
                        + "Total Sale: ₱%.2f, Rate: %.0f%%, Salary: ₱%.2f}",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(),
                totalSale, getCommissionRate() * 100, computeSalary());
    }
}
