package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Characteristic;
import uz.pdp.apppcmarket.entity.Product;

@Projection(types = Characteristic.class)
public interface CustomCharacteristic {

    Integer getId();

    String getName();

    Product getProduct();
}
