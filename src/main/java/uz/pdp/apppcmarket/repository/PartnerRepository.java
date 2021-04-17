package uz.pdp.apppcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.apppcmarket.entity.Partner;
import uz.pdp.apppcmarket.projection.CustomPartner;

@RepositoryRestResource(path = "partner",excerptProjection = CustomPartner.class)
public interface PartnerRepository extends JpaRepository<Partner,Integer> {
}
