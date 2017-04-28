package demo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Ling on 4/27/17.
 */
@Table(name = "RESTAURANT")
@Data
public class Restaurant {
    @Id
    @GeneratedValue
    private final int id;

    @OneToMany
    private List<Menu> menus;

    private String owner;

    private String description;

    private String address;
}
