package Hillel_32.order.coffee;

import java.util.Queue;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class CoffeeOrderBoard {

    private static final Logger logger = LogManager.getLogger(CoffeeOrderBoard.class);

    private final Map<Integer, Order> orders = new LinkedHashMap<>();
    private int lastOrderNumber = 0;

    public synchronized void add(String name) {
        if (name == null || name.isBlank()) {
            logger.warn("Attempted to add order with null or empty name");
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        lastOrderNumber++;
        Order order = new Order(lastOrderNumber, name);
        orders.put(order.getNumber(), order);
        logger.info("Added new order: {}", order);
    }

    public synchronized Order deliver() {
        if (orders.isEmpty()) {
            logger.warn("Deliver called but there are no orders");
            return null;
        }
        Integer firstKey = orders.keySet().iterator().next();
        Order order = orders.remove(firstKey);
        logger.info("Delivered order: {}", order);
        return order;
    }

    public synchronized Order deliver(int orderNumber) {
        Order order = orders.remove(orderNumber);
        if (order == null) {
            logger.warn("Attempted to deliver non-existent order with number {}", orderNumber);
            return null;
        }
        logger.info("Delivered specific order: {}", order);
        return order;
    }

    public synchronized void draw() {
        logger.info("Drawing current order board:");
        System.out.println("Num | Name");
        for (Order order : orders.values()) {
            System.out.printf("%d | %s%n", order.getNumber(), order.getName());
        }
    }
}

