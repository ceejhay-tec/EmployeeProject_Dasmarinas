package version1;

public class PieceWorkerEmployee {
    private int empID;
    private String empName;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        this(0, "N/A", 0, 0);
    }

    public PieceWorkerEmployee(int empID, String empName) {
        this(empID, empName, 0, 0);
    }

    public PieceWorkerEmployee(int empID, String empName, int totalPiecesFinished, double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
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

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = ratePerPiece;
    }

    public double computeSalary() {
        double BasePay = totalPiecesFinished * ratePerPiece;
        double BonusPay = 0;
        double Salary = 0;

        while (totalPiecesFinished >= 100) {
            totalPiecesFinished = totalPiecesFinished - 100;
            BonusPay = BonusPay + (10 * ratePerPiece);
        }

        if (totalPiecesFinished < 100) {
            Salary = BasePay + BonusPay;
        }
        return Salary;
    }

    public void displayPieceWorkerEmployee(){
        System.out.println("PieceWorkerEmployee{\n");
        System.out.println("EmployeeID: "+ this.empID);
        System.out.println("\nEmployeeName: "+ this.empName);
        System.out.println("\nTotalPiecesFinished: "+ this.totalPiecesFinished);
        System.out.println("\nRatePerPiece: "+ this.ratePerPiece);
        System.out.println("\n}");
    }

    @Override
    public String toString() {
        return "PieceWorkerEmployee{" +
                "\nEmployeeID:" + empID +
                "\nEmployeeName:" + empName + '\'' +
                "\nTotalPiecesFinished: " + totalPiecesFinished +
                "\nRatePerPiece: " + ratePerPiece +
                "\nTotalSalary: " + computeSalary() +
                '}';
    }

}

