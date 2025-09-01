package Project_17.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics", 1200));
        products.add( new Product("Coffee Maker", "Appliances", 80.0));
        products.add( new Product("Smartphone", "Electronics", 600.0));
        products.add( new Product("Tablet", "Electronics", 300.0));
        products.add( new Product("Headphones", "Electronics", 40.0));
        products.add( new Product("Camera", "Electronics", 400.0));

        Map<String, Double> categories = products.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));
        String mostExpensiveCategory = categories.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

        products.forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        System.out.println("Categories and their average prices:");
        categories.forEach((category, averagePrice) -> System.out.println("Category: " + category + ", Average Price: " + averagePrice));
        System.out.println("--------------------------------------------------");
        System.out.println("The most expensive category is: " + mostExpensiveCategory);
    }
}
