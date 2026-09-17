package version4;

import java.util.Locale;
import java.util.Objects;

public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                               int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished < 0) {
            throw new IllegalArgumentException("Pieces finished cannot be negative");
        }
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece < 0) {
            throw new IllegalArgumentException("Piece rate cannot be negative");
        }
        this.ratePerPiece = ratePerPiece;
    }

    private double basePay() {
        return totalPiecesFinished * ratePerPiece
                + (totalPiecesFinished / 100) * 10 * ratePerPiece;
    }

    @Override
    public double computeSalary(int currentMonth) {
        return basePay() + super.computeSalary(currentMonth);
    }

    public void displayPieceWorkerEmployee() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format(
                Locale.US,
                "PieceWorkerEmployee{\n" +
                        "Employee ID: %d" +
                        ", \nEmployee Name: %s" +
                        ", \nBirth Date: %s" +
                        ", \nDate Hired: %s" +
                        ", \nTotal Pieces Finished: %d" +
                        ", \nRate Per Piece: ₱%.2f" +
                        ", \nSalary: ₱%.2f" +
                        "\n}",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(),
                totalPiecesFinished, ratePerPiece, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PieceWorkerEmployee)) {
            return false;
        }
        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;
        return super.equals(other)
                && totalPiecesFinished == other.totalPiecesFinished
                && Double.compare(ratePerPiece, other.ratePerPiece) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece);
    }

    @Override
    public PieceWorkerEmployee clone() throws CloneNotSupportedException {
        return (PieceWorkerEmployee) super.clone();
    }
}
