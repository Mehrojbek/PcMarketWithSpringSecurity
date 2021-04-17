package uz.pdp.apppcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.apppcmarket.entity.Basket;
import uz.pdp.apppcmarket.projection.CustomBasket;
import uz.pdp.apppcmarket.projection.CustomTeam;

@RepositoryRestResource(path = "team",excerptProjection = CustomTeam.class)
public interface TeamRepository extends JpaRepository<Basket,Integer> {
}
