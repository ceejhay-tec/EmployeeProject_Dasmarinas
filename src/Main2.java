import version2.BasePlusCommissionEmployee;
import version2.CommissionEmployee;
import version2.HourlyEmployee;
import version2.MyDate;
import version2.MyName;
import version2.PieceWorkerEmployee;

public class Main2 {

    public static void main(String[] args) {
        int bdayMonth = 9;

        MyName n1 = new MyName("Garcia", "Miguel", "", "");
        MyDate d1 = new MyDate(14, 9, 2005);
        MyDate c1 = new MyDate(8, 6, 2022);
        HourlyEmployee he1 = new HourlyEmployee(101, n1, d1, c1, 40, 8);

        MyName n2 = new MyName("Reyes", "Angela", "", "");
        MyDate d2 = new MyDate(22, 4, 2004);
        MyDate c2 = new MyDate(15, 8, 2021);
        PieceWorkerEmployee he2 = new PieceWorkerEmployee(102, n2, d2, c2, 250, 6);

        MyName n3 = new MyName("Santos", "Daniel", "", "");
        MyDate d3 = new MyDate(7, 9, 2003);
        MyDate c3 = new MyDate(20, 5, 2020);
        CommissionEmployee he3 = new CommissionEmployee(103, n3, d3, c3, 120000);

        MyName n4 = new MyName("Mendoza", "Sofia", "Cruz", "Jr.");
        MyDate d4 = new MyDate(18, 3, 2002);
        MyDate c4 = new MyDate(12, 4, 2019);
        BasePlusCommissionEmployee he4 =
                new BasePlusCommissionEmployee(104, n4, d4, c4, 150000, 25000);

        System.out.println(he1);
        System.out.println(he2);
        System.out.println(he3);
        System.out.println(he4);
    }
}
