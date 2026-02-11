
package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PincodeExtractor {
    public static void main(String[] args) {
        // Sample data
        Address address1 = new Address("123 Main St", "Anytown", "12345");
        Address address2 = new Address("456 Oak Ave", "Otherville", "67890");
        Address address3 = new Address("789 Pine Ln", "Anytown", "11223");

        Employee employee1 = new Employee("Alice", Arrays.asList(address1, address2));
        Employee employee2 = new Employee("Bob", Arrays.asList(address3));

        List<Employee> employees = Arrays.asList(employee1, employee2);

        // Extract all pincodes
        List<String> allPincodes = employees.stream()
                .flatMap(employee -> employee.getAddresses().stream()) // Flatten the list of addresses from each employee
                .map(Address::getPincode) // Map each address to its pincode
                .collect(Collectors.toList()); // Collect the results into a list

        System.out.println("All Pincodes: " + allPincodes);
    }
}