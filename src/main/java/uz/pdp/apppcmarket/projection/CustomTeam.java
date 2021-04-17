package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Attachment;
import uz.pdp.apppcmarket.entity.Basket;
import uz.pdp.apppcmarket.entity.Team;

@Projection(types = Team.class)
public interface CustomTeam {

    Integer getId();

    String getFullName();

    String getRole();

    Attachment getAttachment();
}
