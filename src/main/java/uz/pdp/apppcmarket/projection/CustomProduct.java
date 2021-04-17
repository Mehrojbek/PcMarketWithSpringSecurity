package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Category;
import uz.pdp.apppcmarket.entity.Currency;
import uz.pdp.apppcmarket.entity.Product;

@Projection(types = Product.class)
public interface CustomProduct {

    Integer getId();

    String getName();

    String getDescription();

    Double getPrice();

    Category getCategory();

    String getWarranty();

    Currency getCurrency();

    boolean getSale();

    Double getSalePrise();


}
