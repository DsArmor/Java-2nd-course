package CustomerInfo;

public final class Customer {
    private final String firstName;
    private final String secondName;
    private final int age;
    private final Address address;

    public Customer(String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }
    public String toString(){
        return firstName+" "+secondName+" - "+address.getStreetName()+" "+address.getBuildingNumber()+" квартира "+address.getApartmentNumber();
    }
}
