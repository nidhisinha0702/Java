package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmpDemo {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
		
		empList.add(new Employee(1, 500));
		empList.add(new Employee(2, 1000));
		empList.add(new Employee(3, 1500));
		empList.add(new Employee(4, 2000));
		empList.add(new Employee(5, 2500));
		empList.add(new Employee(6, 3000));
		empList.add(new Employee(7, 3500));
		
		List<Employee> sortedBasedOnSalary = empList.stream().sorted((o1,o2) -> (int)(o2.getSalary() - o1.getSalary())).collect(Collectors.toList());
		
		System.out.println(sortedBasedOnSalary);
		
		List<Employee> top3Sal = empList.stream().sorted((o1,o2) -> (int)(o2.getSalary() - o1.getSalary())).limit(3).collect(Collectors.toList());
		
		System.out.println(top3Sal);
	}

}
