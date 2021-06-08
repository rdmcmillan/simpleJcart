package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CartProductTest {
    static String productName = "Conditioner";
    static BigDecimal productPrice = new BigDecimal(1.50);
    static int initialQnty = 1;
    static int updatedQnty = 5;
    static int largeQuantity = 100;
    static Product testProduct = new Product(productName, productPrice);
    static CartProduct testCartProduct;
    static int cartIndex = 0;

    @BeforeEach
    public void initCartProduct() {
        testCartProduct = new CartProduct(testProduct, initialQnty);
    }

    @Test
    @DisplayName("Test Initial Quantity")
    public void testInitialQnty() {
        assertEquals(initialQnty, testCartProduct.getQuantity());
    }

    @Test
    @DisplayName("Test Set Quantity")
    public void testUpdateQnty() {
        assertEquals(updatedQnty, testCartProduct.setQuantity(updatedQnty).getQuantity());
    }

    @Test
    @DisplayName("Test Add Quantity")
    public void testAddQuantity() {
        int newQuantity = initialQnty + updatedQnty;
        assertEquals(newQuantity, testCartProduct.addQuantity(updatedQnty).getQuantity());
        assertEquals(newQuantity, testCartProduct.getQuantity());
    }

    @Test
    @DisplayName("Test Remove Partial Quantity")
    public void testRemovePartialQuantity() {
        testCartProduct.addQuantity(updatedQnty);
        assertEquals(initialQnty, testCartProduct.removeQuantity(updatedQnty));
        assertEquals(initialQnty, testCartProduct.getQuantity());
    }

    @Test
    @DisplayName("Test Remove Equal Quantity")
    public void testRemoveEqualQuantity() {
        assertEquals(0, testCartProduct.removeQuantity(initialQnty));
        assertEquals(0, testCartProduct.getQuantity());
    }

    @Test
    @DisplayName("Test Remove Greater then Quantity")
    public void testRemoveGreaterQuantity() {
        assertEquals(0, testCartProduct.removeQuantity(largeQuantity));
        assertEquals(0, testCartProduct.getQuantity());
    }

    @Test
    @DisplayName("Test Get Product Price")
    public void testGetProductPrice() {
        assertEquals(productPrice, testCartProduct.getProductPrice());
    }

    @Test
    @DisplayName("Test Get Product Name")
    public void testGetProductName() {
        assertEquals(productName, testCartProduct.getProductName());
    }

    @Test
    @DisplayName("Test Get Product Extended Price for Qnty 1")
    public void testGetProductExtendedPrice() {
        assertEquals(productPrice, testCartProduct.getExtendedPrice());
    }

    @Test
    @DisplayName("Test Get Product Extended Price for Qnty 5")
    public void testGetProductExtendedPriceForFive() {
        testCartProduct.setQuantity(updatedQnty);
        assertEquals(productPrice.multiply(new BigDecimal(updatedQnty)),
                testCartProduct.getExtendedPrice());
    }

    @Test
    @DisplayName("Test Get Product Extended Price for Qnty 0")
    public void testGetProductExtendedPriceForZero() {
        testCartProduct.setQuantity(0);
        assertEquals(productPrice.multiply(BigDecimal.ZERO),
                testCartProduct.getExtendedPrice());
    }
}