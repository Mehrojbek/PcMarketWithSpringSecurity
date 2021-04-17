package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Basket;
import uz.pdp.apppcmarket.entity.BasketProduct;
import uz.pdp.apppcmarket.entity.Product;

@Projection(types = BasketProduct.class)
public interface CustomBasketProduct {

    Integer getId();

    Product getProduct();

    Integer getAmount();
}
