package version1;

public class BasePlusCommissionEmployee {
    private int empID;
    private String empName;
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        this(0, "N/A", 0, 0);
    }

    public BasePlusCommissionEmployee(int empID, String empName) {
        this(empID, empName, 0, 0);
    }

    public BasePlusCommissionEmployee(int empID, String empName, double totalSale, double baseSalary) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
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

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double computeSalary(){
        double Salary = 0;

        if(totalSale < 50_000){
            Salary = (0.05 * totalSale) + baseSalary;
        } else if (totalSale >= 50_000 && totalSale < 100_000){
            Salary = (0.10 * totalSale) + baseSalary;
        } else if (totalSale >= 100_000 && totalSale < 500_000) {
            Salary = (0.15 * totalSale) + baseSalary;
        } else if (totalSale >= 500_000){
            Salary = (0.20 * totalSale) + baseSalary;
        }
        return Salary;
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.println("BasePlusCommissionEmployee{");
        System.out.println("\nEmployeeID: " + this.empID);
        System.out.println("\nEmployeeName: " + this.empName);
        System.out.println("\nTotalSales: " + this.totalSale);
        System.out.println("\nBaseSalary: " + this.baseSalary);
        System.out.println('}');
    }

    @Override
    public String toString() {
        return "BasePlusCommissionEmployee{" +
                "\nEmployeeID:" + empID +
                "\nEmployeeName: " + empName + '\'' +
                "\nTotalSales: " + totalSale +
                "\nBaseSalary: " + baseSalary +
                "\nSalary: " + computeSalary() +
                '}';
    }
}
