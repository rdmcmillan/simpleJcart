package step1;

import java.math.BigDecimal;

public class Shopping {

    static Product doveSoap = new Product("Dove Soap", BigDecimal.valueOf(39.99));
    static Product axeDeo = new Product("Axe Deo", BigDecimal.valueOf(99.99));


    public static void main(String[] args){
        Cart userCart = new Cart();

        System.out.println("Step 1");
        System.out.println("There are " + userCart.getPieceCount() + " piece(s) in the cart");

        System.out.println("Adding 5 Dove Soaps to the cart...");
        userCart.updateCart(doveSoap, 5);

        System.out.println("There are now " + userCart.getPieceCount() + " piece(s) in the cart");

        System.out.println("Cart net total (before tax) is: $" + userCart.getCartNetTotal());

        System.out.println("Thank you for your order!");

        System.out.println("Step 1");
        userCart.emptyCart();
        System.out.println("There are " + userCart.getPieceCount() + " piece(s) in the cart");

        System.out.println("Adding five Dove Soap to the cart...");
        userCart.updateCart(doveSoap, 5);

        System.out.println("Adding three Dove Soap to the cart...");
        userCart.updateCart(doveSoap, 3);

        System.out.println("There are now " + userCart.getCartProduct(doveSoap.getSku()).getQuantity() + " in the cart.");
        System.out.println("The cart's total is $" + userCart.getCartNetTotal());

        System.out.println("Thank you for your order!");

        System.out.println("Step 3");
        userCart.emptyCart();
        System.out.println("There are " + userCart.getPieceCount() + " piece(s) in the cart");

        userCart.updateCart(doveSoap, 2);
        userCart.updateCart(axeDeo, 2);

        CartProduct cartDove = userCart.getCartProduct(doveSoap.getSku());
        System.out.println("There are " + cartDove.getQuantity() + " " + cartDove.getProductName() + " in the cart");
        System.out.println("The unit price is $" + cartDove.getProductPrice());

        CartProduct cartAxe = userCart.getCartProduct(axeDeo.getSku());
        System.out.println("There are " + cartAxe.getQuantity() + " " + cartAxe.getProductName() + " in the cart");
        System.out.println("The unit price is $" + cartAxe.getProductPrice());

        System.out.println("The total sales tax amount is $" + userCart.getTotalTax());
        System.out.println("The total price is $" + userCart.getTotalWithTax());

        System.out.println("Thank you for your order!");

    }

}
