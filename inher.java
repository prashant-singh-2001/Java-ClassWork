class Employee {
    int empNumber;
    String empName = null;

    Employee() {
        empNumber = 0;
        empName = "NIL";
    }

    Employee(int empNumber) {
        this.empNumber = empNumber;
        this.empName = "UNKNOWN";
    }

    Employee(int empNumber, String empName) {
        this.empNumber = empNumber;
        this.empName = empName;
    }

    public String getEmpName() {
        return empName;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    @Override
    public String toString() {

        return empNumber + ":>  " + empName;
    }
}

class Manager extends Employee {
    String desig;

    Manager() {
        super();
    }

    Manager(int empNumber, String empName) {
        super(empNumber, empName);
    }

    Manager(int empNumber, String empName, String desig) {
        super(empNumber, empName);
        this.desig = desig;
    }

    public String getDesig() {
        return desig;
    }

    @Override
    public String toString() {

        return super.toString() + " " + desig;
    }
}

public class inher extends Manager {
    inher() {
        this(0, "", "");
    }

    inher(int a, String b) {
        super(a, b);
    }

    inher(int a, String b, String c) {
        super(a, b, c);
    }

    public static void main(String[] args) {
        Employee A = new Employee();
        Employee B = new Manager(43, "Prashant Singh");
        System.out.println(A.getEmpNumber());
        System.out.println(B.getEmpNumber());
        inher c = new inher(b101, "Khushi", "CEO");
        System.out.println(c.toString());
    }
}
