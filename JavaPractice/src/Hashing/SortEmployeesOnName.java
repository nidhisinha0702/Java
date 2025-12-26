package Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortEmployeesOnName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("John","Doe",30));
		employees.add(new Employee("Alice", "Smith", 25));
        employees.add(new Employee("John", "Adams", 35));
        employees.add(new Employee("Alice", "Brown", 28));
        
        //Use Collections.sort
        Collections.sort(employees, new Comparator<Employee>() {
        	@Override
        	public int compare(Employee e1, Employee e2) {
        		int firstNameCmp = e1.getFirstName().compareTo(e2.getFirstName());
        		if(firstNameCmp != 0) {
        			return firstNameCmp;
        		}else {
        			return e1.getLastName().compareTo(e2.getLastName());
        		}
        	}
        });
        
        for(Employee e:employees)
        	System.out.println(e);
	}

}

class Employee{
	String firstName;
	String lastName;
	int age;
	
	public Employee(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
	
}
