package demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ling on 4/27/17.
 */
@Table(name = "MENU")
@Data
public class Menu {
    @Id
    @GeneratedValue
    private final int id;

    @OneToMany
    private List<MenuItem> menuItems;

    private final int restaurantId;
}
