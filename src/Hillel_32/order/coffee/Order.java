package Hillel_32.order.coffee;

public class Order {
    private final int number;
    private final String name;

    public Order(int number, String name) {
        if (number <= 0) throw new IllegalArgumentException("Order number must be positive");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be null or blank");

        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Order{" + "number=" + number + ", name='" + name + '\'' + '}';
    }
}

