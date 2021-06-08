package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    static String testName = "Shampoo";
    static BigDecimal testPrice = new BigDecimal(1.00);
    static Product testProduct;

    @BeforeEach
    public void initProduct() {
        testProduct = new Product(testName, testPrice);
    }

    @Test
    @DisplayName("Reality Check")
    public void realityCheck() {
        assertEquals(1, 1);
    }

    @Test
    @DisplayName("Test Product Name")
    public void testProductName() {
        assertEquals(testName, testProduct.getName());
    }

    @Test
    @DisplayName("Test Product Price")
    public void testProductPrice() {
        assertEquals(testPrice, testProduct.getPrice());
    }

    @Test
    @DisplayName("Test Get Product SKU")
    public void testProductSku() {
        assertTrue(testProduct.getSku() != null);
    }

}