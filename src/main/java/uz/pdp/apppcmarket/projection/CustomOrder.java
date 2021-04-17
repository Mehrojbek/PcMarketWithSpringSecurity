package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Basket;
import uz.pdp.apppcmarket.entity.Customer;
import uz.pdp.apppcmarket.entity.Order;

@Projection(types = Order.class)
public interface CustomOrder {

    Integer getId();

    Basket getBasket();

    Customer getCustomer();
}
