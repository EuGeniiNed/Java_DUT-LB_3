import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product product = new Product(1, "Телефон", 499.99);

        // Створення кошика та додавання продукту
        Cart cart = new Cart();
        cart.addProduct(product);

        // Створення замовлення та виведення статусу
        Order order = new Order(1, cart.getProducts());
        System.out.println("Статус замовлення: " + order.getStatus());
    }
}
class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}

// Клас Cart
class Cart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}

// Клас Order
class Order {
    private int orderId;
    private List<Product> products;
    private String status;

    public Order(int orderId, List<Product> products) {
        this.orderId = orderId;
        this.products = products;
        this.status = "В обробці";
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public List<Product> getProducts() {
        return products;
    }

}
