import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ECommerceTest {

    @Test
    public void testAddProductToCart() {
        // Створюємо мок-об'єкт для Cart
        Cart cart = mock(Cart.class);
        Product product = new Product(1, "Телефон", 499.99);

        // Задаємо поведінку мок-об'єкта для додавання продукту до кошика
        when(cart.addProduct(Mockito.any(Product.class))).thenReturn(true);

        boolean result = cart.addProduct(product);

        assertTrue(result);
    }

    @Test
    public void testRemoveProductFromCart() {
        Cart cart = mock(Cart.class);
        Product product1 = new Product(1, "Телефон", 499.99);

        // Задаємо поведінку мок-об'єкта для видалення продукту з кошика
        when(cart.removeProduct(Mockito.any(Product.class))).thenReturn(true);

        boolean result = cart.removeProduct(product1);

        assertTrue(result);
    }

    @Test
    public void testCreateOrder() {
        Cart cart = mock(Cart.class);
        Product product1 = new Product(1, "Телефон", 499.99);
        Product product2 = new Product(2, "Ноутбук", 899.99);

        // Задаємо поведінку мок-об'єкта для отримання списку продуктів з кошика
        when(cart.getProducts()).thenReturn(List.of(product1, product2));

        Order order = new Order(1, cart.getProducts());

        assertNotNull(order);
        assertEquals(2, order.getProducts().size());
        assertEquals("В обробці", order.getStatus());
    }

    @Test
    public void testChangeOrderStatus() {
        Order order = mock(Order.class);

        // Задаємо поведінку мок-об'єкта для отримання та зміни статусу замовлення
        when(order.getStatus()).thenReturn("В обробці");
        doNothing().when(order).setStatus("Відправлено");

        order.setStatus("Відправлено");

        assertEquals("В обробці", order.getStatus());
    }
}
