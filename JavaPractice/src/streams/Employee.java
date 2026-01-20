package streams;

import java.util.*;
import java.util.stream.Collectors;

public class Employee {

	private int id;
	private String name;
	private int age;
	private long salary;
	private String gender;
	private String deptName;
	private String city;
	private int yearOfJoining;
	
	public Employee(int id, String name, int age, long salary, String gender, String deptName, String city,
			int yearOfJoining) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.gender = gender;
		this.deptName = deptName;
		this.city = city;
		this.yearOfJoining = yearOfJoining;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", gender=" + gender
				+ ", deptName=" + deptName + ", city=" + city + ", yearOfJoining=" + yearOfJoining + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}
	
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1,"Yanksha",28,123,"F","HR","Blore",2020));
		empList.add(new Employee(2,"Francesca",29,120,"F","HR","Hyderabad",2015));
		empList.add(new Employee(3,"Ramesh",30,115,"M","HR","Chennai",2014));
		empList.add(new Employee(4,"Melanie",28,125,"F","HR","Chennai",2013));
		
		empList.add(new Employee(5,"Padma",22,150,"F","IT","Noida",2013));
		empList.add(new Employee(6,"Milad",27,140,"M","IT","Gurugram",2017));
		empList.add(new Employee(7,"Uzma",26,130,"F","IT","Pune",2016));
		empList.add(new Employee(8,"Ali",23,145,"M","IT","Trivendram",2015));
		empList.add(new Employee(9,"Ram",25,160,"M","IT","Blore",2010));
		
		//group the employees by city
		Map<String, List<Employee>> empByCity = empList.stream().collect(Collectors.groupingBy(Employee::getCity));
		System.out.println("Employees grouped by city :: \n"+empByCity);
		
		//group the employees by age
		Map<Integer, List<Employee>> empByAge = empList.stream().collect(Collectors.groupingBy(Employee::getAge));
		System.out.println("Employees grouped by age :: \n"+empByAge);
		
		//Find the count of male and female employees present in the organization
		Map<String, Long> noOfMaleAndFemaleEmployees = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("Count of male and female employees present in the organization :: \n"+noOfMaleAndFemaleEmployees);
		
		//Find the count of male and female employees present in each department
		Map<String, Map<String, Long>> genderMapInDept = empList.stream().collect(Collectors.groupingBy
				(Employee::getDeptName,Collectors.groupingBy(Employee::getGender, Collectors.counting())));
		System.out.println("Count of male and female employees present in each department::"+genderMapInDept);

		//Print the names of all distinct departments in the organization
		System.out.println("Names of all departments in the organization ");
		empList.stream().map(Employee::getDeptName).distinct().forEach(System.out::println);

		//Print employee details whose age is greater than 28 in the organization
		System.out.println("Employee details whose age is greater than 28");
		empList.stream().filter(e->e.getAge()>28).toList().forEach(System.out::println);

		//Find maximum age/oldest of employee in the organization
		OptionalInt max = empList.stream().mapToInt(Employee::getAge).max();
		Optional<Employee> oldestEmp = empList.stream().max(Comparator.comparingInt(Employee::getAge));
        System.out.println("Maximum age of Employee: " + max.getAsInt());
		System.out.println("Oldest employee details:: \n" + oldestEmp.get());

		//Print average age of Male and Female employees in the organization
		Map<String, Double> avgAge = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println("Average age of Male and Female employees:: "+avgAge);

		//Print average age of Male and Female Employees in each department
		Map<String,Map<String, Double>> deptMapInGender = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,
				Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge))));
		System.out.println("Average age by gender in each department:: "+deptMapInGender);

		//Print the number of employees in each department
		Map<String, Long> countByDept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
		System.out.println("No of employees in each department:: "+countByDept);

		//Find the longest serving employees in the organization
		Optional<Employee> seniorEmp = empList.stream().min(Comparator.comparingInt(Employee::getYearOfJoining));
		System.out.println("Longest serving employee: "+seniorEmp);

		//Find the longest serving employee in each department
		empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,
				Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining))))
				.forEach((dept,empOpt)->
				empOpt.ifPresent(emp-> System.out.println(dept +" - "+emp.getName()+ " (DOJ:  "+emp.getYearOfJoining() +")")));

		//Find average age of gender in each department
		System.out.println("Average age by gender in each department::");
		empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.groupingBy(Employee::getGender,
				Collectors.averagingDouble(Employee::getAge)))).forEach((dept,genderMap)->
				genderMap.forEach((gender, ageAge)-> System.out.println(dept+" - "+gender+ ":"+ageAge)));

		//Find the youngest female employee in each department
		Optional<Employee> youngestEmp = empList.stream().filter(e->e.getGender() == "F").min(Comparator.comparingInt(Employee::getAge));
		System.out.println("Youngest Female employee details:: \n"+youngestEmp);

		//Find the youngest employee in each department
		empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.minBy(Comparator.comparingInt(Employee::getAge))))
				.forEach((department,empOptional)-> empOptional.ifPresent(e->System.out.println(department+" - "+e.getName()+" - "+e.getAge())));
    }
	
}
