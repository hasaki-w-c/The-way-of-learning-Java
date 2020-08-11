package jiekou;

import java.util.Arrays;

public class EmployeeSortTest {
    public static void main(String[] args)
    {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("xxx", 35000);
        staff[1] = new Employee("yyy", 75000);
        staff[2] = new Employee("zzz", 38000);

        Arrays.sort(staff);

        for (Employee e : staff)
            System.out.println("name = " + e.getName() + ",salary = " + e.getSalary());
    }
}
