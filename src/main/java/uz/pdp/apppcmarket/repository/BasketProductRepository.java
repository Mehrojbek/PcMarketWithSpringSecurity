package uz.pdp.apppcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.apppcmarket.entity.Basket;
import uz.pdp.apppcmarket.projection.CustomBasket;
import uz.pdp.apppcmarket.projection.CustomBasketProduct;

@RepositoryRestResource(path = "basketProduct",excerptProjection = CustomBasketProduct.class)
public interface BasketProductRepository extends JpaRepository<Basket,Integer> {
}
