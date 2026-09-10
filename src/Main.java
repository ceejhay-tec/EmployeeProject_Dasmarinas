import version1.HourlyEmployee;
import version1.PieceWorkerEmployee;
import version1.CommissionEmployee;
import version1.BasePlusCommissionEmployee;

public class Main {
    public static void main(String[] args) {
        HourlyEmployee p1 = new HourlyEmployee();
        HourlyEmployee p2 = new HourlyEmployee(1, "Bib", 40, 80);
        HourlyEmployee p3 = new HourlyEmployee(2, "Mil", 35, 75);
        HourlyEmployee p4 = new HourlyEmployee(3, "Rom", 45, 85);

        System.out.println(p2);
        System.out.println("\n" + p3);
        System.out.println("\n" + p4);

        PieceWorkerEmployee w1 = new PieceWorkerEmployee(4, "Dani", 120, 150);
        PieceWorkerEmployee w2 = new PieceWorkerEmployee(5, "Lloyd",200, 150);

        System.out.println("\n" + w1);
        System.out.println("\n" + w2);

        CommissionEmployee c1 = new CommissionEmployee(6,"Jupao", 30_000);
        CommissionEmployee c2 = new CommissionEmployee(7,"Ck", 80_000);
        CommissionEmployee c3 = new CommissionEmployee(8,"Amara", 120_000);

        System.out.println("\n" + c1);
        System.out.println("\n" + c2);
        System.out.println("\n" + c3);

        BasePlusCommissionEmployee b1 = new BasePlusCommissionEmployee(9,"Dave", 30_000, 100_000);
        BasePlusCommissionEmployee b2 = new BasePlusCommissionEmployee(10,"Jhezy", 80_000, 100_000);
        BasePlusCommissionEmployee b3 = new BasePlusCommissionEmployee(11,"Pearl", 120_000, 100_000);

        System.out.println("\n" + b1);
        System.out.println("\n" + b2);
        System.out.println("\n" + b3);

    }
}