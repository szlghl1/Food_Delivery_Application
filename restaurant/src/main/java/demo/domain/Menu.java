package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ling on 4/27/17.
 */
@Entity
@Table(name = "MENU")
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Menu {
    @Id
    @GeneratedValue
    private final int id;

    @OneToMany
    private List<MenuItem> menuItems;

    private final int restaurantId;

}
