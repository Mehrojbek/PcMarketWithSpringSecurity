package uz.pdp.apppcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.apppcmarket.entity.Basket;
import uz.pdp.apppcmarket.entity.Characteristic;
import uz.pdp.apppcmarket.projection.CustomBasket;

@RepositoryRestResource(path = "characteristic",excerptProjection = Characteristic.class)
public interface CharacteristicRepository extends JpaRepository<Basket,Integer> {
}
