package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Attachment;
import uz.pdp.apppcmarket.entity.Basket;
import uz.pdp.apppcmarket.entity.Product;

@Projection(types = Basket.class)
public interface CustomBasket {

    Integer getId();

    String getCode();
}
