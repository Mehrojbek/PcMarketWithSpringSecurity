package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Attachment;
import uz.pdp.apppcmarket.entity.Category;
import uz.pdp.apppcmarket.entity.Product;

@Projection(types = Attachment.class)
public interface CustomAttachment {

    Integer getId();

    String getOriginalName();

    String getContentType();

    Long getSize();

    Product getProduct();
}
