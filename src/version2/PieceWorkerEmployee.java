package version2;

public class PieceWorkerEmployee {
    private int empID;
    private MyName empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        this(0, new MyName(), new MyDate(), new MyDate(), 0, 0);
    }

    public PieceWorkerEmployee(int empID, MyName empName, MyDate birthDate, MyDate dateHired) {
        this(empID, empName, birthDate, dateHired, 0, 0);
    }

    public PieceWorkerEmployee(int empID, MyName empName, MyDate birthDate,
                               MyDate dateHired, int totalPiecesFinished,
                               double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
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
        double basePay = totalPiecesFinished * ratePerPiece;
        int bonusGroups = totalPiecesFinished / 100;
        double bonusPay = bonusGroups * 10 * ratePerPiece;

        return basePay + bonusPay;
    }

    public void displayPieceWorkerEmployee() {
        System.out.println("PieceWorkerEmployee{");
        System.out.println("EmployeeID: " + empID);
        System.out.println("EmployeeName: " + empName);
        System.out.println("EmployeeBirthDate: " + birthDate);
        System.out.println("EmployeeDateHired: " + dateHired);
        System.out.println("TotalPiecesFinished: " + totalPiecesFinished);
        System.out.println("RatePerPiece: " + ratePerPiece);
        System.out.println("TotalSalary: " + computeSalary());
        System.out.println("}");
    }

    @Override
    public String toString() {
        return "PieceWorkerEmployee{" +
                "\nEmployeeID: " + empID +
                "\nEmployeeName: " + empName +
                "\nEmployeeBirthDate: " + birthDate +
                "\nEmployeeDateHired: " + dateHired +
                "\nTotalPiecesFinished: " + totalPiecesFinished +
                "\nRatePerPiece: " + ratePerPiece +
                "\nTotalSalary: " + computeSalary() +
                "\n}";
    }
}
