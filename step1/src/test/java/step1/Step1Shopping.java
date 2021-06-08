package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class Step1Shopping {
    static Product doveSoap = new Product("Dove Soap", BigDecimal.valueOf(39.99));
    static Cart userCart = new Cart();

    @Test
    @DisplayName("Test Add 5 Dove Soap to Cart")
    public void addInitialProduct() {
        int orderQnty = 5;
        BigDecimal unitPrice = new BigDecimal("39.99");
        BigDecimal cartTotal = new BigDecimal("199.95");
        userCart.updateCart(doveSoap, orderQnty);

        CartProduct cartProduct = userCart.getCartProduct(doveSoap.getSku());

        assertEquals(orderQnty, cartProduct.getQuantity());
        assertEquals(unitPrice, cartProduct.getProductPrice());
        assertEquals(cartTotal, userCart.getCartNetTotal());
    }
}
