package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Characteristic;
import uz.pdp.apppcmarket.entity.Product;
import uz.pdp.apppcmarket.entity.Property;

@Projection(types = Property.class)
public interface CustomProperty {

    Integer getId();

    String getValue();

    Characteristic getCharacteristic();
}
