package uz.pdp.apppcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.apppcmarket.entity.Basket;
import uz.pdp.apppcmarket.entity.Currency;
import uz.pdp.apppcmarket.projection.CustomBasket;

@RepositoryRestResource(path = "currency",excerptProjection = Currency.class)
public interface CurrencyRepository extends JpaRepository<Basket,Integer> {
}
