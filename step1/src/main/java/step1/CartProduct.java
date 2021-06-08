package step1;


import java.math.BigDecimal;

public class CartProduct {
    private Product cartProduct;
    private int qnty;

    public CartProduct(Product product, int productQnty) {
        cartProduct = product;
        qnty = productQnty;

    }

    public int getQuantity() {
        return qnty;
    }

    public CartProduct setQuantity(int newQnty) {
        qnty = newQnty;
        return this;
    }

    public CartProduct addQuantity(int additiveQnty) {
        qnty = qnty + additiveQnty;
        return this;
    }

    public int removeQuantity(int subtractiveQnty) {
        if (qnty >= subtractiveQnty) {
            qnty = qnty - subtractiveQnty;
        } else {
            qnty = 0;       // Prevent negative quantities.
        }
        return qnty;
    }

    public BigDecimal getProductPrice() {
        return cartProduct.getPrice();
    }

    public String getProductName() {
        return cartProduct.getName();
    }

    public BigDecimal getExtendedPrice() {
        BigDecimal unitPrice = cartProduct.getPrice();
        return unitPrice.multiply(new BigDecimal(qnty));
    }
}
