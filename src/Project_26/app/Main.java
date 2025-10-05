package Project_26.app;

public class Main {
    public static void main(String[] args) {
        User user = new User("John", "john@gmail.com", "password");

        Address address = new Address("123 Main St", "Anytown", "CA", "12345");
        user.setAddress(address);

        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Address: " + user.getAddress());


    }
}
