import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ECommerceTest {

    @Test
    public void testAddProductToCart() {
        Product product = new Product(1, "Телефон", 499.99);
        Cart cart = new Cart();

        cart.addProduct(product);

        assertTrue(cart.getProducts().contains(product));
    }

    @Test
    public void testRemoveProductFromCart() {
        Product product1 = new Product(1, "Телефон", 499.99);
        Product product2 = new Product(2, "Ноутбук", 899.99);
        Cart cart = new Cart();

        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.removeProduct(product1);

        assertFalse(cart.getProducts().contains(product1));
        assertTrue(cart.getProducts().contains(product2));
    }

    @Test
    public void testCreateOrder() {
        Product product1 = new Product(1, "Телефон", 499.99);
        Product product2 = new Product(2, "Ноутбук", 899.99);
        Cart cart = new Cart();

        cart.addProduct(product1);
        cart.addProduct(product2);
        Order order = new Order(1, cart.getProducts());

        assertNotNull(order);
        assertEquals(2, order.getProducts().size());
        assertEquals("В обробці", order.getStatus());
    }

    @Test
    public void testChangeOrderStatus() {
        Product product1 = new Product(1, "Телефон", 499.99);
        Cart cart = new Cart();

        cart.addProduct(product1);
        Order order = new Order(1, cart.getProducts());

        order.setStatus("Відправлено");

        assertEquals("Відправлено", order.getStatus());
    }
}
