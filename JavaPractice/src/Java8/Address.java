package Java8;

import java.util.List;

class Address {
    private String street;
    private String city;
    private String pincode;

    // Constructor
    public Address(String street, String city, String pincode) {
        this.street = street;
        this.city = city;
        this.pincode = pincode;
    }

    // Getter for pincode
    public String getPincode() {
        return pincode;
    }
}

class Employee {
    private String name;
    private List<Address> addresses;

    // Constructor
    public Employee(String name, List<Address> addresses) {
        this.name = name;
        this.addresses = addresses;
    }

    // Getter for addresses
    public List<Address> getAddresses() {
        return addresses;
    }
}