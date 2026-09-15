package version2;

public class HourlyEmployee {
    private int empID;
    private MyName empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private float totalHoursWorked;
    private double ratePerHour;


    public HourlyEmployee() {
        this(0, new MyName(), new MyDate(), new MyDate(), 0, 0);
    }

    public HourlyEmployee(int empID, MyName empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
    }

    public HourlyEmployee(int empID, MyName empName, MyDate birthDate, MyDate dateHired, float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
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

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public double computeSalary() {
        double salary;
        if (totalHoursWorked <= 40) {
            salary = ratePerHour * totalHoursWorked;
        } else {
            salary = (40*ratePerHour + ((totalHoursWorked-40)*(ratePerHour*1.5)));
        }
        return salary;
    }

    public void displayHourlyEmployee() {
        System.out.println("EmployeeID: " + this.empID);
        System.out.println("EmployeeName: " + this.empName);
        System.out.println("\nEmployeeBirthDate: "+ this.birthDate);
        System.out.println("\nEmployeeDateHired: "+ this.dateHired);
        System.out.println("TotalHoursWorked: " + this.totalHoursWorked);
        System.out.println("RatePerHour: " + this.ratePerHour);
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "\nEmployeeID: " + empID +
                "\nEmployeeName: " + empName +
                "\nEmployeeBirthDate: " + birthDate +
                "\nEmployeeDateHired: " + dateHired +
                "\nTotalHoursWorked: " + totalHoursWorked +
                "\nRatePerHour: " + ratePerHour +
                "\nTotalComputedSalary: " + computeSalary() +
                '}';
    }
}

