package step1;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

    private String name;
    private BigDecimal price;
    private UUID sku;

    public Product(String productName, BigDecimal productPrice){
        name = productName;
        price = productPrice;
        sku = UUID.randomUUID();
    }

    public String getName(){
     return name;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public UUID getSku() {
        return sku;
    }

}
