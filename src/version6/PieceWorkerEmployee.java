package version6;

public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                               int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public final int getTotalPiecesFinished() { return totalPiecesFinished; }

    public final void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished < 0) {
            throw new IllegalArgumentException("Pieces finished cannot be negative");
        }
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public final double getRatePerPiece() { return ratePerPiece; }

    public final void setRatePerPiece(double ratePerPiece) {
        if (!Double.isFinite(ratePerPiece) || ratePerPiece < 0) {
            throw new IllegalArgumentException("Rate per piece cannot be negative");
        }
        this.ratePerPiece = ratePerPiece;
    }

    @Override
    public final double computeSalary() {
        return totalPiecesFinished * ratePerPiece
                + (int) Math.floor(totalPiecesFinished / 100.0) * 10 * ratePerPiece;
    }

    @Override
    public final double computeSalary(int currentMonth) {
        return computeSalary() + getBirthdayBonus(currentMonth);
    }

    @Override
    public final void displayEmployee() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format(java.util.Locale.US,
                "PieceWorkerEmployee{ID: %d, Name: %s, Birth Date: %s, Date Hired: %s, "
                        + "Pieces: %d, Rate: ₱%.2f, Salary: ₱%.2f}",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(),
                totalPiecesFinished, ratePerPiece, computeSalary());
    }
}
