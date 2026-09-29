package version6;

public final class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate,
                                      MyDate dateHired, double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        setBaseSalary(baseSalary);
    }

    public final double getBaseSalary() { return baseSalary; }

    public final void setBaseSalary(double baseSalary) {
        if (!Double.isFinite(baseSalary) || baseSalary < 0) {
            throw new IllegalArgumentException("Base salary cannot be negative");
        }
        this.baseSalary = baseSalary;
    }

    @Override
    public double computeSalary() {
        return baseSalary + super.computeSalary();
    }

    @Override
    public double computeSalary(int currentMonth) {
        return baseSalary + super.computeSalary(currentMonth);
    }

    @Override
    public void displayEmployee() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format(java.util.Locale.US,
                "BasePlusCommissionEmployee{ID: %d, Name: %s, Birth Date: %s, "
                        + "Date Hired: %s, Total Sale: ₱%.2f, Base Salary: ₱%.2f, "
                        + "Salary: ₱%.2f}",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(),
                getTotalSale(), baseSalary, computeSalary());
    }
}
