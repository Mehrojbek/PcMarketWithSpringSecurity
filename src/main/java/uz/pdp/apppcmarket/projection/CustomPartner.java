package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Partner;

@Projection(types = Partner.class)
public interface CustomPartner {

    Integer getId();

    String getName();

    String getEmail();

    String getMessage();

}
