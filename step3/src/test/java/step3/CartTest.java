package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    static Product product1 = new Product("Product 1", new BigDecimal(0.50));
    static Product product2 = new Product("Product 2", new BigDecimal(1.50));
    static Product product3 = new Product("Product 3", new BigDecimal(25.00));
    int product1Qnty = 1;
    int product2Qnty = 5;
    int product3Qnty = 10;
    static Cart testCart;
    static BigDecimal currentTaxRate = new BigDecimal(0.125);
    static BigDecimal zeroDollars = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);

    @BeforeEach
    public void initCart() {
        testCart = new Cart();
    }

    @Test
    @DisplayName("Test Add Initial Product to Cart")
    public void addInitialProduct() {
        testCart.updateCart(product1, product1Qnty);
    }

    @Test
    @DisplayName("Test Initial Cart Product Count")
    public void testInitialProductCount() {
        assertEquals(0, testCart.getProductCount());
    }

    @Test
    @DisplayName("Test Initial Cart Product Count Single")
    public void testSingleProductCount() {
        testCart.updateCart(product1, product1Qnty);
        assertEquals(1, testCart.getProductCount());
    }

    @Test
    @DisplayName("Test Initial Cart Product Count Mulitiples")
    public void testMultipleProductCount() {
        testCart.updateCart(product1, product1Qnty);
        testCart.updateCart(product2, product2Qnty);
        testCart.updateCart(product3, product3Qnty);
        assertEquals(3, testCart.getProductCount());
    }

    @Test
    @DisplayName("Test Get Initial Piece Count")
    public void testInitialCount() {
        assertEquals(0, testCart.getPieceCount());
    }

    @Test
    @DisplayName("Test Get Piece Count One Product")
    public void testPieceCountOneProduct() {
        testCart.updateCart(product1, product1Qnty);
        System.out.println(testCart.getPieceCount());
        assertEquals(1, testCart.getPieceCount());
    }

    @Test
    @DisplayName("Test Get Piece Count Two Products")
    public void testPieceCountTwpProducts() {
        testCart.updateCart(product1, product1Qnty);
        testCart.updateCart(product2, product2Qnty);
        int pieceCount = product1Qnty + product2Qnty;
        assertEquals(pieceCount, testCart.getPieceCount());
    }

    @Test
    @DisplayName("Test Cart Net Total for Zero Products")
    public void testGetCartNetTotalForZero() {
        assertEquals(zeroDollars, testCart.getCartNetTotal());
    }

    @Test
    @DisplayName("Test Cart Net Total for One Product One Piece")
    public void testGetCartNetTotalForOneandOne() {
        testCart.updateCart(product1, product1Qnty);
        BigDecimal productExtendedPrice = product1.getPrice();
        assertEquals(productExtendedPrice.setScale(2, RoundingMode.HALF_UP),
                testCart.getCartNetTotal());
    }

    @Test
    @DisplayName("Test Cart Net Total for Multiples")
    public void testGetCartNetTotalForMultiples() {
        BigDecimal extendedPrice1 = product1.getPrice().multiply(new BigDecimal(product1Qnty));
        BigDecimal extendedPrice2 = product2.getPrice().multiply(new BigDecimal(product2Qnty));
        BigDecimal extendedPrice3 = product3.getPrice().multiply(new BigDecimal(product3Qnty));
        BigDecimal netTotal = extendedPrice1.add(extendedPrice2.add(extendedPrice3));

        testCart.updateCart(product1, product1Qnty);
        testCart.updateCart(product2, product2Qnty);
        testCart.updateCart(product3, product3Qnty);

        assertEquals(netTotal.setScale(2, RoundingMode.HALF_UP),
                testCart.getCartNetTotal());
    }

    @Test
    @DisplayName("Test Get Tax Rate")
    public void testGetTaxRate() {
        assertEquals(currentTaxRate, testCart.getTaxRate());
    }

    @Test
    @DisplayName("Test Cart Total Tax for Zero")
    public void testTotalTaxForZero() {
        assertEquals(zeroDollars, testCart.getTotalTax());
    }

    @Test
    @DisplayName("Test Cart Total Tax for One")
    public void testTotalTaxForOne() {
        BigDecimal netPrice = product1.getPrice().multiply(BigDecimal.valueOf(product1Qnty));
        BigDecimal totalTax = netPrice.multiply(testCart.getTaxRate());

        testCart.updateCart(product1, product1Qnty);

        assertEquals(totalTax.setScale(2, RoundingMode.HALF_UP),
                testCart.getTotalTax());
    }

    @Test
    @DisplayName("Test Add quantities to cart product")
    public void testAddQuanities(){
        testCart.updateCart(product1, product1Qnty);
        int addQnty = 10;
        int newQnty = addQnty + product1Qnty;
        UUID sku = product1.getSku();

        testCart.updateCart(product1, addQnty);

        assertEquals(newQnty, testCart.getCartProduct(sku).getQuantity());
    }

    @Test
    @DisplayName("Test to get Cart Product")
    public void testGetCartProduct() {
        UUID sku = product3.getSku();
        String name = product3.getName();
        testCart.updateCart(product3, product3Qnty);

        assertEquals(name, testCart.getCartProduct(sku).getProductName());
    }

    @Test
    @DisplayName("Test Emptying Cart")
    public void testEmptyingCart() {
            testCart.updateCart(product1, product1Qnty);
            testCart.emptyCart();
            assertEquals(0, testCart.getPieceCount());
    }
}
