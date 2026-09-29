package version6;

public abstract class Employee implements Cloneable {
    private final int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    protected Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        if (empName == null) {
            throw new NullPointerException("Employee name cannot be null");
        }
        if (birthDate == null) {
            throw new NullPointerException("Birth date cannot be null");
        }
        if (dateHired == null) {
            throw new NullPointerException("Date hired cannot be null");
        }
        this.empID = empID;
        this.empName = empName.clone();
        this.birthDate = birthDate.clone();
        this.dateHired = dateHired.clone();
    }

    public final int getEmpID() { return empID; }
    public final Name getEmpName() { return empName.clone(); }
    public final MyDate getBirthDate() { return birthDate.clone(); }
    public final MyDate getDateHired() { return dateHired.clone(); }

    public final void setEmpName(Name empName) {
        if (empName == null) {
            throw new NullPointerException("Employee name cannot be null");
        }
        this.empName = empName.clone();
    }

    public final void setBirthDate(MyDate birthDate) {
        if (birthDate == null) {
            throw new NullPointerException("Birth date cannot be null");
        }
        this.birthDate = birthDate.clone();
    }

    public final void setDateHired(MyDate dateHired) {
        if (dateHired == null) {
            throw new NullPointerException("Date hired cannot be null");
        }
        this.dateHired = dateHired.clone();
    }

    public final double getBirthdayBonus(int currentMonth) {
        if (currentMonth < 1 || currentMonth > 12) {
            throw new IllegalArgumentException("Current month must be between 1 and 12");
        }
        return birthDate.getMonth() == currentMonth ? 5000.00 : 0.00;
    }

    public abstract double computeSalary(int currentMonth);

    public abstract double computeSalary();

    public abstract void displayEmployee();

    @Override
    public final Employee clone() {
        try {
            Employee copy = (Employee) super.clone();
            copy.empName = empName.clone();
            copy.birthDate = birthDate.clone();
            copy.dateHired = dateHired.clone();
            return copy;
        } catch (CloneNotSupportedException exception) {
            throw new AssertionError(exception);
        }
    }
}
