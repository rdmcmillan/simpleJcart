package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class Step3Shopping {
    static Product doveSoap = new Product("Dove Soap", new BigDecimal("39.99"));
    static Product axeDeo = new Product("Axe Deo", new BigDecimal("99.99"));
    static Cart userCart = new Cart();

    @Test
    @DisplayName("Calculate the tax rate of the shopping cart with multiple items")
    public void addInitialProduct() {
        int doveQnty = 2;
        int axeQnty = 2;
        BigDecimal doveUnitPrice = new BigDecimal("39.99");
        BigDecimal axeUnitPrice = new BigDecimal("99.99");
        BigDecimal totalTax = new BigDecimal("35.00");
        BigDecimal cartTotal = new BigDecimal("314.96");

        userCart.updateCart(doveSoap, doveQnty);
        userCart.updateCart(axeDeo, axeQnty);

        CartProduct doveCartProduct = userCart.getCartProduct(doveSoap.getSku());
        CartProduct axeCartProduct = userCart.getCartProduct(axeDeo.getSku());

        assertEquals(doveQnty, doveCartProduct.getQuantity());
        assertEquals(doveUnitPrice, doveCartProduct.getProductPrice());

        assertEquals(axeQnty, doveCartProduct.getQuantity());
        assertEquals(axeUnitPrice, axeCartProduct.getProductPrice());

        assertEquals(totalTax, userCart.getTotalTax());
        assertEquals(cartTotal, userCart.getTotalWithTax());
    }
}
