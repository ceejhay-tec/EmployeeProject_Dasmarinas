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
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
    }

    public PieceWorkerEmployee(int empID, MyName empName, MyDate birthDate, MyDate dateHired, int totalPiecesFinished, double ratePerPiece) {
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
        System.out.println("\nEmployeeBirthDate: "+ this.birthDate);
        System.out.println("\nEmployeeDateHired: "+ this.dateHired);
        System.out.println("\nTotalPiecesFinished: "+ this.totalPiecesFinished);
        System.out.println("\nRatePerPiece: "+ this.ratePerPiece);
        System.out.println("\n}");
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
                '}';
    }

}


