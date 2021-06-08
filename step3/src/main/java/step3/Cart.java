package step3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.UUID;

public class Cart {

    private HashMap<UUID, CartProduct> cartProducts;
    private BigDecimal taxRate = new BigDecimal(0.125);

    public Cart() {
        cartProducts = new HashMap<UUID, CartProduct>();
    }

    public void updateCart(Product product, int changeQnty) {
        UUID productSku = product.getSku();

        if (! (cartProducts.containsKey(productSku))) {
            CartProduct cartProduct = new CartProduct(product, changeQnty);
            cartProducts.put(productSku, cartProduct);
        } else {
            updateCartProductQnty(productSku, changeQnty);
        }
    }

    public void updateCartProductQnty(UUID productSku, int changeQnty) {
        CartProduct cartProduct = cartProducts.get(productSku);
        int currentQnty = cartProduct.getQuantity();
        int newQnty = (changeQnty == 0) ? 0 : currentQnty + changeQnty;

        if (changeQnty > 0) {
            cartProducts.put(productSku, cartProduct.setQuantity(newQnty));
        } else {
            cartProducts.remove(productSku);
        }
    }

    public CartProduct getCartProduct(UUID productSku) {
    return cartProducts.get(productSku);
    }

    public int getProductCount() {
        return cartProducts.size();
    }

    public int getPieceCount() {
        var counterRef = new Object() {
            int count = 0;
        };

        cartProducts.forEach((uuid, product) ->
                counterRef.count = counterRef.count + product.getQuantity());

        return counterRef.count;
    }

    public BigDecimal getCartNetTotal() {
        var totalRef = new Object() {
            BigDecimal total = BigDecimal.ZERO;
        };

        cartProducts.forEach((uiid, product) ->
                totalRef.total = totalRef.total.add(product.getExtendedPrice())
        );

        return totalRef.total.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTaxRate(){
        return taxRate;
    }

    public BigDecimal getTotalTax() {
        BigDecimal net = this.getCartNetTotal();
        return net.multiply(taxRate).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalWithTax() {
        return this.getCartNetTotal().add(this.getTotalTax());
    }

    public void emptyCart() {
        cartProducts.clear();
    }
}
