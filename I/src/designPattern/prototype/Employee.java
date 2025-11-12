package designPattern.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Cloneable {
    // data field
    private List<String> employeeList;

    // constructor
    public Employee() {
        this.employeeList = new ArrayList<>();
    }

    public Employee(List<String> tempt) {
        this.employeeList = tempt;
    }

    // method
    public void loadData() {
        employeeList.add("Alex");
        employeeList.add("Bob");
        employeeList.add("Carl");
        employeeList.add("David");
        employeeList.add("Emily");
        employeeList.add("John");
    }

    // getter
    public List<String> getEmployeeList() {
        return this.employeeList;
    }

    @Override
    public Object clone() {
        // create a tempt list and add all the item in loaddata in this tempt list
        List<String> tempt = new ArrayList<>();

        for (String s : this.getEmployeeList()) {
            tempt.add(s);
        }

        return new Employee(tempt);
    }
}
