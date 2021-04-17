package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Currency;
import uz.pdp.apppcmarket.entity.Customer;

@Projection(types = Customer.class)
public interface CustomCustomer {

    Integer getId();

    String getName();

    String getAddress();

    String getPhoneNumber();

    String getEmail();
}
