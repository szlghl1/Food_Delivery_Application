package demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Ling on 4/27/17.
 */
@Entity
@Table(name = "RESTAURANT")
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Restaurant {
    @Id
    @GeneratedValue
    private final int id;

    private String name;

    @OneToMany
    private List<Menu> menus;

    private String owner;

    private String description;

    private String address;
}
