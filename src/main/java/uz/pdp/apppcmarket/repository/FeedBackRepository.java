package uz.pdp.apppcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.apppcmarket.entity.Feedback;
import uz.pdp.apppcmarket.projection.CustomFeedback;

@RepositoryRestResource(path = "feedback",excerptProjection = CustomFeedback.class)
public interface FeedBackRepository extends JpaRepository<Feedback,Integer> {
}
