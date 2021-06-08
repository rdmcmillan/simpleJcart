package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class Step2Shopping {
    static Product doveSoap = new Product("Dove Soap", BigDecimal.valueOf(39.99));
    static Cart userCart = new Cart();

    @Test
    @DisplayName("Test Add additional products of the same type to the shopping cart")
    public void addInitialProduct() {
        int initialOrderQnty = 5;
        int additionalQntys = 3;
        BigDecimal unitPrice = new BigDecimal("39.99");
        BigDecimal cartTotal = new BigDecimal("319.92");

        userCart.updateCart(doveSoap, initialOrderQnty);
        userCart.updateCart(doveSoap, additionalQntys);

        CartProduct cartProduct = userCart.getCartProduct(doveSoap.getSku());

        assertEquals(initialOrderQnty + additionalQntys, cartProduct.getQuantity());
        assertEquals(unitPrice, cartProduct.getProductPrice());
        assertEquals(cartTotal, userCart.getCartNetTotal());
    }
}
