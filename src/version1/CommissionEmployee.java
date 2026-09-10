package version1;

public class CommissionEmployee {
    private int empID;
    private String empName;
    double totalSale;

    public CommissionEmployee() {
        this(0, "N/A", 0);
    }

    public CommissionEmployee(int empID, String empName) {
        this(empID, empName, 0);
    }

    public CommissionEmployee(int empID, String empName, double totalSale) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
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
        System.out.println("\nTotalSales: " + this.totalSale);
        System.out.println('}');
    }

    @Override
    public String toString() {
        return "CommissionEmployee{" +
                "\nEmployeeID: " + empID +
                "\nEmployeeName: " + empName + '\'' +
                "\nTotalSales: " + totalSale +
                "\nSalary: " + computeSalary() +
                '}';
    }
}

