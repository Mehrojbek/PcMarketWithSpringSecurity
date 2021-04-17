package uz.pdp.apppcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.apppcmarket.entity.Product;
import uz.pdp.apppcmarket.projection.CustomProduct;


import java.util.*;

@RepositoryRestResource(path = "product",excerptProjection = CustomProduct.class)
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(value = "select * from product p join characteristic ch on p.id=ch.product_id " +
            "join property pr on ch.id=pr.characteristic_id where pr.id in:id",
            nativeQuery = true)
    List<Product> getAllByProperty(List<Integer> id);

    @RestResource(path = "byPrice")
    List<Product> findAllByPriceBetween(@Param("from") Double from,@Param("to") Double to);

}
