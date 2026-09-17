package version2;

import java.time.LocalDate;

public class CommissionEmployee {
    private int empID;
    private MyName empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private double totalSale;

    public CommissionEmployee() {
        this(0, new MyName(), new MyDate(), new MyDate(), 0);
    }

    public CommissionEmployee(int empID, MyName empName,
                              MyDate birthDate, MyDate dateHired) {
        this(empID, empName, birthDate, dateHired, 0);
    }

    public CommissionEmployee(int empID, MyName empName,
                              MyDate birthDate, MyDate dateHired,
                              double totalSale) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.totalSale = totalSale;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public MyName getEmpName() {
        return empName;
    }

    public void setEmpName(MyName empName) {
        this.empName = empName;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public double computeSalary() {
        double salary;

        if (totalSale < 50_000) {
            salary = 0.05 * totalSale;
        } else if (totalSale < 100_000) {
            salary = 0.10 * totalSale;
        } else if (totalSale < 500_000) {
            salary = 0.15 * totalSale;
        } else {
            salary = 0.20 * totalSale;
        }

        salary += getBirthMonthBonus();

        return salary;
    }

    private double getBirthMonthBonus() {
        double bdayBonus = 5000;
        int currentMonth = LocalDate.now().getMonthValue();

        if (birthDate.isMonth(currentMonth)) {
            return bdayBonus;
        }

        return 0;
    }

    public void displayCommissionEmployee() {
        System.out.println("CommissionEmployee{");
        System.out.println("EmployeeID: " + empID);
        System.out.println("EmployeeName: " + empName);
        System.out.println("EmployeeBirthDate: " + birthDate);
        System.out.println("EmployeeDateHired: " + dateHired);
        System.out.println("TotalSales: " + totalSale);
        System.out.println("Salary: " + computeSalary());
        System.out.println("}");
    }

    @Override
    public String toString() {
        return "CommissionEmployee{" +
                "\nEmployeeID: " + empID +
                "\nEmployeeName: " + empName +
                "\nEmployeeBirthDate: " + birthDate +
                "\nEmployeeDateHired: " + dateHired +
                "\nTotalSales: " + totalSale +
                "\nSalary: " + computeSalary() +
                "\n}";
    }
}
