package app;

    // Клас розрахунку базової вартості товару
// ЗАВДАННЯ: Виправити код класу.
    public class CalcCostBase extends Product {


        public CalcCostBase(String name, int quota, double price) {
            super(name, quota, price);
        }

        // Базовий розрахунок вартості товару
        public double calcCost(Product product) {
            return product.getQuota() * product.getPrice();
        }
    }


