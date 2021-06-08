package step2;

import java.math.BigDecimal;

public class Step2Shopping {

    static Product doveSoap = new Product("Dove Soap", BigDecimal.valueOf(39.99));

    public static void main(String[] args){
        Cart userCart = new Cart();

        System.out.println("Step 2");
        userCart.emptyCart();
        System.out.println("There are " + userCart.getPieceCount() + " piece(s) in the cart");

        System.out.println("Adding five Dove Soap to the cart...");
        userCart.updateCart(doveSoap, 5);

        System.out.println("Adding three Dove Soap to the cart...");
        userCart.updateCart(doveSoap, 3);

        System.out.println("There are now " + userCart.getCartProduct(doveSoap.getSku()).getQuantity() + " in the cart.");
        System.out.println("The cart's total is $" + userCart.getCartNetTotal());

        System.out.println("Thank you for your order!");

    }

}
