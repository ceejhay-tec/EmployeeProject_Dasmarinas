package version4;

public class EmployeeRoster {
    private Employee[] empList;
    private int max;
    private int count;

    public EmployeeRoster() {
        this(10);
    }

    public EmployeeRoster(int max) {
        this.empList = new Employee[this.max];
        this.max = max;
        this.count = 0;
    }

    public Employee[] getEmpList() {
        return empList;
    }

    public void setEmpList(Employee[] empList) {
        this.empList = empList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null || count >= max) {
            return false;
        }
        empList[count] = emp;
        count++;
        return true;
    }

    public Employee removeEmployee(int empID) {
        for (int i = 0; i < count; i++){
            if (empList[i].getEmpID()==empID){
                Employee removedEmployee = empList[i];

                for (int j = i; j < count-1; j++){
                    empList[j] = empList[j+1];
                }
                empList[count-1] = null;
                count--;

                return removedEmployee;
            }
        }
        return null;
    }

    public Employee searchEmployee (int empID) {
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                return empList[i];
            }
        } return null;
    }



}
