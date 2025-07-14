package Project_05.app;

// Клас розрахунку вартості товару,
// враховуючи вартість доставки
// ЗАВДАННЯ: Виправити код класу.
// Клас успадковує клас CalcCostBase.
public class CalcCostDelivery extends CalcCostBase {

    private final static double deliveryPrice = 7 ;

    public CalcCostDelivery(String name, int quota, double price) {
        super(name, quota, price);
    }

    @Override
    public double calcCost(Product product) {
        return product.getQuota() * product.getPrice() + deliveryPrice;
    }
}
