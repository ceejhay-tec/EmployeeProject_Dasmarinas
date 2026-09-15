package version2;

public class CommissionEmployee {
    private int empID;
    private MyName empName;
    private MyDate birthDate;
    private MyDate dateHired;
    double totalSale;

    public CommissionEmployee() {
        this(0, new MyName(), new MyDate(), new MyDate(), 0);
    }

    public CommissionEmployee(int empID, MyName empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
    }

    public CommissionEmployee(int empID, MyName empName, MyDate birthDate, MyDate dateHired, double totalSale) {
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

    public double computeSalary(){
        double Salary = 0;

        if(totalSale < 50_000){
            Salary = (0.05 * totalSale);
        } else if (totalSale >= 50_000 && totalSale < 100_000){
            Salary = (0.10 * totalSale);
        } else if (totalSale >= 100_000 && totalSale < 500_000) {
            Salary = (0.15 * totalSale);
        } else if (totalSale >= 500_000){
            Salary = (0.20 * totalSale);
        }
        return Salary;
    }

    public void displayCommissionEmployee() {
        System.out.println("CommissionEmployee{");
        System.out.println("\nEmployeeID: " + this.empID);
        System.out.println("\nEmployeeName: " + this.empName);
        System.out.println("\nEmployeeBirthDate: "+ this.birthDate);
        System.out.println("\nEmployeeDateHired: "+ this.dateHired);
        System.out.println("\nTotalSales: " + this.totalSale);
        System.out.println('}');
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
                '}';
    }
}

